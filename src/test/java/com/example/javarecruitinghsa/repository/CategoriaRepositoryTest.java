package com.example.javarecruitinghsa.repository;

import com.example.javarecruitinghsa.pojo.Categoria;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class CategoriaRepositoryTest {

    @InjectMocks
    CategoriaRepository repository;
    @Mock
    RestTemplateBuilder builder;

    @Before
    public void setup() {
        Mockito.when(builder.build()).thenReturn(new RestTemplate());
    }

    @Test
    public void findCategorias_ok() {
        Assert.assertNotNull(repository.findCategorias());
    }

}
