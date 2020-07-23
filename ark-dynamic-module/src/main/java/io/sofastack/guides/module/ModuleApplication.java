package io.sofastack.guides.module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: guolei.sgl (glmapper_2018@163.com) 2020/6/13 2:27 PM
 * @since:
 **/
@SpringBootApplication
@ComponentScan(basePackages={"llf","io.sofastack.guides.module","org.llf"})
public class ModuleApplication {

    public static void main(String[] args) {
//        SpringApplication.run(ModuleApplication.class,args);
        System.out.println("Module Application started");
            Integer a = 1;
            Integer b = 2;
            Integer c = 3;
            Integer d = 3;
            Integer e = 321;
            Integer f = 321;
            Long g = 3L;
            System.out.println(c == d);
            System.out.println(e == f);
            System.out.println(c == (a + b));
            System.out.println(c.equals(a + b));
            System.out.println(g == (a + b));
            System.out.println(g.equals(a + b));

    }
}
