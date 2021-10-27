/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.heracliontravelassistant.model;

/**
 *
 * @author ioann
 */
public class Point {

    private String name;
    private String type;
    private double x;
    private double y;
    private String address;
    private String phone;
    private String site;
    private String hours;
    private String info;
    private String img;

    public Point() {
        this.name = "";
        this.type = "";
        this.x = 0.0;
        this.y = 0.0;
    }

    public Point(String name,
            String type,
            double x,
            double y,
            String address,
            String phone,
            String site,
            String hours,
            String info,
            String img) {

        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
        this.address = address;
        this.phone = phone;
        this.site = site;
        this.hours = hours;
        this.info = info;
        this.img = img;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddres(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getSite() {
        return this.site;
    }

    public void setSite(String site) {
        this.site = site;
    }
    public String getHours() {
        return this.hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Point Name: ").append(name).append("\n")
                .append("Point type: ").append(type).append("\n")
                .append("X coord: ").append(x).append("\n")
                .append("Y coord: ").append(y).append("\n")
                .append("Address :").append(address).append("\n")
                .append("Phone :").append(phone).append("\n")
                .append("Site :").append(site).append("\n")
                .append("Hours").append(hours).append("\n")
                .append("Info :").append(info).append("\n")
                .append("Img :").append(img).append("\n");
        return sb.toString();

    }
}
