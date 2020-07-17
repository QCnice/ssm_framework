package com.geek.handler;

import com.geek.dto.Result;
import com.geek.pojo.Dep;
import com.geek.pojo.User;
import com.geek.redis.RedisUtil;
import com.geek.service.DepService;
import com.geek.util.NameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.util.List;

@RestController
public class DepHandler {
    @Autowired
    private DepService depService;
    @Autowired
    private RedisUtil redisUtil;
    @GetMapping("depInfo")
    public Result findAllDep(HttpSession session){
        Result result=new Result();
        if (redisUtil.get("depList")==null){
            //获取部门的集合
            List<Dep>list=depService.findAllDep();
            redisUtil.set("depList",list,60*60*24);
        }
        List<Dep>list= (List<Dep>) redisUtil.get("depList");
        //获取session中的登录对象
        User user= (User) session.getAttribute(NameUtil.LOGIN_USER);
        result.setList(list);
        result.setObject(user);
        return result;
    }
    @GetMapping("DepAndEmp/{depId}")
    public Result findDepAndEmp(@PathVariable("depId") int depId){
        Result result=new Result();

        if (redisUtil.get("Dep"+depId)==null){
            Dep dep=depService.findDepByDepId(depId);
            redisUtil.set("Dep"+depId,dep,60*60);
        }
        Dep dep= (Dep) redisUtil.get("Dep"+depId);
//        System.out.println(dep.getDepName()+"  "+dep.getEmpList());
        result.setObject(dep);
        return result;
    }


}
