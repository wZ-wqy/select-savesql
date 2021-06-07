package com.zhoujun.userzhoujun;

import com.itzhoujun.usercenter.domain.entity.ListBean;
import com.itzhoujun.usercenter.service.ListService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class UserZhoujunApplicationTests {

        @Autowired
        ListService listservice;

        @Test
        public void contextLoads() {
            ListBean listBean = listservice.select(54);
            System.out.println("该用户ID为：");
            System.out.println(listBean.getId());
        }


}
