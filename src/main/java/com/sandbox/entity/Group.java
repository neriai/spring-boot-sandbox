package com.sandbox.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="groups")
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    @Getter
    @Setter
    private Integer groupId;
   
    @Column(name="name", nullable=false)
    @Getter
    @Setter
    public String groupName;
    
    public Integer getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupId(final Integer groupId) {
        this.groupId = groupId;
    }

    public void setGroupName(final String groupName) {
        this.groupName = groupName;
    }
}