package tech.zuosi.lk.littlespring.ioc.autowiring;

import org.junit.Test;
import tech.zuosi.lk.littlespring.LittleSpring;
import tech.zuosi.lk.littlespring.ioc.annotation.ComponentScan;
import tech.zuosi.lk.littlespring.ioc.exception.InvalidPackageException;

/**
 * Created by luckykoala on 19-3-1.
 */
@ComponentScan(basePackages = "wrong.package")
public class InvalidPackageTest {
    @Test(expected = InvalidPackageException.class)
    public void test() throws Exception {
        new LittleSpring(InvalidPackageTest.class);
    }
}
