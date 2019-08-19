package com.plan.work.service;

import com.plan.work.dao.TbPrinttemplateMapper;
import com.plan.work.entity.TbPrinttemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkService {
    @Autowired
    private TbPrinttemplateMapper tbPrinttemplateMapper;

    public String work(){
        TbPrinttemplate tbPrinttemplate = new TbPrinttemplate();
        List<TbPrinttemplate> tbPrinttemplateList =tbPrinttemplateMapper.selectByEntitySelective(tbPrinttemplate);
        return  tbPrinttemplateList.toString();
    }

}
