package com.jpa;

import com.sundz.jpa.entity.Job;
import com.sundz.jpa.entity.User;
import com.sundz.jpa.repository.JobRepository;
import com.sundz.jpa.repository.UserRepository;
import com.sundz.service.JpaServer;
import org.junit.Test;
import org.mockito.internal.util.collections.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2020/11/4 19:41
 */

@Rollback(false)
@Transactional
public class JpaSaveTest extends BaseTest{

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JpaServer jpaServer;

    /**
     * @field 级联+需要在一方和多方都建立外键
     */
    @Test
    public void save1(){
        User user = new User();
        user.setCicMail("123456@qq.com");
        user.setCicCity("ShangHai");
        //user.setDate(LocalDateTime.now());
        Job job = new Job();
        job.setId(1);
        job.setType("法师");
        job.setRemark("公孙离");
        // 多对一
//        job.setUser(user);
        //  一对多
        user.getJobSet().add(job);
        //jobRepository.save(job);
        userRepository.save(user);
    }

    /**
     * @field cascade:级联操作
     */
    @Test
    public void save2(){

        User user = new User();
        user.setCicMail("123456@qq.com");
        user.setCicCity("ShangHai");
        //user.setDate(LocalDateTime.now());
        Job job = new Job();
        job.setType("法师");
        job.setRemark("公孙离");
        Set<Job> jobSet = Sets.newSet(job);
        //  一对多
        user.setJobSet(jobSet);
        // 多对一
        //job.setUser(user);

        //jobRepository.save(job);
        userRepository.save(user);
    }

    @Test
    public void save3(){
        String t = "<H1>派拉软件必胜,中国必胜</h1>";
        jpaServer.save2();
    }

}
