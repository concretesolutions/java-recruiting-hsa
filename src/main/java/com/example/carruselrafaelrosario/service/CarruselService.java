package com.example.carruselrafaelrosario.service;

import com.example.carruselrafaelrosario.model.Response;
import com.example.carruselrafaelrosario.repository.CarruselRepository;
import com.example.carruselrafaelrosario.service.interfaces.ICarruselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarruselService implements ICarruselService {

    @Autowired
    private CarruselRepository repository;

    @Override
    public List<Response> getCuponNotExpires(){
        List<Response> cupones = repository.getCupon();
        return cupones.size() > 0 ? cupones.stream()
                .filter(c-> c.getExpiresAt().compareTo(LocalDate.now().toString()) > 0)
                .collect(Collectors.toList()): new ArrayList<>();
    }

    public void setRepository(CarruselRepository repository) {
        this.repository = repository;
    }
}
