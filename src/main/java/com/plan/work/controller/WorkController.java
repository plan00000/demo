package com.plan.work.controller;

import com.plan.entity.Result;
import com.plan.exception.BaseException;
import com.plan.exception.SystemException;
import com.plan.helper.ResultHelper;
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
    public Result worktes(HttpServletRequest request)throws RuntimeException{
        try {
            String ip = request.getHeader("X-Real-IP");
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
            log.error(ip);
            log.info("info");
            log.debug("debug");
            log.error("error");
            log.warn("warn");
            TbPrinttemplate tbPrinttemplate = workService.work();
            return ResultHelper.success(tbPrinttemplate);
        }catch (Exception e) {
            if (e instanceof BaseException) {
                throw (BaseException) e;
            } else {
                throw new SystemException("注销登记查询出错", e, "请联系管理员！");
            }
        }
    }
}
