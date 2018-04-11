/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author th3-k
 */
public class MLschedule {

    private String id;
    private String DDate;
    private String ADate;
    private MLship sid;
    private double acapacity;
    private String departure;
    private String arrival;
    private String status;

    public MLschedule() {
    }

    public MLschedule(String id, String DDate, String ADate, MLship sid, double acapacity, String departure, String arrival, String status) {
        this.id = id;
        this.DDate = DDate;
        this.ADate = ADate;
        this.sid = sid;
        this.acapacity = acapacity;
        this.departure = departure;
        this.arrival = arrival;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDDate() {
        return DDate;
    }

    public void setDDate(String DDate) {
        this.DDate = DDate;
    }

    public String getADate() {
        return ADate;
    }

    public void setADate(String ADate) {
        this.ADate = ADate;
    }

    public String getShipid() {
        return sid.getId();
    }

    public MLship getSid() {
        return sid;
    }

    public void setSid(MLship sid) {
        this.sid = sid;
    }

    public double getAcapacity() {
        return acapacity;
    }

    public void setAcapacity(double acapacity) {
        this.acapacity = acapacity;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
