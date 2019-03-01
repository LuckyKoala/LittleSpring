package tech.zuosi.lk.littlespring.ioc.autowiring;

import org.junit.Test;
import tech.zuosi.lk.littlespring.LittleSpring;
import tech.zuosi.lk.littlespring.exception.NoSuitableConstructorForComponentException;
import tech.zuosi.lk.littlespring.ioc.annotation.ComponentScan;

/**
 * Created by luckykoala on 19-3-1.
 */
@ComponentScan(basePackages = "tech.zuosi.lk.littlespring.ioc.autowiring.nosuitableconstructor")
public class NoSuitableConstructorForComponentTest {
    @Test(expected = NoSuitableConstructorForComponentException.class)
    public void test() throws Exception {
        LittleSpring context = new LittleSpring(NoSuitableConstructorForComponentTest.class);
        context.getBean("WithoutNoArgConstructor");
    }
}
