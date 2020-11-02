package com.mobile.orquestador.mobile.service.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobile.orquestador.mobile.dto.RootDto;
import com.mobile.orquestador.mobile.repository.IWsFctryRep;
import com.mobile.orquestador.mobile.service.ICategorieServ;
import com.mobile.orquestador.mobile.util.Constants;
import com.mobile.orquestador.mobile.util.FuntionUtil;
import com.sun.jersey.api.client.ClientResponse;

@Service("categoriaServImpl")
public class CategoriaServImpl implements ICategorieServ {

	@Qualifier("IWsFctryRep")
	@Autowired
	private IWsFctryRep objIWsFctryRep;

	@Autowired
	private ObjectMapper objMapper;

	private static final Logger objLog = LoggerFactory.getLogger(CategoriaServImpl.class);

	@Override
	public RootDto listTopFive() {

		try {

			ClientResponse clientResponse = objIWsFctryRep.get(Constants.URL_CATEGORIES);

			if (clientResponse.getStatus() == Constants.STATUS_CODE_OK) {
				String jsonResponse = clientResponse.getEntity(String.class);
				return (null != jsonResponse) ? objMapper.readValue(jsonResponse, new TypeReference<RootDto>() {
				}) : null;
			}

			FuntionUtil.statusFailed(clientResponse, Constants.URL_CATEGORIES);

		} catch (IOException ex) {
			objLog.info(Constants.JSON_CONVERT_ERROR, ex);
			throw new IllegalArgumentException();
		} catch (Exception ex) {
			objLog.error(Constants.ERROR_SERVICE, ex);
			throw new IllegalArgumentException();
		}

		return null;
	}

}
