package com.ifchange.nlplabel.entity;


import javax.persistence.*;

@Entity
@Table(name = "permission_role")
public class Permission_Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long role_Id;
    private long permission_Id;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getRole_Id() {
        return role_Id;
    }

    public void setRole_Id(long role_Id) {
        this.role_Id = role_Id;
    }


    public long getPermission_Id() {
        return permission_Id;
    }

    public void setPermission_Id(long permission_Id) {
        this.permission_Id = permission_Id;
    }

}
