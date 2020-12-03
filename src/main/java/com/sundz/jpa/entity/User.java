package com.sundz.jpa.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * <p> User实体 与数据库表cic_user_info进行映射 </p>
 * @author Sundz
 * @date $DATE $TIME
 */
@Entity
@Table(name = "cic_user_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -1615232151667465127L;
    /**
     * @field 主键及生成策略
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cic_user_id")
    private int id;

    @Column(name = "cic_city")
    private String cicCity;

    @Column(name = "cic_mail")
    private String cicMail;

    @Column(name = "cic_createtime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    // 放弃外键 参考多方的user属性
    @OneToMany(targetEntity =Job.class , /*mappedBy = "user",*/cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Set<Job> jobSet = new HashSet<>();


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", cicCity='" + cicCity + '\'' +
                ", cicMail='" + cicMail + '\'' +
                ", date=" + date +
                '}';
    }
}
