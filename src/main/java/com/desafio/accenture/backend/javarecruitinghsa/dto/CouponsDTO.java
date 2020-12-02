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
public class CouponsDTO  extends GenericResponse<CouponsDTO> {

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


    public CouponsDTO() {
        super(CouponsDTO.class);
    }

    @Override
    public CouponsDTO buildSuccessResponse() {
        return this;
    }

    @Override
    public <X extends Exception> CouponsDTO buildErrorResponse(X e) {
        CouponsDTO couponsDTO = new CouponsDTO();
        couponsDTO.setCodResponse(Contansts.CODIGO_RESPUESTA_INCORRECTA);
        couponsDTO.setMessage(e.getMessage());
        return this;    }
}
