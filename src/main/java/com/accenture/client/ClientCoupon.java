package com.accenture.client;

import static java.util.Objects.isNull;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accenture.dto.CouponDTO;
import com.accenture.exception.GenericNotFoundException;
import com.accenture.exception.ServiceException;

import lombok.extern.log4j.Log4j2;

/**
 * 
 * @author
 *
 */
@Log4j2
@Service
public class ClientCoupon {

	@Value("${endpoint.coupons}")
	private String url;

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * consulta servicio cupones
	 * 
	 * @return
	 * @throws ServiceException
	 * @throws GenericNotFoundException
	 */
	public List<CouponDTO> call() throws ServiceException, GenericNotFoundException {
		log.debug("call");
		CouponDTO[] resp = null;

		try {
			resp = this.restTemplate.getForObject(this.url, CouponDTO[].class);
		} catch (Exception e) {
			throw new ServiceException("Error al consultar servicio: " + e);
		}
		if (isNull(resp)) {
			throw new GenericNotFoundException("No se encuentran cupones");
		}
		return Arrays.asList(resp);
	}

}
