package tech.zuosi.lk.littlespring.ioc.manualwiring;

import tech.zuosi.lk.littlespring.ioc.annotation.Bean;

/**
 * Created by luckykoala on 19-2-28.
 */
public class FourthConfig {
    @Bean
    public FakeBean bean5() {
        return new FakeBean();
    }
}
