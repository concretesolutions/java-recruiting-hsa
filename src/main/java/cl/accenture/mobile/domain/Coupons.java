
package cl.accenture.mobile.domain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author andrea.rojas.ruiz
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Coupons implements Serializable {
	private final static long serialVersionUID = -6548399004797743769L;

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

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("seller")
	public String getSeller() {
		return seller;
	}

	@JsonProperty("seller")
	public void setSeller(String seller) {
		this.seller = seller;
	}

	@JsonProperty("image")
	public String getImage() {
		return image;
	}

	@JsonProperty("image")
	public void setImage(String image) {
		this.image = image;
	}

	@JsonProperty("expiresAt")
	public String getExpiresAt() {
		return expiresAt;
	}

	@JsonProperty("expiresAt")
	public void setExpiresAt(String expiresAt) {
		this.expiresAt = expiresAt;
	}

	public boolean isNotExpired() {
		Calendar cal = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date expiresAt = null;
		boolean valid = false;
		try {
			expiresAt = sdf.parse(getExpiresAt());

			if (expiresAt.after(cal.getTime()) || expiresAt.equals(cal.getTime()))
				valid = true;

		} catch (ParseException e) {
			return valid;
		}
		return valid;

	}

}