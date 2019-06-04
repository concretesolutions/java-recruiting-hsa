package com.desafio;

import com.Utils.CallApiUtils;
import com.desafio.entidades.CategorieThree;
import com.desafio.entidades.Cupon;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategorieServiceTest {

    @Mock
    private CallApiUtils apiUtils;
    @Mock
    private CategorieRepositorie categorieRepositorie;
    private CategorieService categorieService;

    @Before
    public void setup() {
        categorieService = new CategorieServiceImpl(categorieRepositorie);
    }

//    @Test
//    public void getTop5CategorieIsAfter() throws IOException {
//        when(categorieRepositorie.getListCategorie()).thenReturn(CategorieMock.withCategorieThree());
//        final List<CategorieThree> categorieTop5 = categorieService.getCategorieTop5();
//        assertEquals(5, categorieTop5.size());
//    }

}
