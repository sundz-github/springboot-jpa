package com.sundz.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p> 岗位实体 与数据库表cic_job_info进行映射 </p>
 *
 * @author Sundz
 * @date $DATE $TIME
 */
@Entity
@Table(name = "cic_job_info")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Job implements Serializable {

    private static final long serialVersionUID = 1845410474582487885L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GenericGenerator(name = "cic_job_id-uuid", strategy = "cic_job_id")
    @Column(name = "cic_job_id")
    private int id;

    @Column(name = "cic_type")
    private String type;

    @Column(name = "cic_remark")
    private String remark;

    /**
     * @field foreignKey  -->  指定外键的名称
     */
    @ManyToOne(targetEntity = User.class/*, cascade = CascadeType.ALL*/)
    @JoinColumn(name = "user_id", referencedColumnName = "cic_user_id", foreignKey = @ForeignKey(name = "fk_job_user"))
    // 建立外键关系
    private User user;


}
