package com.example.latte.app;

import java.util.WeakHashMap;
import java.util.jar.Attributes;

/**
 * @author caihhui
 * @time 2018/4/10  11:18
 * @desc ${TODD}
 */

//配置文件的存储以及获取
public class Configurator {


    private  static  final WeakHashMap<String,Object> LATTE_CONFIGS = new WeakHashMap<>();

    private  Configurator(){
            LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),false);
    }

    public  final  void  configure(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),true);

    }

    //单列静态内部内类
    private  static  class  Holder{

        private  static  final  Configurator INSTANCE  =new Configurator();
    }
    public  static  Configurator getInstance(){
        return  Holder.INSTANCE;

    }

    public  final  WeakHashMap<String,Object> getLatteConfigs(){

        return LATTE_CONFIGS;
    }

    public  final  Configurator withApiHost(String host){
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(),host);
        return this;

    }
    //检查配置文件完成未
    private  void  checkConfiguration(){

        final  boolean  isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady){

            throw  new RuntimeException("Configuration is not ready,call configure");
        }
    }


    @SuppressWarnings("unchecked")
    final  <T> T getConfiguration(Enum<ConfigType> key){
            checkConfiguration();
            return  (T)LATTE_CONFIGS.get(key.name());

    }

}
