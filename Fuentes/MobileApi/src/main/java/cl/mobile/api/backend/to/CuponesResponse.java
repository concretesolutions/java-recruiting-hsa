package cl.mobile.api.backend.to;

import java.util.List;

import cl.mobile.api.backend.from.CategoriesRootApi;

public class CuponesResponse {
	
	private List<Cupon> cupones;

	public List<Cupon> getCupones() {
		return cupones;
	}

	public void setCupones(List<Cupon> cupones) {
		this.cupones = cupones;
	}	 

}
