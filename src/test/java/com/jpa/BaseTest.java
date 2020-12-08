package com.jpa;

import com.sundz.SpringbootJpaApplication;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2020/11/3 20:31
 */
@SpringBootTest(classes = {SpringbootJpaApplication.class})
@Log4j2
@ExtendWith(SpringExtension.class)
public class BaseTest {

    @BeforeEach
    public void before() {
        log.debug("<-----------------------单元测试开始执行----------------------->");
    }

    @AfterEach
    public void after() {
        log.debug("<-----------------------单元测试执行结束----------------------->");
    }


}
