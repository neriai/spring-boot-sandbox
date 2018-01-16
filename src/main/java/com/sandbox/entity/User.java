package com.sandbox.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
@IdClass(value=User.class)
public class User implements Serializable {
   
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    @Getter
    @Setter
    private Integer userId;
    
    @Column(name="group_id", nullable=false)
    @Getter
    @Setter
    private Integer groupId;
   
    @Column(name="name", nullable=false)
    @Getter
    @Setter
    private String userName;
    
    @Getter
    @Setter
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(nullable=false, insertable=false, updatable=false, name="group_id")
    private Group group;
    
    public Integer getUserId() {
        return this.userId;
    }
    
    public Integer getGroupId() {
        return this.groupId;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public Group getGroup() {
        return this.group;
    }

    public void setUserId(final Integer userId) {
        this.userId = userId;
    }
    
    public void setGroupId(final Integer groupId) {
        this.groupId = groupId;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }
    
    public void setGroup(final Group group) {
        this.group = group;
    }
}