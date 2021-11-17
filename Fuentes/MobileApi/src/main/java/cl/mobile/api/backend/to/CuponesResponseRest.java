package cl.mobile.api.backend.to;

import cl.mobile.api.backend.response.ResponseRest;

public class CuponesResponseRest extends ResponseRest{	
	 
	private CuponesResponse cuponesResponse = new CuponesResponse();

	public CuponesResponse getCuponesResponse() {
		return cuponesResponse;
	}

	public void setCuponesResponse(CuponesResponse cuponesResponse) {
		this.cuponesResponse = cuponesResponse;
	}

}
