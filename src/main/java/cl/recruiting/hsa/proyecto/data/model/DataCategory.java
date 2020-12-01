package cl.recruiting.hsa.proyecto.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "data_category")
public class DataCategory {
    @Id
    @Column(name = "id", nullable = true, length=255)
    private String id;
    
    @Column(name = "name", nullable = true, length=255)
    private String name;
    
 	
  	private Integer relevance;

  	@Column(name = "datos_json", nullable = true, length=4000)
	private String datosJson;

	public DataCategory() {
		super();
	}
  	
	public DataCategory(String id, String name,  Integer relevance, String datosJson) {
		super();
		this.id = id;
		this.name = name;
		this.relevance = relevance;
		this.datosJson = datosJson;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRelevance() {
		return relevance;
	}

	public void setRelevance(Integer relevance) {
		this.relevance = relevance;
	}

	public String getDatosJson() {
		return datosJson;
	}

	public void setDatosJson(String datosJson) {
		this.datosJson = datosJson;
	}
  	
  	
}
