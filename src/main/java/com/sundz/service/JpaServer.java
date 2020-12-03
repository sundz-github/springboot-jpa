package com.sundz.service;

import com.sundz.jpa.entity.Job;
import com.sundz.jpa.entity.User;
import com.sundz.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2020/11/5 20:39
 */
@Service
public class JpaServer {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void save2(){
        User user = new User();
        user.setCicMail("123456@qq.com");
        user.setCicCity("ShangHai");
        //user.setDate(LocalDateTime.now());
        Job job = new Job();
        job.setType("法师");
        job.setRemark("公孙离");
        // // 一对多
        user.getJobSet().add(job);
        // 多对一
//        job.setUser(user);
        //jobRepository.save(job);
        userRepository.save(user);
    }
}
