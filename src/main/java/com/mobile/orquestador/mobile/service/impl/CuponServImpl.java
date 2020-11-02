package com.mobile.orquestador.mobile.service.impl;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobile.orquestador.mobile.dto.CouponsDto;
import com.mobile.orquestador.mobile.repository.IWsFctryRep;
import com.mobile.orquestador.mobile.service.ICouponServ;
import com.mobile.orquestador.mobile.util.Constants;
import com.mobile.orquestador.mobile.util.FuntionUtil;
import com.sun.jersey.api.client.ClientResponse;

@Service("cuponServImpl")
public class CuponServImpl implements ICouponServ {

	@Qualifier("IWsFctryRep")
	@Autowired
	private IWsFctryRep objIWsFctryRep;

	@Autowired
	private ObjectMapper objMapper;

	private static final Logger objLog = LoggerFactory.getLogger(CuponServImpl.class);

	@Override
	public List<CouponsDto> list() {

		try {

			ClientResponse objClientResponse = objIWsFctryRep.get(Constants.URL_COUPONS);

			if (objClientResponse.getStatus() == Constants.STATUS_CODE_OK) {
				String jsonResponse = objClientResponse.getEntity(String.class);
				return (null != jsonResponse)
						? objMapper.readValue(jsonResponse, new TypeReference<List<CouponsDto>>() {
						})
						: Collections.emptyList();
			}

			FuntionUtil.statusFailed(objClientResponse, Constants.URL_COUPONS);

		} catch (IOException ex) {
			objLog.info(Constants.JSON_CONVERT_ERROR, ex);
			throw new IllegalArgumentException();
		} catch (Exception ex) {
			objLog.error(Constants.ERROR_SERVICE, ex);
			throw new IllegalArgumentException();
		}

		return Collections.emptyList();
	}

}
