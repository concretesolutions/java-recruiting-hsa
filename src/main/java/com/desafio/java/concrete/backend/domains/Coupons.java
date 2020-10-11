package com.desafio.java.concrete.backend.domains;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class Coupons {

    String id;
    String description;
    String seller;
    String image;
    Date expiresAt;
}
