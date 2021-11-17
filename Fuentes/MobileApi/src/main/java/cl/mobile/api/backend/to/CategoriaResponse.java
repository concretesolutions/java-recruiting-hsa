package cl.mobile.api.backend.to;

import java.util.List;

import cl.mobile.api.backend.from.CategoriesRootApi;

public class CategoriaResponse {
	
	private List<Categoria> categoria;

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}

}
