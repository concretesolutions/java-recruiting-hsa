package com.accenture.test.service;

import java.util.List;

import com.accenture.test.dto.Coupons;

public interface CouponsService {

	List<Coupons> getCouponsNotExpired();
}
