package hw24.hw.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalideInputExeption extends RuntimeException{
    public InvalideInputExeption() {
    }

    public InvalideInputExeption(String message) {
        super(message);
    }

    public InvalideInputExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalideInputExeption(Throwable cause) {
        super(cause);
    }

    public InvalideInputExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}