package tech.zuosi.lk.littlespring.exception;

/**
 * Created by luckykoala on 19-2-28.
 */
public class NoSuchBeanException extends LittleSpringException {
    public NoSuchBeanException(String name) {
        super("Can't find bean " + name, null);
    }
}
