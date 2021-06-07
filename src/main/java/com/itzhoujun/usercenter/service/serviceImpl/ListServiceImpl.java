package com.itzhoujun.usercenter.service.serviceImpl;

import com.itzhoujun.usercenter.domain.entity.ListBean;
import com.itzhoujun.usercenter.dao.ListDao;
import com.itzhoujun.usercenter.service.ListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class ListServiceImpl implements ListService {

    @Autowired
    private ListDao listDao;

    @Override
    public ListBean select(int id) {
        return listDao.getInfo(id);
    }


}
