package tech.zuosi.lk.littlespring;

import org.junit.Assert;
import org.junit.Test;
import tech.zuosi.lk.littlespring.exception.InvalidBeanException;
import tech.zuosi.lk.littlespring.ioc.Bean;
import tech.zuosi.lk.littlespring.ioc.Configuration;

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
