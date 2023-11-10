package pl.budowniczowie.apicar.exception;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(long id) {
        super("Could not find car: " + id);
    }

}
