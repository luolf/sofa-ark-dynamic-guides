package org.llf.activator;

import com.alibaba.fastjson.JSON;
import com.alipay.sofa.ark.spi.model.PluginContext;
import com.alipay.sofa.ark.spi.registry.ServiceReference;
import com.alipay.sofa.ark.spi.service.PluginActivator;
import llf.common.facade.PluginInfoFacade;
import org.llf.service.MyName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 插件生命周期处理
 * 插件只需要实现此接口，并在 MANIFEST.MF 中配置 activator 属性，就会在启动时执行 start 方法，停止时执行 stop 方法
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-06-29
 * Time 10:13
 */
public class MyPluginActivator implements PluginActivator {
    Logger logger=LoggerFactory.getLogger(MyPluginActivator.class);
    @Override
    public void start(PluginContext pluginContext) {
        System.out.println("mysql-storage启动了："+ JSON.toJSONString(pluginContext.getPluginNames()));
        ClassLoader mysql=pluginContext.getPlugin("mysql-storage").getPluginClassLoader();
        ClassLoader disk=pluginContext.getPlugin("disk-storage").getPluginClassLoader();
        String mysqlExp=JSON.toJSONString(pluginContext.getPlugin("mysql-storage").getExportClasses());
        String diskExp=JSON.toJSONString(pluginContext.getPlugin("disk-storage").getExportClasses());
        logger.info("获取邻居的信息：classLoader-mysql={},classLoader-disk={},export-mysql={},export-disk={}",mysql,disk,mysqlExp,diskExp);

        //发布插件服务
        pluginContext.publishService(PluginInfoFacade.class,new MyName(),"mysqlname");

        //引用自己的服务
        ServiceReference<PluginInfoFacade> mysqlReference = pluginContext.referenceService(PluginInfoFacade.class, "mysqlname");

//        System.out.println("mysqlReference="+mysqlReference);
    }

    @Override
    public void stop(PluginContext pluginContext) {
        System.out.println("mysql-storage停止了");
    }
}
