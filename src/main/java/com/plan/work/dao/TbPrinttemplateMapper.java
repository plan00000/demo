package com.plan.work.dao;

import com.plan.mybatis.MyBatisWjqDao;
import com.plan.work.entity.TbPrinttemplate;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatisWjqDao
public interface TbPrinttemplateMapper {
    /**
     *  根据主键删除数据库的记录,TB_PRINTTEMPLATE
     *
     * @param id
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(@Param("id") String id);

    /**
     *  根据实体类属性值动态生成删除条件,TB_PRINTTEMPLATE
     *
     * @param record
     *
     * @mbggenerated
     */
    int deleteByEntitySelective(TbPrinttemplate record);

    /**
     *  新写入数据库记录,TB_PRINTTEMPLATE
     *
     * @param record
     *
     * @mbggenerated
     */
    int insert(TbPrinttemplate record);

    /**
     *  动态字段,写入数据库记录,TB_PRINTTEMPLATE
     *
     * @param record
     *
     * @mbggenerated
     */
    int insertSelective(TbPrinttemplate record);

    /**
     *  根据指定主键获取一条数据库记录,TB_PRINTTEMPLATE
     *
     * @param id
     *
     * @mbggenerated
     */
    TbPrinttemplate selectByPrimaryKey(@Param("id") String id);

    /**
     *  根据实体类属性值动态生成查询条件,TB_PRINTTEMPLATE
     *
     * @param record
     *
     * @mbggenerated
     */
    List<TbPrinttemplate> selectByEntitySelective(TbPrinttemplate record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,TB_PRINTTEMPLATE
     *
     * @param record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TbPrinttemplate record);

    /**
     *  根据实体类属性值动态生成修改条件,TB_PRINTTEMPLATE
     *
     * @param record
     * @param condition
     *
     * @mbggenerated
     */
    int updateByEntitySelective(@Param("record") TbPrinttemplate record, @Param("condition") TbPrinttemplate condition);
}