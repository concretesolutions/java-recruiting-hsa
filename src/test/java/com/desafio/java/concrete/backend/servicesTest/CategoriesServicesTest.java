package com.desafio.java.concrete.backend.servicesTest;

import com.desafio.java.concrete.backend.helpers.ObjectJsonHelper;
import com.desafio.java.concrete.backend.services.CategoriesServices;
import com.desafio.java.concrete.backend.services.RestServices;
import com.desafio.java.concrete.backend.settings.ApiSettings;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;


public class CategoriesServicesTest {

    @InjectMocks
    CategoriesServices categoriesServices;

    @Mock
    ApiSettings apiSettings;

    @Mock
    RestServices restServices;


    @Test
    public void getCategoriesTest() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(restServices.responseEntity(anyString()))
                .thenReturn(responseEntity());
        Mockito.when(apiSettings.getCategoriaURL())
                .thenReturn("https://cs-hsa-api-categories.herokuapp.com/categories");


        String expected = "[{\"id\":\"outdoor\",\"name\":\"Outdoor\",\"relevance\":3,\"smallImageUrl\":null,\"subcategories\":[]},{\"id\":\"books\",\"name\":\"Books\",\"relevance\":2,\"smallImageUrl\":null,\"subcategories\":[]},{\"id\":\"sports\",\"name\":\"Sports\",\"relevance\":1,\"smallImageUrl\":null,\"subcategories\":[{\"id\":\"bike\",\"name\":\"Bike\",\"relevance\":350,\"mediumImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"smallImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"subcategories\":[]}]},{\"id\":\"electronics\",\"name\":\"Electronics\",\"relevance\":0,\"smallImageUrl\":null,\"subcategories\":[{\"id\":\"tv\",\"name\":\"TV\",\"relevance\":0,\"mediumImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"smallImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"subcategories\":[{\"id\":\"4k\",\"name\":\"4K\",\"relevance\":700}]}]}]";
        String test = categoriesServices.getCategories();
        Assert.assertEquals("Respuesta Esperada", expected, test);

    }

    @Test
    public void getTopFiveErrorTest() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(restServices.responseEntity(anyString()))
                .thenReturn(responseEntityFail());
        Mockito.when(apiSettings.getCategoriaURL())
                .thenReturn("https://cs-hsa-api-categories.herokuapp.com/categories");

        String test = categoriesServices.getTopCategories();
        assertThat(test).isNotNull();

    }

    @Test
    public void getCategoriesErrorTest() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(restServices.responseEntity(anyString()))
                .thenReturn(responseEntityFail());
        Mockito.when(apiSettings.getCategoriaURL())
                .thenReturn("https://cs-hsa-api-categories.herokuapp.com/categories");

        String test = categoriesServices.getCategories();
        assertThat(test).isNotNull();

    }

    @Test
    public void getTopFiveTest() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(restServices.responseEntity(anyString()))
                .thenReturn(responseEntity());
        Mockito.when(apiSettings.getCategoriaURL())
                .thenReturn("https://cs-hsa-api-categories.herokuapp.com/categories");


        String expected = "[{\"relevance\":150,\"iconImageUrl\":null,\"name\":\"Video Games\"},{\"relevance\":99,\"iconImageUrl\":null,\"name\":\"Toys\"},{\"relevance\":6,\"iconImageUrl\":null,\"name\":\"Health\"},{\"relevance\":5,\"iconImageUrl\":null,\"name\":\"Travel\"},{\"relevance\":4,\"iconImageUrl\":null,\"name\":\"Food\"}]";
        String test = categoriesServices.getTopCategories();
        Assert.assertEquals("Respuesta Esperada", expected, test);

    }

    public ResponseEntity responseEntityFail() {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<?> responseEntity = new ResponseEntity<>(
                "{\"success\":false,\"message\":\"NONK\"}",
                header,
                HttpStatus.resolve(500)
        );
        return responseEntity;
    }

    public ResponseEntity responseEntity() {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<?> responseEntity = new ResponseEntity<>(
                "{\n" +
                        "  \"id\": \"ROOT\",\n" +
                        "  \"name\": \"LEGACY_NAVIGATION\",\n" +
                        "  \"subcategories\": [\n" +
                        "    {\n" +
                        "      \"id\": \"MOB\",\n" +
                        "      \"name\": \"MOBILE_MARKET\",\n" +
                        "      \"subcategories\": [\n" +
                        "        {\n" +
                        "          \"id\": \"video-games\",\n" +
                        "          \"name\": \"Video Games\",\n" +
                        "          \"relevance\": 150,\n" +
                        "          \"subcategories\": [\n" +
                        "            {\n" +
                        "              \"id\": \"nintendo\",\n" +
                        "              \"name\": \"Nintendo\",\n" +
                        "              \"subcategories\": [\n" +
                        "                {\n" +
                        "                  \"id\": \"switch\",\n" +
                        "                  \"name\": \"Switch\",\n" +
                        "                  \"relevance\": 422\n" +
                        "                }\n" +
                        "              ],\n" +
                        "              \"largeImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n" +
                        "              \"mediumImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n" +
                        "              \"smallImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n" +
                        "            }\n" +
                        "          ],\n" +
                        "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": \"sports\",\n" +
                        "          \"name\": \"Sports\",\n" +
                        "          \"relevance\": 1,\n" +
                        "          \"subcategories\": [\n" +
                        "            {\n" +
                        "              \"id\": \"bike\",\n" +
                        "              \"name\": \"Bike\",\n" +
                        "              \"relevance\": 350,\n" +
                        "              \"subcategories\": [],\n" +
                        "              \"largeImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n" +
                        "              \"mediumImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n" +
                        "              \"smallImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n" +
                        "            }\n" +
                        "          ],\n" +
                        "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": \"electronics\",\n" +
                        "          \"name\": \"Electronics\",\n" +
                        "          \"subcategories\": [\n" +
                        "            {\n" +
                        "              \"id\": \"tv\",\n" +
                        "              \"name\": \"TV\",\n" +
                        "              \"subcategories\": [\n" +
                        "                {\n" +
                        "                  \"id\": \"4k\",\n" +
                        "                  \"name\": \"4K\",\n" +
                        "                  \"relevance\": 700\n" +
                        "                }\n" +
                        "              ],\n" +
                        "              \"largeImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n" +
                        "              \"mediumImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n" +
                        "              \"smallImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n" +
                        "            }\n" +
                        "          ],\n" +
                        "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": \"outdoor\",\n" +
                        "          \"name\": \"Outdoor\",\n" +
                        "          \"relevance\": 3,\n" +
                        "          \"subcategories\": [],\n" +
                        "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": \"food\",\n" +
                        "          \"name\": \"Food\",\n" +
                        "          \"relevance\": 4,\n" +
                        "          \"subcategories\": [\n" +
                        "            {\n" +
                        "              \"id\": \"hamburger\",\n" +
                        "              \"name\": \"Hamburger\",\n" +
                        "              \"relevance\": 350,\n" +
                        "              \"subcategories\": [],\n" +
                        "              \"largeImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n" +
                        "              \"mediumImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n" +
                        "              \"smallImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n" +
                        "            }\n" +
                        "          ],\n" +
                        "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": \"books\",\n" +
                        "          \"name\": \"Books\",\n" +
                        "          \"relevance\": 2,\n" +
                        "          \"subcategories\": [],\n" +
                        "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": \"travel\",\n" +
                        "          \"name\": \"Travel\",\n" +
                        "          \"relevance\": 5,\n" +
                        "          \"subcategories\": [],\n" +
                        "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": \"health\",\n" +
                        "          \"name\": \"Health\",\n" +
                        "          \"relevance\": 6,\n" +
                        "          \"subcategories\": [],\n" +
                        "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": \"toys\",\n" +
                        "          \"name\": \"Toys\",\n" +
                        "          \"relevance\": 99,\n" +
                        "          \"subcategories\": [\n" +
                        "            {\n" +
                        "              \"id\": \"puzzles\",\n" +
                        "              \"name\": \"Puzzles\",\n" +
                        "              \"relevance\": 100,\n" +
                        "              \"subcategories\": [],\n" +
                        "              \"largeImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n" +
                        "              \"mediumImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\n" +
                        "              \"smallImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n" +
                        "            }\n" +
                        "          ],\n" +
                        "          \"iconImageUrl\": \"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"\n" +
                        "        }\n" +
                        "      ]\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}",
                header,
                HttpStatus.resolve(200)
        );
        return responseEntity;
    }
}
