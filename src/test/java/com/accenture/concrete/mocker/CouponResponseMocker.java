package com.accenture.concrete.mocker;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;

import com.accenture.concrete.response.CouponResponse;

public class CouponResponseMocker {
	
	private static int random(int min, int max) {
		return  ((int) (Math.random()*(max - min))) + min;
	}
	
	private static String getRandomId() {
		StringBuilder builder = new StringBuilder("COUPON_");
		int random = random(Integer.MIN_VALUE, Integer.MAX_VALUE);
		builder.append(random);
		return builder.toString();
	}
	
	private static int getRandomYear() {
		int randomYear = random(1, 40);
		return randomYear;
	}

	public static CouponResponse getRandomCoupon(boolean isExpired) {
		
		LocalDate date;
		
		if(!isExpired) {
			date = LocalDate.now().plusYears(getRandomYear());
		}else {
			date = LocalDate.now().minusYears(getRandomYear());
		}
		
		CouponResponse response = new CouponResponse(
				getRandomId(), 
				"descripcion",
				"random-seller",
				"some-url-to-img",
				date);
		
		return response;
		
	}
	
}
