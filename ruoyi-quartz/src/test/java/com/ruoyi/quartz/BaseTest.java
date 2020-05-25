package com.ruoyi.quartz;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author maxf
 * @version 1.0
 * @ClassName BaseTest
 * @Description
 * @date 2018/12/13 11:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class BaseTest {

    public static String testId = "99999999999999999999999999999999";
    public static Long longTestId = 123456L;

}
