package Exceptions;

public class BadArgument extends Exception {

    public BadArgument(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Bad argument!!! " + super.getMessage();
    }
}
