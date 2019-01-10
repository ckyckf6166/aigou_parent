package cn.ttaigou.controller;

import cn.ttaigou.domain.Employee;
import cn.ttaigou.util.AjaxResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping(value = "/login",method = RequestMethod.POST)//地址跟请求方法
    public AjaxResult login(@RequestBody Employee employee) {
        //判断是否为空和密码是否匹配，只有用户名为admin,密码为0才能登陆
        if ("admin".equals(employee.getName())&&"0".equals(employee.getPassword())){
            return AjaxResult.me();
        }
        return AjaxResult.me().setSuccess(false).setMessage("用户名或密码不正确");
    }
}
