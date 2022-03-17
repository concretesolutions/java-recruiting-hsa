package recruiting.hsa.accenture.apirest.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import recruiting.hsa.accenture.apirest.pojos.CouponPojo;
import recruiting.hsa.accenture.apirest.servicesImpls.CouponServiceImplements;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/coupons")
public class CouponController {

	@Autowired
	private CouponServiceImplements service;

	@GetMapping(value = "/actives")
	public ResponseEntity<Object> getAllCouponsActives() {

		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date now = new Date();
			
			JSONArray auxResponse = new JSONArray(service.getCoupons());
			List<CouponPojo> pojoList = new ArrayList<CouponPojo>();
			auxResponse.forEach(coupon -> {
				JSONObject auxCoupon = (JSONObject) coupon;
				Date auxDate;
				try {
					auxDate = dateFormat.parse(auxCoupon.getString("expiresAt"));
					if(auxDate.after(now)) {
						pojoList.add(new CouponPojo(auxCoupon));
					}
				} catch (JSONException e) {
					e.printStackTrace();
					throw new Error("Error al recuperar los cupones.");
				} catch (ParseException e) {
					e.printStackTrace();
					throw new Error("Error al identificar la validez del cupón.");
				}
			});

			Map<String, Object> response = new HashMap<String, Object>();
			response.put("coupons", pojoList);

			return new ResponseEntity<Object>(pojoList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getCause(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
