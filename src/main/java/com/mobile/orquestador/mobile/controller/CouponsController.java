package com.mobile.orquestador.mobile.controller;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.orquestador.mobile.dto.CouponsDto;
import com.mobile.orquestador.mobile.dto.MessageDto;
import com.mobile.orquestador.mobile.service.ICouponServ;
import com.mobile.orquestador.mobile.util.FuntionUtil;
import com.mobile.orquestador.mobile.util.Response;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("/coupons")
public class CouponsController {

	@Autowired
	private ICouponServ objCouponServ;

	private static final Logger objLog = LoggerFactory.getLogger(CouponsController.class);

	@ApiOperation(value = "return all coupons that have not yet expired.", notes = "return all coupons that have not yet expired.", nickname = "list")
	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({
			@ApiResponse(code = 204, message = "there was a problem listing the coupons.", response = HttpStatus.class),
			@ApiResponse(code = 200, message = "list of coupons generated successfully.", response = MessageDto.class) })
	public ResponseEntity<MessageDto<List<CouponsDto>>> list() {

		MessageDto<List<CouponsDto>> objMessage;

		try {

			List<CouponsDto> lstCoupons = objCouponServ.list();

			if (null != lstCoupons && !objCouponServ.list().isEmpty()) {
				objMessage = FuntionUtil.objectResponse(lstCoupons.stream()
						.filter(coupon -> coupon.getExpiresAt().after(new Date())).collect(Collectors.toList()));
			} else {
				objMessage = FuntionUtil.objectResponse(Collections.emptyList());
			}

		} catch (Exception ex) {
			objLog.error(ex.getMessage(), ex);
			objMessage = FuntionUtil.objectError(Collections.emptyList(), "ws-listCoupons.");
		}

		return Response.ok(objMessage);
	}

}
