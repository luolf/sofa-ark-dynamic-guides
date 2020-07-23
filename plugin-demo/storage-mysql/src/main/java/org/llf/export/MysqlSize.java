package org.llf.export;

import org.llf.SayHi;
import org.llf.impl.SayHiImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-06-24
 * Time 10:45
 */
@Component
public class MysqlSize {

    SayHi sayHi;

    @Autowired
    public MysqlSize(SayHi sayHi) {
        this.sayHi = sayHi;
    }

    public int size() {
        return 1000;
    }

    public String say(String name) {
        return sayHi.say(name) + this;
    }
}
