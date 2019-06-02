package com.aptiliux.dto.coupon;

import java.util.Date;

import com.aptiliux.dto.json.view.Views;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CouponDTO {
	@JsonView(Views.Mobile.class)
    private String id;
	@JsonView(Views.Mobile.class)
    private String decription;
	@JsonView(Views.Mobile.class)
    private String seller;
	@JsonView(Views.Mobile.class)
    private String image;
	@JsonView(Views.Mobile.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date expiresAt;

}
