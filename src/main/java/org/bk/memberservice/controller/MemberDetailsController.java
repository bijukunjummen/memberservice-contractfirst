package org.bk.memberservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/memberdetails")
public class MemberDetailsController {
    
    @RequestMapping("list")
    public String list(){
        return "list";
    }

}
