package com.bolingcavalry.mavendockerplugindemo.Controller.Account;


import com.bolingcavalry.mavendockerplugindemo.Service.Account.AccountService;
import com.bolingcavalry.mavendockerplugindemo.VO.ResponseVO;
import com.bolingcavalry.mavendockerplugindemo.VO.UserForm;
import com.bolingcavalry.mavendockerplugindemo.VO.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class AccountController {
    private final static String ACCOUNT_INFO_ERROR="用户名或密码错误";

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseVO login(@RequestBody UserForm userForm){
        UserVO user = accountService.login(userForm);
        if(user==null){
            return ResponseVO.buildFailure(ACCOUNT_INFO_ERROR);
        }
        return ResponseVO.buildSuccess(user);
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public ResponseVO getUserInfo(@RequestParam("id")long id){
        UserVO user=accountService.getUserInfo(id);
        if(user==null){
            return ResponseVO.buildFailure(ACCOUNT_INFO_ERROR);
        }
        return ResponseVO.buildSuccess(user);
    }



}
