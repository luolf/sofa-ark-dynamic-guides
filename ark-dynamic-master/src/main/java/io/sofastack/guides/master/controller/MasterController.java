package io.sofastack.guides.master.controller;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import io.sofastack.guides.facade.TestFacade;
import llf.SayHi;
import llf.export.DiskSize;
import org.llf.export.MysqlSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: guolei.sgl (glmapper_2018@163.com) 2020/6/13 2:32 PM
 * @since:
 **/
@RestController
@RequestMapping("api")
public class MasterController {

    @SofaReference
    private TestFacade testFacade;
    @Autowired
    DiskSize diskSize ;
    @Autowired
    MysqlSize mysqlSize ;

    @Autowired
    SayHi sayHiDisk;
    @Autowired
    org.llf.SayHi sayHiMysql;
    @RequestMapping("master")
    public String master(){
        try {
            return testFacade.testMethod("master PROVIDER");
        } catch (Throwable ex){
            return "THIS IS DEFAULT PROVIDER";
        }
    }


    @RequestMapping("disk")
    public String Disk(String name){
        System.out.println("master:diskSize="+diskSize+";mysqlSize="+mysqlSize+":sayHiDisk="+sayHiDisk+":sayHiMysql="+sayHiMysql);
        return diskSize.say(name)+":"+diskSize;
    }
    @RequestMapping("mysql")
    public String mysql(String name){
        return  mysqlSize.say(name)+":"+mysqlSize;
    }
}
