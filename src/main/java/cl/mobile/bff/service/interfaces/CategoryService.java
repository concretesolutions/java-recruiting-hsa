package cl.mobile.bff.service.interfaces;

import java.util.List;

import cl.mobile.bff.domain.CategoryClientResponse;

public interface CategoryService {
	public List<CategoryClientResponse> getTopFive();
	public List<CategoryClientResponse> getRemain();
}
