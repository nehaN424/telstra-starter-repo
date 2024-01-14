package au.com.telstra.simcardactivator.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice("au.com.telstra.simcardactivator")
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> serverSideException(Exception exception) {
        ErrorResponse response = new ErrorResponse();
        response.setStatus(INTERNAL_SERVER_ERROR);
        response.setErrors(List.of(exception.getMessage()));
        return buildResponseEntity(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> fieldValidationException(MethodArgumentNotValidException exception) {
        ErrorResponse response = new ErrorResponse();
        List<String> errors = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(error -> errors.add(error.getField() + " : " + error.getDefaultMessage())
        );
        response.setStatus(BAD_REQUEST);
        response.setErrors(errors);
        return buildResponseEntity(response);
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse response) {
        return new ResponseEntity<>(response, response.getStatus());
    }
}
