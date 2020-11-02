package com.example.javarecruitinghsa.converter;

import com.example.javarecruitinghsa.pojo.Categoria;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class CategoriaConverterTest {

    @InjectMocks
    CategoriaConverter converter;

    Categoria in;

    @Before
    public void setup() throws IOException {
        in = new ObjectMapper()
                .readValue(new ClassPathResource("categorias.json").getFile(),
                        Categoria.class);
    }

    @Test
    public void convert_ok() {
        Assert.assertNotNull(converter.convert(in));
    }
}
