package tech.zuosi.lk.littlespring.exception;

/**
 * Created by luckykoala on 19-2-28.
 */
public class InvalidPackageException extends LittleSpringException {
    public InvalidPackageException(String name, Throwable throwable) {
        super("Invalid package " + name, throwable);
    }
}
