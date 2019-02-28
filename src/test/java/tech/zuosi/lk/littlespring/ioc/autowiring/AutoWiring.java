package tech.zuosi.lk.littlespring.ioc.autowiring;

import org.junit.Assert;
import org.junit.Test;
import tech.zuosi.lk.littlespring.LittleSpring;
import tech.zuosi.lk.littlespring.ioc.annotation.ComponentScan;

/**
 * Created by luckykoala on 19-2-28.
 */
@ComponentScan
public class AutoWiring {
    @Test
    public void test() throws Exception {
        LittleSpring context = new LittleSpring(AutoWiring.class);
        Assert.assertNotNull(context.getBean("whole"));
    }
}
