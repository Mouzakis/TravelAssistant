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
public class SimplePoint {
    private String name;
    private String type;
    private double x;
    private double y;

    public SimplePoint() {
        this.name = "";
        this.type = "";
        this.x = 0.0;
        this.y = 0.0;
    }

    public SimplePoint(String name,
            String type,
            double x,
            double y) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Point Name: ").append(name).append("\n")
                .append("Point type: ").append(type).append("\n")
                .append("X coord: ").append(x).append("\n")
                .append("Y coord: ").append(y).append("\n");
        return sb.toString();

    }
}
