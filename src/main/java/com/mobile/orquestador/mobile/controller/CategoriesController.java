package com.mobile.orquestador.mobile.controller;

import java.util.ArrayList;
import java.util.Collections;
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

import com.mobile.orquestador.mobile.dto.MessageDto;
import com.mobile.orquestador.mobile.dto.RootDto;
import com.mobile.orquestador.mobile.dto.SubCategoriesDto;
import com.mobile.orquestador.mobile.service.ICategorieServ;
import com.mobile.orquestador.mobile.util.FuntionUtil;
import com.mobile.orquestador.mobile.util.Response;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("/categories")
public class CategoriesController {

	@Autowired
	private ICategorieServ objCategorieServ;

	private static final Logger objLog = LoggerFactory.getLogger(CategoriesController.class);

	@ApiOperation(value = "returns the first 5 categories.", notes = "returns the first 5 categories.", nickname = "topFive")
	@GetMapping(value = "/topFive", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({
			@ApiResponse(code = 204, message = "An error occurred while trying to generate the top five.", response = HttpStatus.class),
			@ApiResponse(code = 200, message = "Top five list generated successfully.", response = MessageDto.class) })
	public ResponseEntity<MessageDto<List<SubCategoriesDto>>> topFive() {

		MessageDto<List<SubCategoriesDto>> objMessage;

		try {

			RootDto categories = objCategorieServ.listTopFive();

			if (null != categories) {
				List<SubCategoriesDto> lstSubCategories = new ArrayList<>();
				categories.getSubcategories().forEach(categorie -> categorie.getSubcategories().stream()
						.forEach(subCategorie -> lstSubCategories.add(subCategorie)));
				objMessage = FuntionUtil
						.objectResponse(lstSubCategories.stream().limit(5).collect(Collectors.toList()));
			} else {
				objMessage = FuntionUtil.objectResponse(Collections.emptyList());
			}

		} catch (Exception ex) {
			objLog.error(ex.getMessage(), ex);
			objMessage = FuntionUtil.objectError(Collections.emptyList(), "ws-topFive.");
		}

		return Response.ok(objMessage);
	}

	@ApiOperation(value = "return the other categories.", notes = "return the other categories.", nickname = "other")
	@GetMapping(value = "/other", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({
			@ApiResponse(code = 204, message = "an error occurred when returning the other categories.", response = HttpStatus.class),
			@ApiResponse(code = 200, message = "other categories successfully generated.", response = MessageDto.class) })
	public ResponseEntity<MessageDto<List<SubCategoriesDto>>> other() {

		MessageDto<List<SubCategoriesDto>> objMessage;

		try {

			RootDto categories = objCategorieServ.listTopFive();

			if (null != categories) {
				List<SubCategoriesDto> lstSubCategories = new ArrayList<>();
				categories.getSubcategories().forEach(categorie -> categorie.getSubcategories().stream()
						.forEach(subCategorie -> lstSubCategories.add(subCategorie)));
				objMessage = FuntionUtil
						.objectResponse(lstSubCategories.stream().skip(5).collect(Collectors.toList()));
			} else {
				objMessage = FuntionUtil.objectResponse(Collections.emptyList());
			}

		} catch (Exception ex) {
			objLog.error(ex.getMessage(), ex);
			objMessage = FuntionUtil.objectError(Collections.emptyList(), "ws-other.");
		}

		return Response.ok(objMessage);
	}

}
