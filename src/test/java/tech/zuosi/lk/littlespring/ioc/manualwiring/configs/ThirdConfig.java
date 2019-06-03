package tech.zuosi.lk.littlespring.ioc.manualwiring.configs;

import tech.zuosi.lk.littlespring.ioc.annotation.Bean;
import tech.zuosi.lk.littlespring.ioc.annotation.Configuration;
import tech.zuosi.lk.littlespring.ioc.manualwiring.beans.FakeBean;

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
