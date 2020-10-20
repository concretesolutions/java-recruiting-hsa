package cl.desafio.service.impl;

import cl.desafio.domain.CuponResponse;
import cl.desafio.sal.CuponServiceRest;
import cl.desafio.service.CuponService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yasna.bastias.pina on 19-10-2020.
 */
@Service
public class CuponServiceImpl implements CuponService{

    @Autowired
    private CuponServiceRest cuponServiceRest;


    @Override
    public List<CuponResponse> getCupones(){

        ObjectMapper mapper = new ObjectMapper();
        List<CuponResponse> list = new ArrayList<>();

        try {
            list = mapper.readValue(cuponServiceRest.getCupones(), new TypeReference<List<CuponResponse>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(!list.isEmpty()){
            return listValid(list);
        }
        return list;
    }

    private List<CuponResponse>listValid (List<CuponResponse> list){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String expiredCupon;
        String nowDateString = sdf.format(new Date());
        boolean cuponFlag = false;

        List<CuponResponse> listaValid = new ArrayList<CuponResponse>();

        try {
            Date now = sdf.parse(nowDateString);

            for(CuponResponse cupon:list){
                expiredCupon = cupon.getExpiresAt();

                Date date = sdf.parse(expiredCupon);
                cuponFlag = date.after(now);
                if(cuponFlag != false ){
                    listaValid.add(cupon);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return listaValid;
    }
}
