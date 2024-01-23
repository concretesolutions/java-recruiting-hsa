package accenture.challenge.recruiting.bff.controllers;

import accenture.challenge.recruiting.bff.exceptions.GenericException;
import accenture.challenge.recruiting.bff.services.ICategory;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static accenture.challenge.recruiting.bff.fixtures.ServicesFixture.getCategories;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CategoryControllerTest {

    @InjectMocks
    private CategoryController categoryController;
    @Mock
    private ICategory iCategory;

    @Test
    public void getCategoriesOrderRelevance_ok() throws Exception {
        when(iCategory.getCategoriesOrderRelevanceAsc()).thenReturn(getCategories());
        var response = categoryController.getCategoriesOrderRelevance();
        assertNotNull(response);
    }

    @Test
    public void getCategoriesOrderRelevance_generic() throws Exception {
        when(iCategory.getCategoriesOrderRelevanceAsc()).thenThrow(new GenericException("test"));
        assertThrows(GenericException.class, () -> categoryController.getCategoriesOrderRelevance());
    }

}