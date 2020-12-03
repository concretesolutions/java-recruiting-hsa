package cl.talavera.api.rest;

import cl.talavera.api.core.port.category.CategoriesPresenterPort;
import cl.talavera.api.core.port.category.TopCategoriesInteractorPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TopCategoriesEndpoint {
    private final CategoriesPresenterPort presenter;
    private final TopCategoriesInteractorPort interactor;




    public TopCategoriesEndpoint(TopCategoriesInteractorPort interactor, CategoriesPresenterPort presenter) {
        this.presenter = presenter;
        this.interactor = interactor;
    }

    @RequestMapping("/categories/top")
    public ResponseEntity present() {
    interactor.run();
    return ResponseEntity.ok(presenter.retrieve());
    }
}
