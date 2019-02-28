package tech.zuosi.lk.littlespring;

import tech.zuosi.lk.littlespring.ioc.Bean;
import tech.zuosi.lk.littlespring.ioc.Configuration;

/**
 * Created by luckykoala on 19-2-28.
 */
@Configuration
public class ThirdConfig {
    @Bean
    public FakeBean bean4() {
        return new FakeBean();
    }
}
