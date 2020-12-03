package com.jpa;

import com.sundz.SpringbootJpaApplication;
import com.sundz.jpa.entity.User;
import com.sundz.jpa.repository.UserRepository;
import com.sundz.service.RestTemplateSevice;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


@SpringBootTest(classes = {SpringbootJpaApplication.class})
@Log4j2
@Rollback(false)
class SpringbootDemoApplicationTests {

    @Autowired
    private RestTemplateSevice restTemplateSevice;

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void contextLoads() {
        log.info("restTemplateSevice --> "+restTemplateSevice.get());
    }

    @Test
    public void jpaSave(){
        /*String cityName = "ShangHai";
        User user =  userRepository.selectByCityName(cityName);*/
        /*User user = userRepository.findById(1).get();*/
        User user = new User();
        user.setCicCity("Wuhan");
        user.setId(3);
        user.setCicMail("136345@163.com");
        userRepository.save(user);

    }

    @Test
    //@Transactional(readOnly = true)
    public void entityManageTest(){
        Query query = entityManager.createNativeQuery("select user.cic_city from cic_user_info user");
         //query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.aliasToBean(User.class));
        List<String> list = query.getResultList();
        for (String t :list){
            System.out.println(t);
        }
    }

    @Test
    @Transactional
    public void updateTest(){
        userRepository.updateCity(1,"London");
    }

    @Test
    public void findByName(){
        User user = userRepository.findByCicCityLikeAndId("London%", 3);
        System.out.println(user);

    }

    @Test
    public void specificationTest(){
        Specification<User> spec = new Specification<User>() {
            private static final long serialVersionUID = -5309476661010601771L;

            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Object> cityPath = root.get("cicCity");
                Path<Object> idPath = root.get("id");
                Predicate pre1 = cb.equal(cityPath, "London");
                Predicate pre2 = cb.equal(idPath,3);
                Predicate and = cb.and(pre1, pre2);
                return and;
            }
        };
        // 此处需要注意optional可能为null
        User one = userRepository.findOne(spec).orElse(new User());
        System.out.println(one);
    }


    @Test
    public void likeTest(){
        Specification<User> spec = ((root,query, criteriaBuilder) -> {
            Path<Object> path = root.get("cicCity");
            return criteriaBuilder.like(path.as(String.class),"London%");
        });
        List<User> all = userRepository.findAll(spec);
        for (User user : all) {
            System.out.println(user);
        }

    }

}
