package com.concrete.javarecruitinghsa.dto.coupon;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor 
@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Coupon {
	String id;
	String description;
	String seller;
	String image;
	LocalDate expiresAt;	
}

