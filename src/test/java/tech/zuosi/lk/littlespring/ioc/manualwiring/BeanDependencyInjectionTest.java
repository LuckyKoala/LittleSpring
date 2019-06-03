package tech.zuosi.lk.littlespring.ioc.manualwiring;

import org.junit.Assert;
import org.junit.Test;
import tech.zuosi.lk.littlespring.LittleSpring;
import tech.zuosi.lk.littlespring.ioc.annotation.Bean;
import tech.zuosi.lk.littlespring.ioc.annotation.Configuration;
import tech.zuosi.lk.littlespring.ioc.manualwiring.beans.FakeBean;
import tech.zuosi.lk.littlespring.ioc.manualwiring.beans.FakeBeanDependency;

/**
 * Created by luckykoala on 19-2-28.
 */
@Configuration
public class BeanDependencyInjectionTest {
    @Test
    public void test() throws Exception {
        LittleSpring context = new LittleSpring(BeanDependencyInjectionTest.class);
        Assert.assertNotNull(context.getBean("FakeBeanDependency"));
        Assert.assertNotNull(context.getBean("FakeBean"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgument() throws Exception {
        LittleSpring context = new LittleSpring(BeanDependencyInjectionTest.class);
        context.getBean("failure"); //参数无法注入
    }

    @Bean()
    public FakeBeanDependency bean1() {
        return new FakeBeanDependency();
    }

    @Bean
    public FakeBean whatever(FakeBeanDependency fbd) {
        return new FakeBean();
    }

    @Bean("failure")
    public FakeBean nomatter(int i) { return new FakeBean(); }
}
