package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("test")
@Import(ModelContextConfig.class)
public class ServiceContextConfig {
}
