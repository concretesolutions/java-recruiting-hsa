package com.mobile.orquestador.mobile.repository.service;

import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Repository;

import com.mobile.orquestador.mobile.repository.IWsFctryRep;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Repository("IWsFctryRep")
public class FctryWsImpl implements IWsFctryRep {

	@Override
	public ClientResponse get(String url) {
		return getWebResource(url).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
	}

	private WebResource getWebResource(String url) {
		return Client.create().resource(url);
	}

}
