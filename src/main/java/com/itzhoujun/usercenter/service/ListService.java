package com.itzhoujun.usercenter.service;

import com.itzhoujun.usercenter.domain.entity.ListBean;
import org.springframework.stereotype.Component;

@Component
public interface ListService {

    ListBean select(int id);


}
