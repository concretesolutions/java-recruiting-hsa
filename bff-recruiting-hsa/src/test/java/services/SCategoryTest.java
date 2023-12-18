package services;

import accenture.challenge.recruiting.ms.clients.CategoryClient;
import accenture.challenge.recruiting.ms.exceptions.GenericException;
import accenture.challenge.recruiting.ms.services.impl.SCategory;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static accenture.challenge.recruiting.ms.fixtures.CategoryApiFixture.getcategories;
import static accenture.challenge.recruiting.ms.fixtures.Fixture.getMockFeignClientException;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SCategoryTest {

    @InjectMocks
    private SCategory sCategory;
    @Mock
    private CategoryClient categoryClient;

    @Test
    public void getCategoriesOrderRelevanceAsc_ok() throws Exception {
        when(categoryClient.getCategoryThree()).thenReturn(getcategories());
        var response = sCategory.getCategoriesOrderRelevanceAsc(1);
        assertNotNull(response);
    }

    @Test
    public void getCategoriesOrderRelevanceAsc_ex() throws Exception {
        when(categoryClient.getCategoryThree())
                .thenThrow(getMockFeignClientException(503, "Servicio no disponible", "Error servicio no disponible"));
        assertThrows(GenericException.class, () -> sCategory.getCategoriesOrderRelevanceAsc(1));
    }

}