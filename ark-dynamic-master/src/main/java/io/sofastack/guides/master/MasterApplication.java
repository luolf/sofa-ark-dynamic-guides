package io.sofastack.guides.master;

import llf.SayHi;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @author: guolei.sgl (glmapper_2018@163.com) 2020/6/13 2:18 PM
 * @since:
 **/

/**
 * 插件内的spring注解扫描，要在biz层的启动类中，不同的biz要负责对自己引入的插件做扫描。
 * biz之间的spring容器是相互隔离的
 * 插件内不会有spring容器
 * biz之间的服务调用采用sofa rpc方式。
 * 插件之间的通信，采用插件发布、引用服务的方式，要受export\import约束
 */
@SpringBootApplication
@ComponentScan(basePackages={"llf","io.sofastack.guides.master","org.llf"})
public class MasterApplication implements ApplicationContextAware {
    public static void main(String[] args) {
        SpringApplication.run(MasterApplication.class,args);
        System.out.println("主要的业务模块Master Application started");

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("bean:***********************************");
        String[] beans=applicationContext.getBeanDefinitionNames();
        System.out.println(" **********************************************************************  diskSize= " + applicationContext.getBean("diskSize"));
        for(int i=0;i<beans.length;i++){
            System.out.println("@@@@@@@@@@@@bean:"+beans[i]);

        }
    }
}
