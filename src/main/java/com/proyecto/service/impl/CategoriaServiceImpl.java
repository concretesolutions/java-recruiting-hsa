package com.proyecto.service.impl;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.dto.Category;
import com.proyecto.service.ICategoriaService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

	@Value("${servicio.url.categorias}")
	private String urlServicio;

	@Override
	public Category obtener() {
		try {
			Client client = Client.create();
			WebResource webResource = client.resource(urlServicio);
			ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);

			if (response.getStatus() == 200) {
				ObjectMapper mapper = new ObjectMapper();
				String jsonResponse = response.getEntity(String.class);

				Category respuestaApi = mapper.readValue(jsonResponse, Category.class);
				return respuestaApi;
			} else {
				return null;
			}
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public void filtrarImagenesMobile(List<Category> subcategories) {

		for (Category c : subcategories) {
			c.setLargeImageUrl(null);
			c.setMediumImageUrl(null);
			c.setIconImageUrl(null);

			if (c.getSubcategories() != null && !c.getSubcategories().isEmpty())
				this.filtrarImagenesMobile(c.getSubcategories());
		}

	}

}
