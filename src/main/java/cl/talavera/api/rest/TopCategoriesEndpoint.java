package cl.talavera.api.rest;

import cl.talavera.api.core.port.CategoriesPresenterPort;
import cl.talavera.api.core.port.TopCategoriesInteractorPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopCategoriesEndpoint {
    private final CategoriesPresenterPort presenter;
    private final TopCategoriesInteractorPort interactor;


    public TopCategoriesEndpoint(TopCategoriesInteractorPort interactor, CategoriesPresenterPort presenter) {
        this.presenter = presenter;
        this.interactor = interactor;
    }

    @GetMapping(name ="categories/top", produces = "application/json")
    public ResponseEntity present() {
    interactor.run();
    return ResponseEntity.ok(presenter.retrieve());
    }
}
