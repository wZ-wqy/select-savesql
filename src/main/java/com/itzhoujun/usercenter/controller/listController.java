
package com.itzhoujun.usercenter.controller;


import com.itzhoujun.usercenter.domain.entity.ListBean;

import com.itzhoujun.usercenter.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class listController {

    @Autowired
    ListService listService;

    @RequestMapping("/index")
    public String indexmain() {
        return "index";
    }

    @RequestMapping(value = "/select",method = RequestMethod.POST)
    public String login(int id){
        ListBean listBean = listService.select(id);
        if(listBean!=null){
            return "success";
        }else {
            return "error";
        }
    }


}