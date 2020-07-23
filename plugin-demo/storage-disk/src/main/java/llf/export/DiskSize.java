package llf.export;

import llf.SayHi;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-06-24
 * Time 10:45
 */
@Component
public class DiskSize implements ApplicationContextAware {


    SayHi sayHi;
    @Autowired
    public DiskSize(SayHi sayHi) {
        this.sayHi = sayHi;
    }

    public int size() {
        return 1000;
    }

    public String say(String name) {
        System.out.println(this+" : ***********  sayHi= " + sayHi);
        return sayHi.say(name) + this;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {


        SayHi hi=(SayHi)applicationContext.getBean("diskSayHiImpl");
        System.out.println(" **********************************************************************  setApplicationContext " + hi);
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hi.say("测试");
    }
}
