package com.plan.work.controller;

import com.plan.work.entity.TbPrinttemplate;
import com.plan.work.service.WorkService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/work")
public class WorkController {
    private static Logger log = Logger.getLogger(WorkController.class);
    @Autowired
    private WorkService workService;
    /**
     *
     * @return
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public TbPrinttemplate worktes(HttpServletRequest request){
        String ip = request.getHeader("X-Real-IP");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        log.error(ip);
        log.info("info");
        log.debug("debug");
        log.error("error");
        log.warn("warn");
        return workService.work();
    }
}
