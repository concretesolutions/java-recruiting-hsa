package com.desafio.java.concrete.backend.domains;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
@Builder
public class CarruselNotExpired {

    String iconImageUrl;
    String name;
    Date expiresAt;
}
