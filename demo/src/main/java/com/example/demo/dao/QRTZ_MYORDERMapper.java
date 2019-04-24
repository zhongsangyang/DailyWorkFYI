package com.example.demo.dao;

import com.example.demo.entity.QRTZ_MYORDER;

public interface QRTZ_MYORDERMapper {
    int deleteByPrimaryKey(Integer recodid);

    int insert(QRTZ_MYORDER record);

    int insertSelective(QRTZ_MYORDER record);

    QRTZ_MYORDER selectByPrimaryKey(Integer recodid);

    int updateByPrimaryKeySelective(QRTZ_MYORDER record);

    int updateByPrimaryKey(QRTZ_MYORDER record);
}