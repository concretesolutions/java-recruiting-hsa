package com.mobile.orquestador.mobile.util;

public class Constants {

	private Constants() {
	}

	// Execution code
	public static final String SUCCESSFUL_RULE = "001";
	public static final String NO_DATA_RULE = "002";
	public static final String API_RULE_ERROR = "003";

	// Status
	public static final int STATUS_CODE_OK = 200;
	public static final int STATUS_CODE_NO_CONTENT = 204;
	public static final int STATUS_CODE_BAD_REQUEST = 400;
	public static final int STATUS_CODE_NO_FOUND = 404;
	public static final int STATUS_CODE_INTERNAL_SERVER_ERROR = 500;

	// Message
	public static final String API_ERROR_MESSAGE = "Error in api rest service ";
	public static final String RULE_SUCCESSFUL_MESSAGE = "Rule applied correctly";
	public static final String RULE_NOT_SUCCESSFUL_MESSAGE = "Rule not applied";

	// Errors
	public static final String JSON_CONVERT_ERROR = "Error converting json response to object";
	public static final String ERROR_SERVICE = "an error occurred while consuming the api.";

	// Url Apis
	public static final String URL_CATEGORIES = "https://cs-hsa-api-categories.herokuapp.com/categories";
	public static final String URL_COUPONS = "https://cs-hsa-api-coupons.herokuapp.com/coupons";

}
