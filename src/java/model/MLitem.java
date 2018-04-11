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
public class MLitem {

    private String id;
    private String iname;
    private MLcustomer cid;
    private double weight;

    public MLitem() {
    }

    public MLitem(String id, String iname, MLcustomer cid, double weight) {
        this.id = id;
        this.iname = iname;
        this.cid = cid;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public MLcustomer getCid() {
        return cid;
    }

    public void setCid(MLcustomer cid) {
        this.cid = cid;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    
}
