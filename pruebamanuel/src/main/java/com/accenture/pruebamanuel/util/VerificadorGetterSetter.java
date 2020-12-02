package com.accenture.pruebamanuel.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

import org.junit.Assert;

import com.google.common.base.Defaults;

import lombok.extern.log4j.Log4j2;

/**
 * Helper de cobertura para Modelos.
 *
 * @param <T> .
 * @author Manuel Jimenez.
 */
@Log4j2
public class VerificadorGetterSetter<T> {

	/**
	 * Tipo.
	 */
	private Class<T> type;

	/**
	 * Incluidos.
	 */
	private Set<String> includes;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void testModelTO(List<Class> list) {

		for (Class classToTest : list) {
			log.debug("Testing class {}", classToTest);
			VerificadorGetterSetter.forClass(classToTest).verificar();
			try {
				Assert.assertNotNull(classToTest.newInstance().toString());
			} catch (InstantiationException | IllegalAccessException a) {
				Assert.assertNotNull(classToTest.toString());
			}
		}
	}

	private VerificadorGetterSetter(final Class<T> type) {

		this.type = type;
	}

	public void verificar() {

		try {
			final BeanInfo beanInfo = Introspector.getBeanInfo(type);
			final PropertyDescriptor[] properties = beanInfo.getPropertyDescriptors();

			for (final PropertyDescriptor property : properties) {
				if (debeTestearPropiedad(property)) {
					testearPropiedad(property);
				}
			}
		} catch (final Exception e) {
			throw new AssertionError(e.getMessage());
		}
	}

	private boolean debeTestearPropiedad(final PropertyDescriptor property) {

		if (property.getWriteMethod() == null || property.getReadMethod() == null) {
			return false;
		}
		return includes == null || includes.contains(property.getDisplayName());
	}

	private void testearPropiedad(final PropertyDescriptor property)
			throws IllegalAccessException, InstantiationException, InvocationTargetException {

		log.debug("Testing property {}", property.getName());

		final Object target = type.newInstance();
		final Method getter = property.getReadMethod();
		final Method setter = property.getWriteMethod();

		Object setValue = Defaults.defaultValue(property.getPropertyType());

		Object defaultValue = getter.invoke(target);

		if ((setValue != null && !setValue.equals(defaultValue))
				|| (defaultValue != null && !defaultValue.equals(setValue))) {
			log.warn("Non default value -> {}", defaultValue);
			setValue = defaultValue;
		}

		setter.invoke(target, setValue);
		final Object getValue = getter.invoke(target);
		assertEquals(property.getDisplayName() + " getter / setter do not produce the same result.", setValue,
				getValue);
		assertNotNull(target);
		Boolean equals = target.equals(type.newInstance());
		log.debug("New instance equals: {}", equals);
		log.debug("Target hashcode: {}", target.hashCode());
		assertNotEquals(target, Object.class);
		assertEquals(target, target);
		assertNotNull(target.toString());
	}

	public static <T> VerificadorGetterSetter<T> forClass(final Class<T> type) {

		return new VerificadorGetterSetter<>(type);
	}

	/**
	 * Scans all classes accessible from the context class loader which belong to
	 * the given package and subpackages.
	 *
	 * @param packageName The base package
	 * @return The classes
	 * @throws ClassNotFoundException Class not found
	 * @throws IOException            IO Exception
	 */
	@SuppressWarnings({ "rawtypes" })
	public static void testPackageTO(String packageName) throws ClassNotFoundException, IOException {

		log.debug("Testing package {}", packageName);

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		assert classLoader != null;
		String path = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File> dirs = new ArrayList<>();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			dirs.add(new File(resource.getFile().replace("%20", " ")));
		}
		ArrayList<Class> classes = new ArrayList<>();
		for (File directory : dirs) {
			classes.addAll(findClasses(directory, packageName));
		}
		testModelTO(Arrays.asList(classes.toArray(new Class[0])));
	}

	/**
	 * Recursive method used to find all classes in a given directory and subdirs.
	 *
	 * @param directory   The base directory
	 * @param packageName The package name for classes found inside the base
	 *                    directory
	 * @return The classes
	 * @throws ClassNotFoundException Class not found
	 */
	@SuppressWarnings("rawtypes")
	private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {

		List<Class> classes = new ArrayList<>();
		if (!directory.exists()) {
			return classes;
		}
		File[] files = directory.listFiles();
		assert files != null;
		for (File file : files) {
			if (file.isDirectory()) {
				assert !file.getName().contains(".");
				classes.addAll(findClasses(file, packageName + "." + file.getName()));
			} else if (file.getName().endsWith(".class")) {
				classes.add(
						Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
			}
		}
		return classes;
	}

}
