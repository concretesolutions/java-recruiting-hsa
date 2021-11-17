package cl.mobile.api.backend.to;

import cl.mobile.api.backend.response.ResponseRest;

public class CategoriaResponseRest extends ResponseRest{
	
	private CategoriaResponse categoriaResponse = new CategoriaResponse();

	public CategoriaResponse getCategoriaResponse() {
		return categoriaResponse;
	}

	public void setCategoriaResponse(CategoriaResponse categoriaResponse) {
		this.categoriaResponse = categoriaResponse;
	}
}
