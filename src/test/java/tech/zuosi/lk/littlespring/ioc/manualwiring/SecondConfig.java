package tech.zuosi.lk.littlespring.ioc.manualwiring;

import tech.zuosi.lk.littlespring.ioc.annotation.Bean;
import tech.zuosi.lk.littlespring.ioc.annotation.Configuration;

@Configuration
public class SecondConfig {
    @Bean
    public FakeBean bean3() {
        return new FakeBean();
    }
}
