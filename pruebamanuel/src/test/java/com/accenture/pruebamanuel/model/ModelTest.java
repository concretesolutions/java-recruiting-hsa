package com.accenture.pruebamanuel.model;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.pruebamanuel.util.VerificadorGetterSetter;

@RunWith(SpringRunner.class)
public class ModelTest {

	@Test
	public void testModelo() throws IOException, ClassNotFoundException {

		VerificadorGetterSetter.testPackageTO("com.accenture.pruebamanuel.model");
	}
}
