package com.sundz.jpa.repository;

import com.sundz.jpa.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <p> 岗位 </p>
 *
 * @author Sundz
 * @date 2020/11/4 19:20
 */
public interface JobRepository extends JpaRepository<Job, Integer>, JpaSpecificationExecutor<Job> {

}
