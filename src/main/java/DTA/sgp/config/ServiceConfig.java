package DTA.sgp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("DTA.sgp.service")
@Import(JPAConfig.class)
public class ServiceConfig {

}
