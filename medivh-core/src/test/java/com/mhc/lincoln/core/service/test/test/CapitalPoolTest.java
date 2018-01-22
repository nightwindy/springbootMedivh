package com.mhc.lincoln.core.service.test.test;

import com.windy.medivh.core.MedivhApplication;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MedivhApplication.class)
@ActiveProfiles("dev")
public class CapitalPoolTest {


   /* @Autowired
    private IDebtCessionAO debtCessionAO;

    @Test
    public void paymentCapitalPool(){
        // 还款时资金变动
        debtCessionAO.updateCapitalPoolAmount("G20170807107551");
    }*/
}
