
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-06-22
 * Time 9:54
 */
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages={"llf","org.llf"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
        System.out.println("App Application started");
    }

}
