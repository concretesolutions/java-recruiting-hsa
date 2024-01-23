package accenture.challenge.recruiting.bff.services;

import accenture.challenge.recruiting.bff.clients.CategoryClient;
import accenture.challenge.recruiting.bff.exceptions.GenericException;
import accenture.challenge.recruiting.bff.services.impl.SCategory;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static accenture.challenge.recruiting.bff.fixtures.CategoryClientFixture.getCategoryThree;
import static accenture.challenge.recruiting.bff.fixtures.Fixture.getMockFeignClientException;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SCategoryTest {

    @InjectMocks
    private SCategory sCategory;
    @Mock
    private CategoryClient categoryClient;

    @Test
    public void getCategoriesOrderRelevanceAsc_ok() throws Exception {
        when(categoryClient.getCategoriesOrderReelevanceAndLimit(any())).thenReturn(getCategoryThree());
        var response = sCategory.getCategoriesOrderRelevanceAsc();
        assertNotNull(response);
    }

    @Test
    public void getCategoriesOrderRelevanceAsc_ex() throws Exception {
        when(categoryClient.getCategoriesOrderReelevanceAndLimit(any()))
                .thenThrow(getMockFeignClientException(503, "Servicio no disponible", "Error servicio no disponible"));
        assertThrows(GenericException.class, () -> sCategory.getCategoriesOrderRelevanceAsc());
    }

}