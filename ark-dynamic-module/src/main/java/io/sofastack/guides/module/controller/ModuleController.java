package io.sofastack.guides.module.controller;

import llf.export.DiskSize;
import org.llf.export.MysqlSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: guolei.sgl (glmapper_2018@163.com) 2020/6/13 2:36 PM
 * @since:
 **/
@RestController
@RequestMapping("api")
public class ModuleController {
    @Autowired
    DiskSize diskSize;
    @Autowired
    MysqlSize mysqlSize;

    @RequestMapping("module")
    public String master(){
        return "SUCCESS FROM MODULE";
    }

    @RequestMapping("disk")
    public String Disk(String name){
        System.out.println("master:diskSize="+diskSize+";mysqlSize="+mysqlSize);
        return diskSize.say(name)+":"+diskSize;
    }
    @RequestMapping("mysql")
    public String mysql(String name){
        return  mysqlSize.say(name)+":"+mysqlSize;
    }

}
