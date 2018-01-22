 package ua.nure.uvarov.exceptions;

public class AppInitializationException extends RuntimeException {

    public AppInitializationException() {
        super();
    }

    public AppInitializationException(String message) {
        super(message);
    }
}
