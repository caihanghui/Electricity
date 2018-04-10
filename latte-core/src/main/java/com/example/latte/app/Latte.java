package com.example.latte.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * @author caihhui
 * @time 2018/4/10  11:11
 * @desc ${TODD}
 */
//对外的工具类
public  final  class Latte {

              public  static  Configurator init(Context context){
                    getConfiguration().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
                    return Configurator.getInstance();

              }


              private  static WeakHashMap<String ,Object> getConfiguration(){
                  return Configurator.getInstance().getLatteConfigs();

              }



}
