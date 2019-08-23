package com.plan.work.controller;

import com.plan.work.entity.TbPrinttemplate;
import com.plan.work.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/work")
public class WorkController {
    @Autowired
    private WorkService workService;
    /**
     *
     * @return
     */
    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public TbPrinttemplate worktes(){
        return workService.work();
    }
}
