/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.mso.mcmodel1;

import hust.mso.mcmodel1.Interface.IMFEA;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;


/**
 *
 * @author thang.tb153544
 */
public class MFEA implements IMFEA{
    public static Random  rand = new Random(Parameter.SEED);
    Population pop;

    public MFEA() {
        pop= new Population();
        
    }
    

    @Override
    public Chromosome[] offspring_pop() {
        int a = rand.nextInt(Parameter.SIZE_POPULATION);
        int b = rand.nextInt(Parameter.SIZE_POPULATION);
        Chromosome [] child = new Chromosome[2];;
        while(a==b){
            b = rand.nextInt(Parameter.SIZE_POPULATION);
        }
        Chromosome A = pop.popList.get(a);
        Chromosome B = pop.popList.get(b);
        double r = rand.nextDouble();
       if(A.getSkillFactor() == B.getSkillFactor() || r< Parameter.rmp){
           child = pop.crossover(A, B);
           // xet skill factor
           for(int i=0; i<2; i++){
               r = rand.nextDouble();
                if(r<0.5){
                    
                    child[i].setSkillFactor(0);
                    child[i].calFitnessTask_0();
                    child[i].setFitnessTask_1(Parameter.LARGE_NUMBER);
                }else{
                    child[i].setSkillFactor(1);
                    child[i].calFitnessTask_1();
                    child[i].setFitnessTask_0(Parameter.LARGE_NUMBER);
                }
           }
           
           return child;
           
       }else{
           child[0] = pop.mutation(A);
           child[1] = pop.mutation(B);
           // xet skill factor
           
           // con thu nhat
           child[0].setSkillFactor(A.getSkillFactor());
           if(A.getSkillFactor()==0){
               child[0].calFitnessTask_0();
               child[0].setFitnessTask_1(Parameter.LARGE_NUMBER);
           }else{
               child[0].calFitnessTask_1();
               child[0].setFitnessTask_0(Parameter.LARGE_NUMBER);
           }
           
           // con thu 2
           child[1].setSkillFactor(B.getSkillFactor());
           if(B.getSkillFactor()==0){
               child[0].calFitnessTask_0();
               child[1].setFitnessTask_1(Parameter.LARGE_NUMBER);
           }else{
               child[0].calFitnessTask_1();
               child[1].setFitnessTask_0(Parameter.LARGE_NUMBER);
           }
         
          
           
           return child;
       }
    }

    @Override
    public void run() {
        pop.Init(); // khoi tao, tinh fitness theo all task
        pop.calScalarFitness_SkillFactor(); // update scalar fitness
        int T=1;
        Population childPop;
        while(T<Parameter.CONDITION_STOP){
            childPop = new Population();
            // tao the he con & tinh Fitness Task
            while(childPop.popList.size()<Parameter.SIZE_POPULATION){
                Chromosome[] offsprings = offspring_pop();
                childPop.popList.add(offsprings[0]);
                childPop.popList.add(offsprings[1]);
            }
            //Noi quan the con vao quan the cha=> 2*SIZE
            pop.popList.addAll((Collection<? extends Chromosome>) childPop);
            pop.calScalarFitness_SkillFactor();
            pop.selection();
            System.out.println("MFEA: SIZE pop.popList.size()");                    
        }
        
    }
    
    

   
    
    
}
