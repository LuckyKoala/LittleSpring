package tech.zuosi.lk.littlespring.ioc.manualwiring.configs;

import tech.zuosi.lk.littlespring.ioc.annotation.Bean;
import tech.zuosi.lk.littlespring.ioc.annotation.Configuration;
import tech.zuosi.lk.littlespring.ioc.manualwiring.beans.FakeBean;

@Configuration
public class SecondConfig {
    @Bean("bean3")
    public FakeBean bean3() {
        return new FakeBean();
    }
}
