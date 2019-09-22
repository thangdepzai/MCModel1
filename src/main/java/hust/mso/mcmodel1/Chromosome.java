/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.mso.mcmodel1;

import hust.mso.mcmodel1.Interface.IChromosome;
import java.util.Comparator;

/**
 *
 * @author thang.tb153544
 */
public class Chromosome implements IChromosome, Comparable<Chromosome>, Cloneable{
    public int id;

    public Chromosome() {
        id = Parameter.id;
        Parameter.id++;
    }
    public int skillFactor; // xem ca the gan voi task nao hon
    public double scalarFitness; // 1/minRank
    Double[] fitness = new Double[2]; // ham fitness theo 2 task

    public int getSkillFactor() {
        return skillFactor;
    }

    public void setSkillFactor(int skillFactor) {
        this.skillFactor = skillFactor;
    }

    public double getScalarFitness() {
        return scalarFitness;
    }

    public void setScalarFitness(double scalarFitness) {
        this.scalarFitness = scalarFitness;
    }
    
    public double getFitnessTask_0(){
        return fitness[0];
    }
     public double getFitnessTask_1(){
        return fitness[1];
    }
     public void setFitnessTask_0(double a){
        fitness[0] =a;
    }
     public void setFitnessTask_1(double a){
        fitness[1] =a;
    }

    @Override
    public void init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void calFitnessTask_0() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void calFitnessTask_1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Chromosome o) {
        if(scalarFitness < o.getScalarFitness()) return -1;
        else if (scalarFitness > o.getScalarFitness()) return 1;
        return 0;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
     Chromosome tmp= (Chromosome) super.clone();
      tmp.setSkillFactor(skillFactor);
      tmp.setScalarFitness(scalarFitness);
      tmp.setFitnessTask_0(fitness[0]);
      tmp.setFitnessTask_1(fitness[1]);
      tmp.id = id;
      return tmp;
   } 
   

  
    
    
    
    
    
}
class CompareFitness1 implements Comparator<Chromosome> {

    @Override
    public int compare(Chromosome o1, Chromosome o2) {
        if(o1.getFitnessTask_1() < o2.getFitnessTask_1()) return -1;
        else if(o1.getFitnessTask_1() > o2.getFitnessTask_1()) return 1;
        else return 0;
    }
}
class CompareFitness0 implements Comparator<Chromosome> {

    @Override
    public int compare(Chromosome o1, Chromosome o2) {
        if(o1.getFitnessTask_0() < o2.getFitnessTask_0()) return -1;
        else if(o1.getFitnessTask_0() > o2.getFitnessTask_0()) return 1;
        else return 0;
    }
    
}
