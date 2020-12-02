package com.desafio.accenture.backend.javarecruitinghsa.dto;

import com.desafio.accenture.backend.javarecruitinghsa.constant.Contansts;
import com.desafio.accenture.backend.javarecruitinghsa.dto.response.GenericResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CategoriesDTO  extends GenericResponse<CategoriesDTO>  {

    @JsonProperty("id")
    String id;

    @JsonProperty("name")
    String name;

    @JsonProperty("subcategories")
    List<SubCategoryDTO> subcategories;

    public CategoriesDTO() {
        super(CategoriesDTO.class);
    }

    @Override
    public CategoriesDTO buildSuccessResponse() {
        return this;
    }

    @Override
    public <X extends Exception> CategoriesDTO buildErrorResponse(X e) {
        CouponsDTO couponsDTO = new CouponsDTO();
        couponsDTO.setCodResponse(Contansts.CODIGO_RESPUESTA_INCORRECTA);
        couponsDTO.setMessage(e.getMessage());
        return this;
    }
}
