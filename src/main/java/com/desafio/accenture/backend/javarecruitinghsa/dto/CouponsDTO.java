package com.desafio.accenture.backend.javarecruitinghsa.dto;

import com.desafio.accenture.backend.javarecruitinghsa.constant.Contansts;
import com.desafio.accenture.backend.javarecruitinghsa.dto.response.GenericResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class CouponsDTO  {

    @JsonProperty("id")
    String id;

    @JsonProperty("description")
    String description;

    @JsonProperty("seller")
    String seller;

    @JsonProperty("image")
    String image;

    @JsonProperty("expiresAt")
    String expiresAt;

}
