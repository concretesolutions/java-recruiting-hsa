package cl.mobile.api.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
 /**
  * Configuración properties
  * */
@Component
public class Properties {
	
    @Value("${endpointCategorias}")
    private String endpointCategorias;
    
    @Value("${endpointCupones}")
    private String endpointCupones;

	public String getEndpointCategorias() {
		return endpointCategorias;
	}

	public void setEndpointCategorias(String endpointCategorias) {
		this.endpointCategorias = endpointCategorias;
	}

	public String getEndpointCupones() {
		return endpointCupones;
	}

	public void setEndpointCupones(String endpointCupones) {
		this.endpointCupones = endpointCupones;
	}
   
 
}
