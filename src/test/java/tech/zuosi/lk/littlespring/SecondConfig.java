package tech.zuosi.lk.littlespring;

import tech.zuosi.lk.littlespring.ioc.Bean;
import tech.zuosi.lk.littlespring.ioc.Configuration;

@Configuration
public class SecondConfig {
    @Bean
    public FakeBean bean3() {
        return new FakeBean();
    }
}
