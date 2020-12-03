package com.sundz.jpa.repository;

import com.sundz.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * <p> 用户 </p>
 *
 * @author Sundz
 * @date 2020/11/4 19:20
 */
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    /**
     * @nativeQuery 指定sql是否为本地查询，否则为jpql查询表名则为对应的实体
     */
    @Query(value = "select * from cic_user_info user where user.cic_city = :city", nativeQuery = true)
    User selectByCityName(@Param("city") String cicCity);

    /**
     * delete或update操作都需要加@Modifying且开启事务，否则会报错
     *
     * @param id
     * @param cicy
     * @return void
     */
    @Modifying
    @Query(value = "update User u set u.cicCity = ?2 where u.id = ?1")
    void updateCity(int id, String cicy);

    User findByCicCityLikeAndId(String cicy, int id);

}
