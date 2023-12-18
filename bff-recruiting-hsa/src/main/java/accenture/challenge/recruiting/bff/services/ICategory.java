package accenture.challenge.recruiting.bff.services;

import accenture.challenge.recruiting.bff.dtos.CategoryDto;

import java.util.List;

public interface ICategory {

    List<CategoryDto> getCategoriesOrderRelevanceAsc();

}