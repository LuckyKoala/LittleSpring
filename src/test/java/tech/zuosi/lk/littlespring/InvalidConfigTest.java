package tech.zuosi.lk.littlespring;

import org.junit.Test;
import tech.zuosi.lk.littlespring.exception.InvalidConfigurationException;
import tech.zuosi.lk.littlespring.ioc.Configuration;
import tech.zuosi.lk.littlespring.ioc.Import;

/**
 * Created by luckykoala on 19-2-28.
 */
@Configuration
@Import(FourthConfig.class)
public class InvalidConfigTest {
    @Test(expected = InvalidConfigurationException.class)
    public void test() throws Exception {
        new LittleSpring(InvalidConfigTest.class);
    }
}
