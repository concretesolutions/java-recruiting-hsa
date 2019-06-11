package com.concrete.desafio.categories;

import com.concrete.desafio.categories.api.CategoryRepository;
import com.concrete.desafio.utils.ErrorDTO;
import com.concrete.desafio.utils.ErrorHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.concrete.desafio.categories.CategoryStubs.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {

  @Mock private CategoryRepository categoryRepository;
  @Mock private HttpServletResponse httpServletResponse;
  private CategoryService categoryService;
  private CategoryController categoryController;
  private ErrorHandler errorHandler;

  @Before
  public void setup() {
    errorHandler = new ErrorHandler();
    categoryService = new CategoryDefaultService(categoryRepository);
    categoryController = new CategoryController(categoryService, errorHandler);
  }

  @Test
  public void itShouldReturn_expectedTopFiveOutput() throws IOException {
    when(categoryRepository.getCategoryThree()).thenReturn(expectedApiResponse());
    List<CategoryResponse> categoryTopFiveList = categoryController.getTopCategories().getBody();
    List<CategoryResponse> expected = expectedTopFiveOutput();

    assertEquals(categoryTopFiveList, expected);
  }

  @Test
  public void itShouldReturnExpectedTopFiveOutput_whenHaveFourCategories() throws IOException {
    when(categoryRepository.getCategoryThree()).thenReturn(categoryWithOnlyFourSubcategories());
    List<CategoryResponse> categoryTopFiveList = categoryController.getTopCategories().getBody();
    List<CategoryResponse> categoryRemainingList =
        categoryController.getRemainingCategories().getBody();

    assertEquals(categoryTopFiveList.size(), 4);
    assertEquals(categoryRemainingList.size(), 0);
  }

  @Test
  public void itShouldReturn_expectedRemainingOutput() throws IOException {
    when(categoryRepository.getCategoryThree()).thenReturn(expectedApiResponse());
    List<CategoryResponse> categoryRemainingList =
        categoryController.getRemainingCategories().getBody();
    List<CategoryResponse> expected = expectedRemainingOutput();

    assertEquals(categoryRemainingList, expected);
  }

  @Test(expected = IllegalArgumentException.class)
  public void itShouldReturnIllegalArgumentException_whenSubcategoriesIsNull() throws IOException {
    when(categoryRepository.getCategoryThree()).thenReturn(subCategoryNullOutput());
    ResponseEntity responseEntity = categoryController.getTopCategories();
    ErrorDTO expectedError = new ErrorDTO("0000", "SubCategories can not be null");
    Assert.assertTrue(responseEntity.getBody() instanceof ErrorDTO);
    assertEquals(responseEntity.getBody(), expectedError);
  }

  @Test(expected = IllegalArgumentException.class)
  public void itShouldReturnIllegalArgumentException_whenMobileMarketNotFound() throws IOException {
    when(categoryRepository.getCategoryThree()).thenReturn(subCategoryMobileMarketNotFound());
    ResponseEntity responseEntity = categoryController.getTopCategories();
    ErrorDTO expectedError = new ErrorDTO("0000", "Mobile market category not found");
    Assert.assertTrue(responseEntity.getBody() instanceof ErrorDTO);
    assertEquals(responseEntity.getBody(), expectedError);
  }

  @Test
  public void itShouldReturnException_whenRequestThrowException() {
    Exception failure = new Exception("not found");
    ResponseEntity responseEntity = categoryController.handlerException(failure);
    ErrorDTO expectedError = new ErrorDTO("0000", "not found");
    Assert.assertTrue(responseEntity.getBody() instanceof ErrorDTO);
    assertEquals(responseEntity.getBody(), expectedError);
  }
}
