package com.platon.browser.dao.mapper;

import com.platon.browser.dao.entity.RpPlan;
import com.platon.browser.dao.entity.RpPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RpPlanMapper {
    long countByExample(RpPlanExample example);

    int deleteByExample(RpPlanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RpPlan record);

    int insertSelective(RpPlan record);

    List<RpPlan> selectByExample(RpPlanExample example);

    RpPlan selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RpPlan record, @Param("example") RpPlanExample example);

    int updateByExample(@Param("record") RpPlan record, @Param("example") RpPlanExample example);

    int updateByPrimaryKeySelective(RpPlan record);

    int updateByPrimaryKey(RpPlan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rp_plan
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int batchInsert(@Param("list") List<RpPlan> list);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rp_plan
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int batchInsertSelective(@Param("list") List<RpPlan> list, @Param("selective") RpPlan.Column ... selective);
}