package com.mobile.orquestador.mobile.util;

import java.util.List;

import com.mobile.orquestador.mobile.dto.BaseExceptionDto;
import com.mobile.orquestador.mobile.dto.MessageDto;
import com.sun.jersey.api.client.ClientResponse;

public class FuntionUtil {

	private FuntionUtil() {
	}

	/**
	 * Creates a Message object when a service is consumed.
	 * 
	 * @param T objeto
	 * @return MensajeDto<T>
	 */
	@SuppressWarnings("unchecked")
	public static <T> MessageDto<T> objectResponse(T object) {

		MessageDto<T> objMessage = new MessageDto<>();
		BaseExceptionDto objBaseException = new BaseExceptionDto();

		if (object == null || object.equals(0) || (object instanceof List && ((List<T>) object).isEmpty())) {
			objBaseException.setCode(Constants.NO_DATA_RULE);
			objBaseException.setMessage(Constants.RULE_NOT_SUCCESSFUL_MESSAGE);
		} else {
			objBaseException.setCode(Constants.SUCCESSFUL_RULE);
			objBaseException.setMessage(Constants.RULE_SUCCESSFUL_MESSAGE);
		}

		objMessage.setObject(object);
		objMessage.setStatus(objBaseException);
		return objMessage;
	}

	/**
	 * Creates a Message object when an error occurs while consuming a service.
	 * 
	 * @param T objeto, String strError
	 * @return MensajeDto<T>
	 */
	public static <T> MessageDto<T> objectError(T object, String error) {

		MessageDto<T> objMessage = new MessageDto<>();
		BaseExceptionDto objBaseException = new BaseExceptionDto();

		objBaseException.setCode(Constants.API_RULE_ERROR);
		objBaseException.setMessage(Constants.API_ERROR_MESSAGE.concat(error));
		objMessage.setObject(object);
		objMessage.setStatus(objBaseException);
		return objMessage;

	}

	/**
	 * Validate which is the error code
	 * 
	 * @param clienteResponse, url
	 * @return
	 */
	public static void statusFailed(ClientResponse response, String url) {
		if (response.getStatus() == Constants.STATUS_CODE_NO_CONTENT
				|| response.getStatus() == Constants.STATUS_CODE_BAD_REQUEST
				|| response.getStatus() == Constants.STATUS_CODE_NO_FOUND
				|| response.getStatus() == Constants.STATUS_CODE_INTERNAL_SERVER_ERROR) {
			throw new IllegalArgumentException("Error " + response.getStatus() + " With the service: " + url);
		}
	}

}
