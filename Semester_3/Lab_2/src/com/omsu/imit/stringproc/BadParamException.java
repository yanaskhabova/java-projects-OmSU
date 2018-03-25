package stringproc;
public class BadParamException extends Exception{
    public BadParamException(){}

    public BadParamException(String message) {
        super(message);
    }

    public BadParamException(String message, Throwable cause) {
        super(message, cause);
    }
}
