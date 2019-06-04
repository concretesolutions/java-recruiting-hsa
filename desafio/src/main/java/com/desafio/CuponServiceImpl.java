package com.desafio;

import com.desafio.entidades.Cupon;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CuponServiceImpl implements CuponService{

    private CuponRepositorie cuponRepositorie;

    public CuponServiceImpl(CuponRepositorie cuponRepositorie) {
        this.cuponRepositorie = cuponRepositorie;
    }

    public List<Cupon> getCuponsValid()
    {

        List<Cupon> listCupons = new ArrayList<Cupon>();
        try {
            listCupons = this.cuponRepositorie.getListCupon().stream().filter( x -> compareExpireDate(x.getExpiresAt())
            ).collect(Collectors.toList());
        }
        catch(IOException io)
        {
            throw new NullPointerException();
        }
        return listCupons;
    }

    private boolean compareExpireDate(String expireDate)
    {
        boolean result = false;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {

            String nowStr = formatter.format(new Date());

            Date date = formatter.parse(expireDate);
            Date now = formatter.parse(nowStr);

            result = now.compareTo(date) < 0 ? true: false;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        finally {
            return result;
        }



    }
}
