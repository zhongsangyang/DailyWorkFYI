package com.example.demo.service.impl;

import com.example.demo.dao.QRTZ_MYORDERMapper;
import com.example.demo.dataSource.DataSource;
import com.example.demo.entity.QRTZ_MYORDER;
import com.example.demo.service.QRTZ_MYORDERservice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class QRTZ_MYORDERserviceImpl implements QRTZ_MYORDERservice {
    @Resource
    private QRTZ_MYORDERMapper qrtz_myorderMapper;
    @Override
    @DataSource("testData")
    public int insert(QRTZ_MYORDER record) {
        return qrtz_myorderMapper.insert(record);
    }
}
