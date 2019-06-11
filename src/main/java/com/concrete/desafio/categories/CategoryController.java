package com.concrete.desafio.categories;

import com.concrete.desafio.utils.ErrorDTO;
import com.concrete.desafio.utils.ErrorHandler;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@ControllerAdvice
@Controller
public class CategoryController {

  private CategoryService categoryService;
  private ErrorHandler errorHandler;

  @Autowired
  public CategoryController(
      final CategoryService categoryService, final ErrorHandler errorHandler) {
    this.categoryService = categoryService;
    this.errorHandler = errorHandler;
  }

  @ResponseBody
  @RequestMapping(
      value = "/getTopCategories",
      produces = MediaType.APPLICATION_JSON_VALUE,
      method = RequestMethod.GET)
  public ResponseEntity<List<CategoryResponse>> getTopCategories() {
    return categoryService.topFiveCategories();
  }

  @ResponseBody
  @RequestMapping(
      value = "/getRemainingCategories",
      produces = MediaType.APPLICATION_JSON_VALUE,
      method = RequestMethod.GET)
  public ResponseEntity<List<CategoryResponse>> getRemainingCategories() {

    return categoryService.remainingCategories();
  }

  @ExceptionHandler(value = RuntimeException.class)
  @ResponseBody
  ResponseEntity handlerException(final Exception ex) {
    return errorHandler.handlerErrorException(ex);
  }

  @ExceptionHandler(FeignException.class)
  public ResponseEntity handleFeignStatusException(FeignException e, HttpServletResponse response) {
    response.setStatus(e.status());
    return errorHandler.handlerErrorFeignException(e, response);
  }
}
