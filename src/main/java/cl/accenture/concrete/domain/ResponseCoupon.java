package cl.accenture.concrete.domain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCoupon implements Serializable {

	/**
	 * @author juan.horta.lucero
	 */
	private static final long serialVersionUID = 2805286903544855199L;
	
	@JsonProperty("id")
	private String id;
	@JsonProperty("description")
	private String description;
	@JsonProperty("seller")
	private String seller;
	@JsonProperty("image")
	private String image;
	@JsonProperty("expiresAt")
	private String expiresAt;
	
	public String getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public String getSeller() {
		return seller;
	}
	public String getImage() {
		return image;
	}
	public String getExpiresAt() {
		return expiresAt;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setExpiresAt(String expiresAt) {
		this.expiresAt = expiresAt;
	}
	
	public boolean isValidDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = new GregorianCalendar();
		Date expiresAt;
		try {
			expiresAt = sdf.parse(getExpiresAt());
			if(expiresAt.compareTo(cal.getTime()) >= 0)
			{
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
			
		return false;
	}
}
