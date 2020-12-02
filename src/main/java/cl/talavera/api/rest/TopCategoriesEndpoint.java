package cl.talavera.api.rest;

import cl.talavera.api.core.port.CategoriesPresenterPort;
import cl.talavera.api.core.port.TopCategoriesInteractorPort;
import org.springframework.http.ResponseEntity;


public class TopCategoriesEndpoint {
    private final CategoriesPresenterPort presenter;
    private final TopCategoriesInteractorPort interactor;

    public TopCategoriesEndpoint(TopCategoriesInteractorPort interactor, CategoriesPresenterPort presenter) {
        this.presenter = presenter;
        this.interactor = interactor;
    }

    public ResponseEntity present() {
    interactor.run();
    return ResponseEntity.ok(presenter.retrieve());
    }
}
