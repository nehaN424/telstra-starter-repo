package au.com.telstra.simcardactivator.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class ErrorResponse {
    private HttpStatus status;
    private List<String> errors;
}
