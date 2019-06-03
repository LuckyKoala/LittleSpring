package tech.zuosi.lk.littlespring.ioc.manualwiring.configs;

import tech.zuosi.lk.littlespring.ioc.annotation.Bean;
import tech.zuosi.lk.littlespring.ioc.manualwiring.beans.FakeBean;

/**
 * Created by luckykoala on 19-2-28.
 */
public class FourthConfig {
    @Bean
    public FakeBean bean5() {
        return new FakeBean();
    }
}
