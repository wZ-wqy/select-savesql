package com.itzhoujun.usercenter.dao;


import com.itzhoujun.usercenter.domain.entity.ListBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface  ListDao {

    ListBean getInfo(int id);
}
