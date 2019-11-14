package com.itheima.controller;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/save",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Account account){
        System.out.println(account);
        accountService.save(account);
        return "save success";
    }

    @RequestMapping(value = "/findAll",produces = "text/html;charset=UTF-8")
    public ModelAndView findAll(){
        ModelAndView modelAndView=new ModelAndView();
        List<Account> list = accountService.findAll();
        System.out.println(list);
        modelAndView.setViewName("accountList");
        modelAndView.addObject("accountList",list);
        return modelAndView;
    }
}
