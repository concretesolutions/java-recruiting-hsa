package accenture.challenge.recruiting.ms.controllers;

import accenture.challenge.recruiting.ms.exceptions.GenericException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.function.BiFunction;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Log4j2
@ControllerAdvice(basePackages={"accenture.challenge.recruiting.ms.controllers"})
public class ExceptionHandlerController {

    private static final BiFunction<String, String, Error> builderError = (title, message) ->
        new Error(String.format("%s - %s", title, message));

    @ExceptionHandler(Exception.class)
    ResponseEntity<Error> handleException(Exception ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(
                builderError.apply("Error Interno", "Ah salido algo mal favor intentar mas tarde"),
                INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(GenericException.class)
    ResponseEntity<Error> handleGenericException(GenericException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(
                builderError.apply("Error Generico", ex.getMessage()),
                INTERNAL_SERVER_ERROR);
    }

}