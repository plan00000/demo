package com.plan.work.service;

import com.plan.exception.ConditionException;
import com.plan.exception.SystemException;
import com.plan.util.CommonUtil;
import com.plan.work.dao.TbPrinttemplateMapper;
import com.plan.work.entity.TbPrinttemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkService {
    @Autowired
    private TbPrinttemplateMapper tbPrinttemplateMapper;

    public TbPrinttemplate work(){
        TbPrinttemplate tbPrinttemplate = tbPrinttemplateMapper.selectByPrimaryKey("871AFE078A25D6A7E050050A7D1279D3");
        return tbPrinttemplate;
    }

}
