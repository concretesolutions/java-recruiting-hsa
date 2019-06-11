package com.concrete.desafio.coupons;

import com.concrete.desafio.coupons.api.Coupon;
import com.concrete.desafio.coupons.api.CouponRepository;
import com.concrete.desafio.utils.ErrorDTO;
import com.concrete.desafio.utils.ErrorHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

import static com.concrete.desafio.coupons.CouponStubs.expectedApiResponse;
import static com.concrete.desafio.coupons.CouponStubs.expectedResponse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CouponControllerTest {

  @Mock private CouponRepository couponRepository;
  private ErrorHandler errorHandler;
  private CouponService couponService;
  private CouponController couponController;

  @Before
  public void setup() {
    errorHandler = new ErrorHandler();
    couponService = new CouponDefaultService(couponRepository);
    couponController = new CouponController(errorHandler, couponService);
  }

  @Test
  public void itShouldReturnExpectedResponse_whenApiIsOk() throws IOException {
    when(couponRepository.fetchCoupons()).thenReturn(expectedApiResponse());

    List<Coupon> coupons = couponController.getCoupons().getBody();
    List<Coupon> expected = expectedResponse();

    assertEquals(coupons, expected);
  }

    @Test
    public void itShouldReturnException_whenRequestThrowException() {
        Exception failure = new Exception("not found");
        ResponseEntity responseEntity = couponController.handlerException(failure);
        ErrorDTO expectedError = new ErrorDTO("0000", "not found");
        Assert.assertTrue(responseEntity.getBody() instanceof ErrorDTO);
        assertEquals(responseEntity.getBody(), expectedError);
    }
}
