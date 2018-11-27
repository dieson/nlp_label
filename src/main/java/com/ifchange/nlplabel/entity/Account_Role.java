package com.ifchange.nlplabel.entity;

import javax.persistence.*;

@Entity
@Table(name = "account_role")
public class Account_Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long uid;
    private long role_Id;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }


    public long getRole_Id() {
        return role_Id;
    }

    public void setRole_Id(long role_Id) {
        this.role_Id = role_Id;
    }

}
