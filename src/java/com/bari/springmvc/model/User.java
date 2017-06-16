package com.bari.springmvc.model;

public class User  implements java.io.Serializable {


     private Integer id;
     private String email;
     private String name;
     private String pass;
     private String regdate;

    public User() {
    }

    public User(String email, String name, String pass, String regdate) {
       this.email = email;
       this.name = name;
       this.pass = pass;
       this.regdate = regdate;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getPass() {
        return this.pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getRegdate() {
        return this.regdate;
    }
    
    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }




}


