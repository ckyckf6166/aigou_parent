package cn.itsource.aigou.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 使用接口方式，服务提供者实现此接口，直接注入接口，通过接口调用子类实现的方法
 *   AIGOU-COMMON 服务提供者注册的服务名
 *   fallbackFactory = RedisClientFallbackFactory.class  抄底方法的生成工厂类
 */
@FeignClient(value = "AIGOU-COMMON",fallbackFactory = RedisClientFallbackFactory.class )
public interface RedisClient {
    /**
     *  Feign使用代理模式，定义接口，让服务提供者实现接口，直接注入接口，调用其实现类的方法
     * @param key
     * @param value
     */
    @RequestMapping(value = "/redis",method = RequestMethod.POST)
    void set(@RequestParam("key")String key, @RequestParam("value")String value);
    @RequestMapping(value = "/redis",method = RequestMethod.GET)
    String get(@RequestParam("key")String key);

}