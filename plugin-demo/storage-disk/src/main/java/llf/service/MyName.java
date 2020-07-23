package llf.service;

import llf.common.facade.PluginInfoFacade;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-06-29
 * Time 10:41
 */
public class MyName implements PluginInfoFacade {
    @Override
    public String getMyName() {
        return "my name is storage-disk"+this;
    }
}
