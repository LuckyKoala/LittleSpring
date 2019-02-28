package tech.zuosi.lk.littlespring.ioc.manualwiring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tech.zuosi.lk.littlespring.LittleSpring;
import tech.zuosi.lk.littlespring.ioc.annotation.Bean;
import tech.zuosi.lk.littlespring.ioc.annotation.Configuration;
import tech.zuosi.lk.littlespring.ioc.annotation.Import;

/**
 * Created by luckykoala on 19-2-28.
 */
@Configuration
@Import(SecondConfig.class)
@Import(ThirdConfig.class)
public class ManualWiring {
    private LittleSpring context;

    @Before
    public void init() throws Exception {
        context = new LittleSpring(ManualWiring.class);
    }

    @Test
    public void testBeanAnnotation() throws Exception {
        Assert.assertNotNull(context.getBean("bean1"));
        Assert.assertNotNull(context.getBean("b2"));
    }

    @Test
    public void testImport() throws Exception {
        Assert.assertNotNull(context.getBean("bean3"));
        Assert.assertNotNull(context.getBean("bean4"));
    }

    @Bean
    public FakeBean bean1() {
        return new FakeBean();
    }

    @Bean("b2")
    public FakeBean bean2() {
        return new FakeBean();
    }
}
