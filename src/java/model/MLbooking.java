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
public class MLbooking {

    private String id;
    private MLschedule scid;
    private MLitem iid;
    private MLuser uid;
    private String status;

    public MLbooking(String id, MLschedule scid, MLitem iid, MLuser uid, String status) {
        this.id = id;
        this.scid = scid;
        this.iid = iid;
        this.uid = uid;
        this.status = status;
    }

    public MLbooking() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MLschedule getScid() {
        return scid;
    }

    public void setScid(MLschedule scid) {
        this.scid = scid;
    }

    public MLitem getIid() {
        return iid;
    }

    public void setIid(MLitem iid) {
        this.iid = iid;
    }

    public MLuser getUid() {
        return uid;
    }

    public void setUid(MLuser uid) {
        this.uid = uid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    

}
