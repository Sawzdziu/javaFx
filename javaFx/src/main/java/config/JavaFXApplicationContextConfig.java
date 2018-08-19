package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("controllers")
@Import(ServiceContextConfig.class)
public class JavaFXApplicationContextConfig {
}
