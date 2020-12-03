package com.jpa;

import com.sundz.SpringbootJpaApplication;
import lombok.extern.log4j.Log4j2;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2020/11/3 20:31
 */
@SpringBootTest(classes = {SpringbootJpaApplication.class})
@Log4j2
@RunWith(SpringRunner.class)
public class BaseTest {

    @Before
    public void before() {
        log.debug("<-----------------------单元测试开始执行----------------------->");
    }

    @After
    public void after() {
        log.debug("<-----------------------单元测试执行结束----------------------->");
    }


}
