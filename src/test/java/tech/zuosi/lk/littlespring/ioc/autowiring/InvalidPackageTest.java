package tech.zuosi.lk.littlespring.ioc.autowiring;

import org.junit.Test;
import tech.zuosi.lk.littlespring.LittleSpring;
import tech.zuosi.lk.littlespring.exception.InvalidPackageException;
import tech.zuosi.lk.littlespring.ioc.annotation.ComponentScan;

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
