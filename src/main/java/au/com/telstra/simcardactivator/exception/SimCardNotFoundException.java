package au.com.telstra.simcardactivator.exception;

public class SimCardNotFoundException extends RuntimeException {

    public SimCardNotFoundException(String message) {
        super(message);
    }
}
