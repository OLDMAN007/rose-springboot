package com.freedom.rose.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data   //lombok插件，简化get，set方法
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)  //自动完成创建时间和修改时间的生成
public class User implements Serializable {

    @Id
    @GeneratedValue //主键生成策略，默认为AUTO
    private Long id;
    @Column(length = 120, nullable = false, unique = true)
    private String code;
    @Column(length = 120, nullable = false, unique = true)
    private String name;
    @Column(length = 36, nullable = false)
    private String password;
    @Column(length = 10)
    private String gender;
    @Column(length = 20)
    private String phone;
    @Column(length = 50)
    private String email;
    @Column(length = 36, nullable = false)
    private String userGroup;
    @Column(length = 36, nullable = false)
    private Long orgID;
    @Column(name = "头像")
    private String avatar;
    @Column(length = 15, nullable = false)
    private String secLevel;
    @CreatedDate
    private Date createdTime;
    @LastModifiedDate
    private Date lastModifiedTime;
    @Column(nullable = false)
    private int status;//-1：逻辑删除，0：停用，1：启用，2：异常

}
