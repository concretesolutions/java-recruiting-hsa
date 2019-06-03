package com.desafio;

import com.desafio.entidades.Cupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CuponController {

    private CuponService cuponService;

    @Autowired
    public CuponController(CuponService cuponService) {
        this.cuponService = cuponService;
    }

    @ResponseBody
    @RequestMapping(
                value = "/getCuponesValidos",
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET
    )
    public List<Cupon> cuponValido() {
        return cuponService.getCuponsValid();
    }


}
