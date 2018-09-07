package com.yy.mybatis_generator.dao;

import com.yy.mybatis_generator.entity.ButlerEvaluateUser;
import com.yy.mybatis_generator.entity.ButlerEvaluateUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ButlerEvaluateUserMapper {
    /**
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    long countByExample(ButlerEvaluateUserExample example);

    /**
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    int deleteByExample(ButlerEvaluateUserExample example);

    /**
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    int insert(ButlerEvaluateUser record);

    /**
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    int insertSelective(ButlerEvaluateUser record);

    /**
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    List<ButlerEvaluateUser> selectByExample(ButlerEvaluateUserExample example);

    /**
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    ButlerEvaluateUser selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    int updateByExampleSelective(@Param("record") ButlerEvaluateUser record, @Param("example") ButlerEvaluateUserExample example);

    /**
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    int updateByExample(@Param("record") ButlerEvaluateUser record, @Param("example") ButlerEvaluateUserExample example);

    /**
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    int updateByPrimaryKeySelective(ButlerEvaluateUser record);

    /**
     *
     * @mbg.generated Fri Sep 07 18:24:29 CST 2018
     */
    int updateByPrimaryKey(ButlerEvaluateUser record);
}