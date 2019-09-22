package hust.mso.mcmodel1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thang.tb153544
 */
public class Sensor {
    double x;
    double y;
    double p;
    double e;

    public Sensor(double x, double y, double p, double e) {
        this.x = x;
        this.y = y;
        this.p = p;
        this.e = e;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public double getE() {
        return e;
    }

    public void setE(double e) {
        this.e = e;
    }
    
    
}
