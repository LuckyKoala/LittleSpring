package tech.zuosi.lk.littlespring.exception;

/**
 * Created by luckykoala on 19-2-28.
 */
public class NoSuitableConstructorForComponentException extends LittleSpringException {
    public NoSuitableConstructorForComponentException(String name) {
        super(String.format("NoSuitableConstructorForComponent for class %s, only one autowired/no-arg constructor is allowed", name), null);
    }
}
