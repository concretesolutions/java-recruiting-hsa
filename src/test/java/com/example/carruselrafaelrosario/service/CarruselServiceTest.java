package com.example.carruselrafaelrosario.service;

import com.example.carruselrafaelrosario.model.Response;
import com.example.carruselrafaelrosario.repository.CarruselRepository;
import com.example.carruselrafaelrosario.repository.interfaces.ICarruselRepository;
import com.example.carruselrafaelrosario.service.interfaces.ICarruselService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarruselServiceTest {

    @Mock
    private CarruselRepository repository;

    @Test
    public void GETCUPON_TEST(){
        List<Response> list = new ArrayList<>();
        Response element1 = new Response();
        element1.setId("COUPON_1");
        element1.setDescription("50% Discount");
        element1.setSeller("Crazy Seller");
        element1.setImage("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
        element1.setExpiresAt("2045-12-01");
        list.add(element1);

        Response element2 = new Response();
        element2.setId("COUPON_2");
        element2.setDescription("5% Discount");
        element2.setSeller("The Seller");
        element2.setImage("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
        element2.setExpiresAt("2050-12-01");
        list.add(element2);

        Response element3 = new Response();
        element3.setId("COUPON_3");
        element3.setDescription("5% Discount");
        element3.setSeller("The Seller");
        element3.setImage("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
        element3.setExpiresAt("2019-12-01");
        list.add(element3);

        when(repository.getCupon()).thenReturn(list);
        CarruselService service = new CarruselService();
        service.setRepository(repository);
        assertEquals(2,service.getCuponNotExpires().size());

    }
}