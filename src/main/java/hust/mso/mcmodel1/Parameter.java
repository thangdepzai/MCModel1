/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.mso.mcmodel1;

/**
 *
 * @author thang.tb153544
 */
public class Parameter {
    public static  int id =0;
    public static  int SIZE_POPULATION = 100;
    public static  int  SIZE_SENSORS = 20;
    public static  double E_MAX = 10800;
    public static  double E_MIN = 540;
    public static double U = 5;
    public static double V = 5;
    public static double P = 1;
    public static int SEED = 1;
    public static double rmp = 0.5;
    public static double rm = 0.1;
     public static double LARGE_NUMBER = 1000000000;
     public static int CONDITION_STOP = 100;
    public Parameter() {
    }

    public static int getSIZE_POPULATION() {
        return SIZE_POPULATION;
    }

    public static void setSIZE_POPULATION(int SIZE_POPULATION) {
        Parameter.SIZE_POPULATION = SIZE_POPULATION;
    }

    public static int getSIZE_SENSORS() {
        return SIZE_SENSORS;
    }

    public static void setSIZE_SENSORS(int SIZE_SENSORS) {
        Parameter.SIZE_SENSORS = SIZE_SENSORS;
    }

    public static double getE_MAX() {
        return E_MAX;
    }

    public static void setE_MAX(double E_MAX) {
        Parameter.E_MAX = E_MAX;
    }

    public static double getE_MIN() {
        return E_MIN;
    }

    public static void setE_MIN(double E_MIN) {
        Parameter.E_MIN = E_MIN;
    }

    public static double getU() {
        return U;
    }

    public static void setU(double U) {
        Parameter.U = U;
    }

    public static double getV() {
        return V;
    }

    public static void setV(double V) {
        Parameter.V = V;
    }

    public static double getP() {
        return P;
    }

    public static void setP(double P) {
        Parameter.P = P;
    }
    

   
    
    
    
    
}
