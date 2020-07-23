package org.llf.activator;

import com.alibaba.fastjson.JSON;
import com.alipay.sofa.ark.spi.model.PluginContext;
import com.alipay.sofa.ark.spi.registry.ServiceFilter;
import com.alipay.sofa.ark.spi.registry.ServiceReference;
import com.alipay.sofa.ark.spi.service.PluginActivator;
import llf.common.facade.PluginInfoFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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
        System.out.println("use-storage启动了："+ JSON.toJSONString(pluginContext.getPluginNames()));
        ClassLoader myql=pluginContext.getPlugin("mysql-storage").getPluginClassLoader();
        ClassLoader disk=pluginContext.getPlugin("disk-storage").getPluginClassLoader();
        String mysqlExp=JSON.toJSONString(pluginContext.getPlugin("mysql-storage").getExportClasses());
        String diskExp=JSON.toJSONString(pluginContext.getPlugin("disk-storage").getExportClasses());
        logger.info("use-storage获取邻居的信息：classLoader-mysql={},classLoader-disk={},export-mysql={},export-disk={}",myql,disk,mysqlExp,diskExp);

        //调用隔壁插件服务
        try {

            List<ServiceReference>  serviceReferenceList= pluginContext.referenceServices(new ServiceFilter() {
                @Override
                public boolean match(ServiceReference serviceReference) {
                    System.out.println(">>>>>"+serviceReference.getServiceMetadata().getInterfaceClass().getName());
                   if( "llf.common.facade.PluginInfoFacade".equals(serviceReference.getServiceMetadata().getInterfaceClass().getName())){

//                       PluginInfoFacade tp= (PluginInfoFacade)(serviceReference.getService());
//                       tp.getMyName();
                        return true;
                    }
                   return false;
                }
            });

           for( ServiceReference<PluginInfoFacade> plf:  serviceReferenceList){
               System.out.println("plf="+plf);
//               plf.getService().getMyName();
           }


            ServiceReference<PluginInfoFacade> mysqlReference = pluginContext.referenceService(PluginInfoFacade.class, "mysqlname");
            System.out.println("mysqlReference="+mysqlReference);
            //引用插件A的服务
            ServiceReference<PluginInfoFacade> diskReference = pluginContext.referenceService(PluginInfoFacade.class, "diskname");
            //打印结果 diskReferenc=null ；如法获取到diskReference
            System.out.println("diskReference="+diskReference);

//            logger.info("调用隔壁插件的PluginInfoFacade接口结果：disk-storage={},mysql-storage={}", diskReference.getService().getMyName(), mysqlReference.getService().getMyName());
            logger.info("调用隔壁插件的PluginInfoFacade接口结果：disk-storage={},mysql-storage={}", diskReference, mysqlReference);
            Thread.sleep(22200);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {

        }
    }

    @Override
    public void stop(PluginContext pluginContext) {
        System.out.println("use-storage停止了");
    }
}
