package com.os.fanout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;


/**
 * this annotation lets spring boot setup objects based on jars that are located in the classpath
 * For example, if you have the oracle.jar in the classpath along with the spring-boot-jdbc jar then it will
 * create a connection pool for you...
 */
@EnableAutoConfiguration

/**
 * This annotation causes the @Configuration annotated classes to be available so that any objects or configuration
 * that they use is available for spring's dependency injection framework to create
 *
 * If you look at MetricsConfig, TracesConfig, and LogsConfig:
 * each of those classes you'll notice an @ComponentScan annotation. The @ComponentScan looks at a package and
 * allows spring dependency injection framework to instantiate all the spring related objects.
 *
 * This is important because it allows the application to only instantiate the correct for a given data type.
 * For example, when we need a fanout.metrics application only the classes in the com.os.fanout.metrics package
 * should be created. It is possible to pass a comma separated list of packages to the @ComponentScan annotation
 * so that other custom spring code can also be instantiated if needed.
 *
 * In order to make all this work another spring boot configuration is necessary. That is the @Profile annotation.
 * Looking at the LogsConfig, MetricsConfig, and TracesConfig you can see that each of them have an @Profile("profile.name")
 * annotation. This @Profile annotation and the @ComponentScan annotation are what enable the applications to be
 * bootstrapped independently of each other.
 *
 * To enable the profile we must pass the profile name into the spring boot application when we start it.
 * This will enable the fanout.traces application:
 *   SPRING_PROFILES_ACTIVE=fanout.traces
 *
 * That is the configuration that would need to be added to the k8's application. Also tests will need to be annotated
 * with the profile that they depend on so that the correct objects are created.
 *
 */
@Import({MetricsConfig.class, TracesConfig.class, LogsConfig.class})
public class FanoutApplication implements CommandLineRunner {

    /**
     * If for some reason you need to lookup a specific bean for bootstrapping you can use the ApplicationContext
     *
     * applicationContext.getBean(string name of bean, or MyBean.class)
     */
    @Autowired
    private ApplicationContext applicationContext;


    /**
     * If you need to perform logic in bootstrapping you can inject the current profile
     */
    @Value("${spring.profiles.active}")
    private String profile;

    public static void main(String[] args) {
        SpringApplication.run(FanoutApplication.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println(profile);
        System.out.println("in application");

    }
}