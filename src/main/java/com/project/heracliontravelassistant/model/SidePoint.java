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
public class SidePoint {

    private String name;
    private String type;
    private double x;
    private double y;
    private String address;
    private String img;

    public SidePoint(String name, String type, double x, double y, String address, String img) {

        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
        this.address = address;
        this.img = img;

    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return type;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public String getAddress() {
        return this.address;
    }

    public String getImg() {
        return this.img;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Point Name: ").append(name).append("\n")
                .append("Point type: ").append(type).append("\n")
                .append("X coord: ").append(x).append("\n")
                .append("Y coord: ").append(y).append("\n")
                .append("Address :").append(address).append("\n");
        return sb.toString();

    }
}
