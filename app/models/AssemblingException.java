package models;

/**
 * Base exception for assembling exceptions
 */
public class AssemblingException extends WallboardException {
    public AssemblingException(Throwable e) {
        super(e);
    }
}
