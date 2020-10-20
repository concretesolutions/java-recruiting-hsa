package cl.desafio.controller;

import cl.desafio.domain.CuponResponse;
import cl.desafio.service.CuponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yasna.bastias.pina on 19-10-2020.
 */
@RequestMapping("/cupon")
@RestController
public class CuponController {

    @Autowired
    private CuponService cuponService;

    @RequestMapping(value = "/getCupones", method = RequestMethod.GET)
    public List<CuponResponse> getCategories(){
        return cuponService.getCupones();
    }
}
