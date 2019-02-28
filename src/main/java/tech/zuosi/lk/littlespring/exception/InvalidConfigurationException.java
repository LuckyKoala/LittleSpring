package tech.zuosi.lk.littlespring.exception;

/**
 * Created by luckykoala on 19-2-28.
 */
public class InvalidConfigurationException extends LittleSpringException {
    public InvalidConfigurationException(String clazzName) {
        super(String.format("Class %s being imported as configuration should be marked with @Configuration", clazzName), null);
    }
}
