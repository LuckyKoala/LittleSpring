package tech.zuosi.lk.littlespring.ioc.manualwiring;

import tech.zuosi.lk.littlespring.ioc.annotation.Bean;
import tech.zuosi.lk.littlespring.ioc.annotation.Configuration;

/**
 * Created by luckykoala on 19-2-28.
 */
@Configuration
public class ThirdConfig {
    @Bean("bean4")
    public FakeBean bean4() {
        return new FakeBean();
    }
}
