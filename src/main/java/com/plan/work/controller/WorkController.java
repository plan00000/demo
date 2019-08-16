package com.plan.work.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/work")
public class WorkController {
    /**
     *
     * @return
     */
    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public String worktes(){
        return "hello";
    }
}
