package com.example.javarecruitinghsa.service;

import com.example.javarecruitinghsa.converter.CategoriaConverter;
import com.example.javarecruitinghsa.dto.CategoriaDTO;
import com.example.javarecruitinghsa.pojo.Categoria;
import com.example.javarecruitinghsa.repository.CategoriaRepository;
import com.example.javarecruitinghsa.service.impl.CategoriaServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoriaServiceTest {

    @InjectMocks
    CategoriaServiceImpl service;
    @Mock
    CategoriaRepository categoriaRepository;
    @Mock
    CategoriaConverter categoriaConverter;
    List<CategoriaDTO> categoriaDTOList;
    Categoria categoria;

    @Before
    public void setup() throws IOException {
        categoriaDTOList = new ObjectMapper()
                .readValue(new ClassPathResource("categoriaDtoList.json").getFile(),
                        new TypeReference<List<CategoriaDTO>>(){});
        categoria = new ObjectMapper()
                .readValue(new ClassPathResource("categorias.json").getFile(),
                        Categoria.class);
    }

    @Test
    public void top_ok() {
        okServiceResponse();
        Assert.assertNotNull(service.top());
    }

    @Test
    public void restante_ok() {
        okServiceResponse();
        Assert.assertNotNull(service.restantes());
    }

    private void okServiceResponse() {
        when(categoriaRepository.findCategorias())
                .thenReturn(categoria);
        when(categoriaConverter.convert(any(Categoria.class)))
                .thenReturn(categoriaDTOList);
    }
}
