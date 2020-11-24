package com.accenture.prueba.service.impl;

import com.accenture.prueba.client.CategoriesClient;
import com.accenture.prueba.dto.CategoriesResponseDto;
import com.accenture.prueba.dto.api.CategoriesApiResponse;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;
import java.util.stream.Collectors;

class CategoriesServiceImplTest {

    @Mock
    private static final CategoriesClient categoriesClient = Mockito.mock(CategoriesClient.class);

    @InjectMocks
    private final CategoriesServiceImpl categoriesServiceImplTest = new CategoriesServiceImpl(categoriesClient);

    @BeforeAll
    public static void setUp(){
        String json = "{\"id\":\"ROOT\",\"name\":\"LEGACY_NAVIGATION\",\"subcategories\":[{\"id\":\"MOB\",\"name\":\"MOBILE_MARKET\",\"subcategories\":[{\"id\":\"video-games\",\"name\":\"Video Games\",\"relevance\":150,\"subcategories\":[{\"id\":\"nintendo\",\"name\":\"Nintendo\",\"subcategories\":[{\"id\":\"switch\",\"name\":\"Switch\",\"relevance\":422}],\"largeImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"mediumImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"smallImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"}],\"iconImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"},{\"id\":\"sports\",\"name\":\"Sports\",\"relevance\":1,\"subcategories\":[{\"id\":\"bike\",\"name\":\"Bike\",\"relevance\":350,\"subcategories\":[],\"largeImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"mediumImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"smallImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"}],\"iconImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"},{\"id\":\"electronics\",\"name\":\"Electronics\",\"subcategories\":[{\"id\":\"tv\",\"name\":\"TV\",\"subcategories\":[{\"id\":\"4k\",\"name\":\"4K\",\"relevance\":700}],\"largeImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"mediumImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"smallImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"}],\"iconImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"},{\"id\":\"outdoor\",\"name\":\"Outdoor\",\"relevance\":3,\"subcategories\":[],\"iconImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"},{\"id\":\"food\",\"name\":\"Food\",\"relevance\":4,\"subcategories\":[{\"id\":\"hamburger\",\"name\":\"Hamburger\",\"relevance\":350,\"subcategories\":[],\"largeImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"mediumImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"smallImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"}],\"iconImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"},{\"id\":\"books\",\"name\":\"Books\",\"relevance\":2,\"subcategories\":[],\"iconImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"},{\"id\":\"travel\",\"name\":\"Travel\",\"relevance\":5,\"subcategories\":[],\"iconImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"},{\"id\":\"health\",\"name\":\"Health\",\"relevance\":6,\"subcategories\":[],\"iconImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"},{\"id\":\"toys\",\"name\":\"Toys\",\"relevance\":99,\"subcategories\":[{\"id\":\"puzzles\",\"name\":\"Puzzles\",\"relevance\":100,\"subcategories\":[],\"largeImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"mediumImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\",\"smallImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"}],\"iconImageUrl\":\"https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg\"}]}]}";

        CategoriesApiResponse categoriesApiResponse = new Gson().fromJson(json, CategoriesApiResponse.class);

        Mockito.when(categoriesClient.getAll()).thenReturn(categoriesApiResponse);
    }

    @Test
    void getAll() {
        CategoriesResponseDto actual = categoriesServiceImplTest.getAll();
        CategoriesResponseDto expected = CategoriesResponseDto.builder().categories(getResponseExpected()).build();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getTop() {
        CategoriesResponseDto actual = categoriesServiceImplTest.getTop();
        CategoriesResponseDto expected = CategoriesResponseDto.builder().categories(getResponseTop5Expected().subList(0, Math.min(getResponseTop5Expected().size(), 5))).build();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getAnother() {
        CategoriesResponseDto actual = categoriesServiceImplTest.getNoTop();
        CategoriesResponseDto expected = CategoriesResponseDto.builder().categories(getAnotherExpected()).build();
        Assertions.assertEquals(expected, actual);
    }

    private List<CategoriesResponseDto.Categorie> getResponseExpected() {
        return categoriesClient.getAll().getSubcategories().get(0).getSubcategories()
                .stream()
                .map(c -> CategoriesResponseDto.Categorie.builder()
                        .id(c.getId())
                        .name(c.getName())
                        .relevance(c.getRelevance())
                        .iconImageUrl(c.getIconImageUrl())
                        .subcategories(c.getSubcategories())
                        .build())
                .collect(Collectors.toList());
    }

    private List<CategoriesResponseDto.Categorie> getResponseTop5Expected() {
        List<CategoriesResponseDto.Categorie> list = getResponseExpected().stream()
                .sorted((c1, c2) -> c2.getRelevance() - c1.getRelevance())
                .collect(Collectors.toList());

        return list.subList(0, Math.min(list.size(), 5));
    }

    private List<CategoriesResponseDto.Categorie> getAnotherExpected() {
        List<CategoriesResponseDto.Categorie> listExpected = getResponseExpected().stream()
                .sorted((c1, c2) -> c2.getRelevance() - c1.getRelevance())
                .collect(Collectors.toList());

        List<CategoriesResponseDto.Categorie> topCategoriesList = listExpected.subList(0, Math.min(listExpected.size(), 5));

        listExpected.removeAll(topCategoriesList);

        return listExpected;
    }

}