package com.ifchange.nlplabel.entity;


import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long tid;
  private String tname;
  private String type;
  private String create_Account;
  private java.sql.Timestamp create_Time;
  private String last_Edit_Account;
  private java.sql.Timestamp last_Edit_Time;
  private String service_Address;
  private String service_Port;


  public long getTid() {
    return tid;
  }

  public void setTid(long tid) {
    this.tid = tid;
  }


  public String getTname() {
    return tname;
  }

  public void setTname(String tname) {
    this.tname = tname;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getCreate_Account() {
    return create_Account;
  }

  public void setCreate_Account(String create_Account) {
    this.create_Account = create_Account;
  }


  public java.sql.Timestamp getCreate_Time() {
    return create_Time;
  }

  public void setCreate_Time(java.sql.Timestamp create_Time) {
    this.create_Time = create_Time;
  }


  public String getLast_Edit_Account() {
    return last_Edit_Account;
  }

  public void setLast_Edit_Account(String last_Edit_Account) {
    this.last_Edit_Account = last_Edit_Account;
  }


  public java.sql.Timestamp getLast_Edit_Time() {
    return last_Edit_Time;
  }

  public void setLast_Edit_Time(java.sql.Timestamp last_Edit_Time) {
    this.last_Edit_Time = last_Edit_Time;
  }


  public String getService_Address() {
    return service_Address;
  }

  public void setService_Address(String service_Address) {
    this.service_Address = service_Address;
  }


  public String getService_Port() {
    return service_Port;
  }

  public void setService_Port(String service_Port) {
    this.service_Port = service_Port;
  }

}
