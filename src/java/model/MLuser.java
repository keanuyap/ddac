/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author th3-k
 */
public class MLuser {
    private String id;
    private String password;
    private String fname;
    private String lname;
    private String position;
    private String gender;
    private String status;

    public MLuser(String id, String password, String fname, String lname, String position, String gender, String status) {
        this.id = id;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.position = position;
        this.gender = gender;
        this.status = status;
    }

    public MLuser() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
