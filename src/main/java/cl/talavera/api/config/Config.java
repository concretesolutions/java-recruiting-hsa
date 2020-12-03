package cl.talavera.api.config;

import cl.talavera.api.core.interactor.TopCategoriesInteractor;
import cl.talavera.api.core.port.category.CategoriesPresenterPort;
import cl.talavera.api.core.port.category.CategoryDaoPort;
import cl.talavera.api.core.port.category.TopCategoriesInteractorPort;
import cl.talavera.api.data.CategoryDao;
import cl.talavera.api.data.CategoryRestRepository;
import cl.talavera.api.rest.CategoriesPresenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public TopCategoriesInteractorPort interactor() {

        return new TopCategoriesInteractor(dao(),presenter());
    }
    @Bean
    protected CategoryDaoPort dao() {

        CategoryRestRepository repo = new CategoryRestRepository();
        return new CategoryDao(repo);
    }

    @Bean
    protected CategoriesPresenterPort presenter() {
        return new CategoriesPresenter();
    }
}
