package cl.talavera.api.web;

import cl.talavera.api.core.domain.Coupon;
import cl.talavera.api.core.port.coupon.CouponsPresenterPort;
import cl.talavera.api.core.port.coupon.NonExpiredCouponsInteractorPort;
import cl.talavera.api.web.endpoint.NonExpiredCouponsEnpoint;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

public class NonExpiredCouponsEndpointShould {
    @Test
    void present() throws ParseException {

        NonExpiredCouponsInteractorPort interactor = mock(NonExpiredCouponsInteractorPort.class);
        CouponsPresenterPort presenter = mock(CouponsPresenterPort.class);
        NonExpiredCouponsEnpoint endpoint = new NonExpiredCouponsEnpoint(interactor,presenter);


        List<Coupon> view = expectedView();
        when(presenter.retrieve()).thenReturn(view);


        ResponseEntity<List<Coupon>> response = endpoint.present();





        verify(interactor,times(1)).run();
        verify(presenter,times(1)).retrieve();
        assertThat(response, equalTo(ResponseEntity.ok(view)));

    }

    private List<Coupon> expectedView() {
        return asList(Coupon.builder().id("id").build());
    }
}
