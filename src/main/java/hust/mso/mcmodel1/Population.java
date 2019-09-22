/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.mso.mcmodel1;

import hust.mso.mcmodel1.Interface.IPopulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thang.tb153544
 */
public class Population  implements IPopulation{
    public ArrayList<Chromosome> popList;
    int[] rank0 = new int[Parameter.SIZE_POPULATION*2+1];
    int[] rank1 = new int[Parameter.SIZE_POPULATION*2+1];
     ArrayList<Chromosome> temp_pop;
    

    @Override
    public void Init() {
        for(int i=0; i< Parameter.SIZE_POPULATION; i++){
            Chromosome a = new Chromosome();
            a.init();
            a.calFitnessTask_0();
            a.calFitnessTask_1();    
            popList.add(a);
        }
    }

    @Override
    public Chromosome[] crossover(Chromosome A, Chromosome B) {
       Chromosome[] child = new Chromosome[2];
       // TODO
       return child;
    }

    @Override
    public Chromosome mutation(Chromosome A) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void calScalarFitness_SkillFactor() {
        temp_pop = new ArrayList<>();
        for(int i=0; i<popList.size(); i++){
            try {
                temp_pop.add((Chromosome) popList.get(i).clone());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Population.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CompareFitness0 c0= new CompareFitness0();
        Collections.sort(temp_pop, c0);
        for(int i=0; i<popList.size(); i++){
            for(int j=0; j<temp_pop.size(); j++){
                if(temp_pop.get(j).id == popList.get(i).id){
                    rank0[i]=j+1;
                    break;
                }
            }
        }
        
        CompareFitness1 c1= new CompareFitness1();
        Collections.sort(popList, c1); 
         for(int i=0; i<popList.size(); i++){
            for(int j=0; j<temp_pop.size(); j++){
                if(temp_pop.get(j).id == popList.get(i).id){
                    rank1[i]=j+1;
                    break;
                }
            }
        }
         for(int i=0;i<popList.size(); i++){
             if(rank0[i]>rank1[i]) {
                 popList.get(i).setSkillFactor(1);
                 popList.get(i).setScalarFitness(1/rank1[i]);
             }else{
                 popList.get(i).setSkillFactor(0);
                 popList.get(i).setScalarFitness(1/rank0[i]);
             }
         }
         temp_pop = null;
    }

    @Override
    public void selection() {
        ArrayList<Chromosome> new_pop = new ArrayList<>();
        Collections.sort(popList);
        ArrayList<Boolean> bucket = new ArrayList<Boolean>(Parameter.id);
        for(int i=0;i<popList.size(); i++){
            if(new_pop.size()>=Parameter.SIZE_POPULATION){
                break;
            }
            if(bucket.get(popList.get(i).id)==false ){
                bucket.set(popList.get(i).id, true);
                new_pop.add(popList.get(i));   
            }
        }
        popList = new_pop;
        new_pop=null;   
    }
}

  
    
   
