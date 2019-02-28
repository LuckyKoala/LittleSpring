package tech.zuosi.lk.littlespring.ioc.manualwiring;

import org.junit.Test;
import tech.zuosi.lk.littlespring.LittleSpring;
import tech.zuosi.lk.littlespring.exception.InvalidBeanException;
import tech.zuosi.lk.littlespring.ioc.annotation.Bean;
import tech.zuosi.lk.littlespring.ioc.annotation.Configuration;

/**
 * Created by luckykoala on 19-2-28.
 */
@Configuration
public class InvalidBeanTest {
    @Test(expected = InvalidBeanException.class)
    public void test() throws Exception {
        new LittleSpring(InvalidBeanTest.class);
    }

    @Bean
    public FakeBean whatever(int i) {
        return new FakeBean();
    }
}
