package cl.mobile.api.backend.apiClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.mobile.api.backend.config.Properties;
import cl.mobile.api.backend.serviceImpl.CuponesServiceImpl;

/**
 * Implementación de invocación de apis pasadas por parámetro y definidas en 
 * application.properties
 * 
 * Implementación de caché para respuestas de categorias y cupones
 * vigencia seteada en 
 * application.properties
 * spring.cache.caffeine.spec definida inicialmente en 1 día
 * */
@Service
@CacheConfig(cacheNames = {"categorias","cupones"})
public class ApiClient {
	
	@Autowired
    private Properties propiedades;
	
	private static final Logger log = LoggerFactory.getLogger(CuponesServiceImpl.class);
	
	
	public String invoke(String url) {
		
	System.out.println("invoke!!!");
	log.info("invoke");
	RestTemplate plantilla = new RestTemplate();
    String resultado = plantilla.getForObject(url, String.class);
   System.out.println(resultado);
    return resultado;
	}
	
	@Cacheable(cacheNames="cupones")
	public String obtieneCupones() {		
		return this.invoke(propiedades.getEndpointCupones());
	}
	
	@Cacheable(cacheNames="categorias")
	public String obtieneCategorias() 
	{
		return this.invoke(propiedades.getEndpointCategorias());
	}
}
