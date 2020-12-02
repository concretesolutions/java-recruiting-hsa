package com.desafio.accenture.backend.javarecruitinghsa.service;

import com.desafio.accenture.backend.javarecruitinghsa.dto.CouponsDTO;
import com.desafio.accenture.backend.javarecruitinghsa.exception.GenericException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CouponsService {

     List<CouponsDTO> getCarruselCupones() throws GenericException;
}
