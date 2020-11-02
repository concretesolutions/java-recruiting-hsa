package com.example.javarecruitinghsa.service.impl;

import com.example.javarecruitinghsa.converter.CategoriaConverter;
import com.example.javarecruitinghsa.dto.CategoriaDTO;
import com.example.javarecruitinghsa.repository.CategoriaRepository;
import com.example.javarecruitinghsa.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    CategoriaConverter categoriaConverter;

    @Override
    public Optional<List<CategoriaDTO>> top() {
        return Optional.ofNullable(prepareData().subList(0, 5));
    }

    @Override
    public Optional<List<CategoriaDTO>> restantes() {
        List<CategoriaDTO> categoriaDTOS = prepareData();
        return Optional.ofNullable(categoriaDTOS.subList(5, categoriaDTOS.size()));
    }

    private List<CategoriaDTO> prepareData() {
        List<CategoriaDTO> categoriaDTOList = categoriaConverter
                .convert(categoriaRepository.findCategorias());
        Collections.sort(categoriaDTOList, Comparator
                .comparing(CategoriaDTO::getRelevancia).reversed());
        return categoriaDTOList;
    }
}
