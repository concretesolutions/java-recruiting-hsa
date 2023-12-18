package controllers;

import accenture.challenge.recruiting.ms.exceptions.GenericException;
import accenture.challenge.recruiting.ms.services.ICategory;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static accenture.challenge.recruiting.ms.fixtures.CategoryApiFixture.getcategories;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CategoryControllerTest {

    @InjectMocks
    private CategoryController categoryController;
    @Mock
    private ICategory iCategory;

    @Test
    public void getCategoriesOrderRelevance_ok() throws Exception {
        when(iCategory.getCategoriesOrderRelevanceAsc(any())).thenReturn(getcategories());
        var response = categoryController.getCategoriesOrderRelevance(1);
        assertNotNull(response);
    }

    @Test
    public void getCategoriesOrderRelevance_exception() throws Exception {
        when(iCategory.getCategoriesOrderRelevanceAsc(any()))
                .thenThrow(new IllegalArgumentException("test"));
        assertThrows(Exception.class, () -> categoryController.getCategoriesOrderRelevance(1));
    }

    @Test
    public void getCategoriesOrderRelevance_generic() throws Exception {
        when(iCategory.getCategoriesOrderRelevanceAsc(any()))
                .thenThrow(new GenericException("test"));
        assertThrows(GenericException.class, () -> categoryController.getCategoriesOrderRelevance(1));
    }

}