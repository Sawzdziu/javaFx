package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("controller")
@Import(ServiceContextConfig.class)
public class JavaFXApplicationContextConfig {
}
