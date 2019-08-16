package com.plan.work.entity;


import com.plan.util.Remark;

public class TbPrinttemplate {
    /**
     *  主键,所属表字段为TB_PRINTTEMPLATE.ID
     *
     * @mbggenerated
     */
    @Remark("主键")
    private String id;

    /**
     *  模板类型kg-客管,lf-路罚，lp-路赔,cx-超限,所属表字段为TB_PRINTTEMPLATE.TEMPLATE_TYPE
     *
     * @mbggenerated
     */
    @Remark("模板类型kg-客管,lf-路罚，lp-路赔,cx-超限")
    private String templateType;

    /**
     *  模板名称,所属表字段为TB_PRINTTEMPLATE.TEMPLATE_NAME
     *
     * @mbggenerated
     */
    @Remark("模板名称")
    private String templateName;

    /**
     *  顺序值,所属表字段为TB_PRINTTEMPLATE.ORDER_VALUE
     *
     * @mbggenerated
     */
    @Remark("顺序值")
    private String orderValue;

    /**
     *  模板代码值,所属表字段为TB_PRINTTEMPLATE.TEMPLATE_CODE
     *
     * @mbggenerated
     */
    @Remark("模板代码值")
    private String templateCode;

    /**
     *  模板存放路径,所属表字段为TB_PRINTTEMPLATE.TEMPLATE_PATH
     *
     * @mbggenerated
     */
    @Remark("模板存放路径")
    private String templatePath;

    /**
     *  模板流程,所属表字段为TB_PRINTTEMPLATE.TEMPLATE_PROCESS
     *
     * @mbggenerated
     */
    @Remark("模板流程")
    private String templateProcess;

    /**
     *  文件类型0-文书，1-附件,2-其他,所属表字段为TB_PRINTTEMPLATE.FILE_TYPE
     *
     * @mbggenerated
     */
    @Remark("文件类型0-文书，1-附件,2-其他")
    private String fileType;

    /**
     *  父模版代码值,所属表字段为TB_PRINTTEMPLATE.PARENT_CODE
     *
     * @mbggenerated
     */
    @Remark("父模版代码值")
    private String parentCode;

    /**
     *  文号前缀,所属表字段为TB_PRINTTEMPLATE.SYMBOL_PREFIX
     *
     * @mbggenerated
     */
    @Remark("文号前缀")
    private String symbolPrefix;

    /**
     * 获取 主键 字段:TB_PRINTTEMPLATE.ID
     *
     * @return TB_PRINTTEMPLATE.ID, 主键
     *
     * @mbggenerated
     */
    @Remark("主键")
    public String getId() {
        return id;
    }

    /**
     * 设置 主键 字段:TB_PRINTTEMPLATE.ID
     *
     * @param id TB_PRINTTEMPLATE.ID, 主键
     *
     * @mbggenerated
     */
    @Remark("主键")
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 模板类型kg-客管,lf-路罚，lp-路赔,cx-超限 字段:TB_PRINTTEMPLATE.TEMPLATE_TYPE
     *
     * @return TB_PRINTTEMPLATE.TEMPLATE_TYPE, 模板类型kg-客管,lf-路罚，lp-路赔,cx-超限
     *
     * @mbggenerated
     */
    @Remark("模板类型kg-客管,lf-路罚，lp-路赔,cx-超限")
    public String getTemplateType() {
        return templateType;
    }

    /**
     * 设置 模板类型kg-客管,lf-路罚，lp-路赔,cx-超限 字段:TB_PRINTTEMPLATE.TEMPLATE_TYPE
     *
     * @param templateType TB_PRINTTEMPLATE.TEMPLATE_TYPE, 模板类型kg-客管,lf-路罚，lp-路赔,cx-超限
     *
     * @mbggenerated
     */
    @Remark("模板类型kg-客管,lf-路罚，lp-路赔,cx-超限")
    public void setTemplateType(String templateType) {
        this.templateType = templateType == null ? null : templateType.trim();
    }

    /**
     * 获取 模板名称 字段:TB_PRINTTEMPLATE.TEMPLATE_NAME
     *
     * @return TB_PRINTTEMPLATE.TEMPLATE_NAME, 模板名称
     *
     * @mbggenerated
     */
    @Remark("模板名称")
    public String getTemplateName() {
        return templateName;
    }

    /**
     * 设置 模板名称 字段:TB_PRINTTEMPLATE.TEMPLATE_NAME
     *
     * @param templateName TB_PRINTTEMPLATE.TEMPLATE_NAME, 模板名称
     *
     * @mbggenerated
     */
    @Remark("模板名称")
    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    /**
     * 获取 顺序值 字段:TB_PRINTTEMPLATE.ORDER_VALUE
     *
     * @return TB_PRINTTEMPLATE.ORDER_VALUE, 顺序值
     *
     * @mbggenerated
     */
    @Remark("顺序值")
    public String getOrderValue() {
        return orderValue;
    }

    /**
     * 设置 顺序值 字段:TB_PRINTTEMPLATE.ORDER_VALUE
     *
     * @param orderValue TB_PRINTTEMPLATE.ORDER_VALUE, 顺序值
     *
     * @mbggenerated
     */
    @Remark("顺序值")
    public void setOrderValue(String orderValue) {
        this.orderValue = orderValue == null ? null : orderValue.trim();
    }

    /**
     * 获取 模板代码值 字段:TB_PRINTTEMPLATE.TEMPLATE_CODE
     *
     * @return TB_PRINTTEMPLATE.TEMPLATE_CODE, 模板代码值
     *
     * @mbggenerated
     */
    @Remark("模板代码值")
    public String getTemplateCode() {
        return templateCode;
    }

    /**
     * 设置 模板代码值 字段:TB_PRINTTEMPLATE.TEMPLATE_CODE
     *
     * @param templateCode TB_PRINTTEMPLATE.TEMPLATE_CODE, 模板代码值
     *
     * @mbggenerated
     */
    @Remark("模板代码值")
    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode == null ? null : templateCode.trim();
    }

    /**
     * 获取 模板存放路径 字段:TB_PRINTTEMPLATE.TEMPLATE_PATH
     *
     * @return TB_PRINTTEMPLATE.TEMPLATE_PATH, 模板存放路径
     *
     * @mbggenerated
     */
    @Remark("模板存放路径")
    public String getTemplatePath() {
        return templatePath;
    }

    /**
     * 设置 模板存放路径 字段:TB_PRINTTEMPLATE.TEMPLATE_PATH
     *
     * @param templatePath TB_PRINTTEMPLATE.TEMPLATE_PATH, 模板存放路径
     *
     * @mbggenerated
     */
    @Remark("模板存放路径")
    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath == null ? null : templatePath.trim();
    }

    /**
     * 获取 模板流程 字段:TB_PRINTTEMPLATE.TEMPLATE_PROCESS
     *
     * @return TB_PRINTTEMPLATE.TEMPLATE_PROCESS, 模板流程
     *
     * @mbggenerated
     */
    @Remark("模板流程")
    public String getTemplateProcess() {
        return templateProcess;
    }

    /**
     * 设置 模板流程 字段:TB_PRINTTEMPLATE.TEMPLATE_PROCESS
     *
     * @param templateProcess TB_PRINTTEMPLATE.TEMPLATE_PROCESS, 模板流程
     *
     * @mbggenerated
     */
    @Remark("模板流程")
    public void setTemplateProcess(String templateProcess) {
        this.templateProcess = templateProcess == null ? null : templateProcess.trim();
    }

    /**
     * 获取 文件类型0-文书，1-附件,2-其他 字段:TB_PRINTTEMPLATE.FILE_TYPE
     *
     * @return TB_PRINTTEMPLATE.FILE_TYPE, 文件类型0-文书，1-附件,2-其他
     *
     * @mbggenerated
     */
    @Remark("文件类型0-文书，1-附件,2-其他")
    public String getFileType() {
        return fileType;
    }

    /**
     * 设置 文件类型0-文书，1-附件,2-其他 字段:TB_PRINTTEMPLATE.FILE_TYPE
     *
     * @param fileType TB_PRINTTEMPLATE.FILE_TYPE, 文件类型0-文书，1-附件,2-其他
     *
     * @mbggenerated
     */
    @Remark("文件类型0-文书，1-附件,2-其他")
    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    /**
     * 获取 父模版代码值 字段:TB_PRINTTEMPLATE.PARENT_CODE
     *
     * @return TB_PRINTTEMPLATE.PARENT_CODE, 父模版代码值
     *
     * @mbggenerated
     */
    @Remark("父模版代码值")
    public String getParentCode() {
        return parentCode;
    }

    /**
     * 设置 父模版代码值 字段:TB_PRINTTEMPLATE.PARENT_CODE
     *
     * @param parentCode TB_PRINTTEMPLATE.PARENT_CODE, 父模版代码值
     *
     * @mbggenerated
     */
    @Remark("父模版代码值")
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    /**
     * 获取 文号前缀 字段:TB_PRINTTEMPLATE.SYMBOL_PREFIX
     *
     * @return TB_PRINTTEMPLATE.SYMBOL_PREFIX, 文号前缀
     *
     * @mbggenerated
     */
    @Remark("文号前缀")
    public String getSymbolPrefix() {
        return symbolPrefix;
    }

    /**
     * 设置 文号前缀 字段:TB_PRINTTEMPLATE.SYMBOL_PREFIX
     *
     * @param symbolPrefix TB_PRINTTEMPLATE.SYMBOL_PREFIX, 文号前缀
     *
     * @mbggenerated
     */
    @Remark("文号前缀")
    public void setSymbolPrefix(String symbolPrefix) {
        this.symbolPrefix = symbolPrefix == null ? null : symbolPrefix.trim();
    }
}