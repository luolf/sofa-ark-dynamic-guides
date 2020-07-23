package llf.impl;

import llf.SayHi;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-06-24
 * Time 10:38
 */
@Component

public class SayHiImplDisk implements SayHi {

    @Override
    public String say(String name) {
        System.out.println("from "+PLUGIN+" module**** hi:"+name+this);
        return "from "+PLUGIN+" module****hi:"+name+this;
    }
    @PostConstruct
    public void print(){
        System.out.println(" yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyPostConstruct  "+this);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
