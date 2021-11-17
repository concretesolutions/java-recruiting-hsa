package cl.mobile.api.backend.response;

import java.util.ArrayList;
import java.util.HashMap;
/** respuesta genérica */
public class ResponseRest {
	
	private ArrayList<HashMap<String, String>> metadata = new ArrayList<>();

	public void setMetadata(String tipo, String codigo, String valor) 
	{
		HashMap<String, String> mapa = new HashMap<String, String>();
		mapa.put("tipo",tipo);
		mapa.put("codigo",codigo);
		mapa.put("valor", valor);
		metadata.add(mapa);
	}
	
	public void setMetadata(ArrayList<HashMap<String, String>> metadata) {
		this.metadata = metadata;
	}

	public ArrayList<HashMap<String, String>> getMetadata() {
		return metadata;
	}

}
