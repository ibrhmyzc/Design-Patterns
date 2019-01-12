

/**
 * Throws an exception when a state change is invalid
 */
public class UnsupportedStateException extends Exception {
    public UnsupportedStateException() { super(); }
    public UnsupportedStateException(String message) { super(message); }
    public UnsupportedStateException(String message, Throwable cause) { super(message, cause); }
    public UnsupportedStateException(Throwable cause) { super(cause); }
}