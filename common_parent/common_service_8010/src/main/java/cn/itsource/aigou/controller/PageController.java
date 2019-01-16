package cn.itsource.aigou.controller;

import cn.itsource.aigou.client.PageClient;
import cn.itsource.aigou.utils.VelocityUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
//静态页面服务
@RestController
public class PageController implements PageClient {
    @Override
    @RequestMapping(value = "/page",method = RequestMethod.POST)
    public  void genStaticPage(@RequestBody Map<String,Object> params){
        // 拿到model
        Object model = params.get("model");
        // tmeplatePath 转成string
       String tmeplatePath = (String) params.get("tmeplatePath");
       //  staticPagePath
        String staticPagePath = (String) params.get("staticPagePath");
        System.out.println(model);
        System.out.println(tmeplatePath);
        System.out.println(staticPagePath);
        //调用模板  三个值模型 模板路径 目标路径
        VelocityUtils.staticByTemplate(model, tmeplatePath, staticPagePath);
    }
}
