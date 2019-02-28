package tech.zuosi.lk.littlespring.exception;

/**
 * Created by luckykoala on 19-2-28.
 */
public class InvalidBeanException extends LittleSpringException {
    public InvalidBeanException(String name) {
        super(String.format("Bean method %s should not have any argument", name), null);
    }
}
