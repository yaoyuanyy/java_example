package com.yy.mybatis_generator_plugin.mapper;

import com.yy.mybatis_generator_plugin.model.butlerEvaluateUser;
import com.yy.mybatis_generator_plugin.model.butlerEvaluateUserExample;

public interface butlerEvaluateUserMapper {
    int deleteByExample(butlerEvaluateUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(butlerEvaluateUser record);

    int insertSelective(butlerEvaluateUser record);

    butlerEvaluateUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(butlerEvaluateUser record);

    int updateByPrimaryKey(butlerEvaluateUser record);
}