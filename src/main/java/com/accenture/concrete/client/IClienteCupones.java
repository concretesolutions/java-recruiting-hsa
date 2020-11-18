package com.accenture.concrete.client;

import java.util.List;

import com.accenture.concrete.domain.Coupon;

public interface IClienteCupones {

	List<Coupon> getCupones();

	void clearCacheSchedule();
}
