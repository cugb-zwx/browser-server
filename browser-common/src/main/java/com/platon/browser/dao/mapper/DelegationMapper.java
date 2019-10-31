package com.platon.browser.dao.mapper;

import com.platon.browser.dao.entity.Delegation;
import com.platon.browser.dao.entity.DelegationExample;
import com.platon.browser.dao.entity.DelegationKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DelegationMapper {
    long countByExample(DelegationExample example);

    int deleteByExample(DelegationExample example);

    int deleteByPrimaryKey(DelegationKey key);

    int insert(Delegation record);

    int insertSelective(Delegation record);

    List<Delegation> selectByExample(DelegationExample example);

    Delegation selectByPrimaryKey(DelegationKey key);

    int updateByExampleSelective(@Param("record") Delegation record, @Param("example") DelegationExample example);

    int updateByExample(@Param("record") Delegation record, @Param("example") DelegationExample example);

    int updateByPrimaryKeySelective(Delegation record);

    int updateByPrimaryKey(Delegation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table delegation
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int batchInsert(@Param("list") List<Delegation> list);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table delegation
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int batchInsertSelective(@Param("list") List<Delegation> list, @Param("selective") Delegation.Column ... selective);
}