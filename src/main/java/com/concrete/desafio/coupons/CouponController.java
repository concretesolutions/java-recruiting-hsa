package com.concrete.desafio.coupons;

import com.concrete.desafio.coupons.api.Coupon;
import com.concrete.desafio.utils.ErrorHandler;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@ControllerAdvice
public class CouponController {

  private ErrorHandler errorHandler;
  private CouponService couponService;

  @Autowired
  public CouponController(final ErrorHandler errorHandler, final CouponService couponService) {
    this.errorHandler = errorHandler;
    this.couponService = couponService;
  }

  @ResponseBody
  @RequestMapping(
      value = "/getCoupons",
      produces = MediaType.APPLICATION_JSON_VALUE,
      method = RequestMethod.GET)
  public ResponseEntity<List<Coupon>> getCoupons() {

    return couponService.getCoupons();
  }

  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  ResponseEntity handlerException(final Exception ex) {
    return errorHandler.handlerErrorException(ex);
  }

  @ExceptionHandler(FeignException.class)
  public ResponseEntity handleFeignStatusException(
      final FeignException e, final HttpServletResponse response) {
    response.setStatus(e.status());
    return errorHandler.handlerErrorFeignException(e, response);
  }
}
