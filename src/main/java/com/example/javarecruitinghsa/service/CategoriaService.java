package com.example.javarecruitinghsa.service;

import com.example.javarecruitinghsa.dto.CategoriaDTO;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    Optional<List<CategoriaDTO>> top();

    Optional<List<CategoriaDTO>> restantes();
}
