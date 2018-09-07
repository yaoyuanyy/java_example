package com.yy.idea_mybatis_generater.mapper.base;

import com.yy.idea_mybatis_generater.model.UserAccountTransfer;

import java.util.List;
/**
*  @author author
*/
public interface UserAccountTransferBaseMapper {

    int insertUserAccountTransfer(UserAccountTransfer object);

    int updateUserAccountTransfer(UserAccountTransfer object);

    int update(UserAccountTransfer.UpdateBuilder object);

    List<UserAccountTransfer> queryUserAccountTransfer(UserAccountTransfer object);

    UserAccountTransfer queryUserAccountTransferLimit1(UserAccountTransfer object);

}