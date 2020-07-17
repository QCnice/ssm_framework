package com.geek.handler;

import com.geek.pojo.User;
import com.geek.redis.RedisUtil;
import com.geek.service.UserService;
import com.geek.util.NameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserHandler {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;
    @GetMapping("login")
    public String login(String userName, String password, HttpSession session){
        User user=userService.findUserByUserName(userName);
        if (user!=null){
            if (user.getPassword().equals(password)){
                   //将用户存入session
                    session.setAttribute(NameUtil.LOGIN_USER,user);
                    System.out.println("已存入");
                return "1";
            }else {
                return "2";
            }
        }else {
            return "3";
        }

    }
}
