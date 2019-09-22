/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.mso.mcmodel1.Interface;

import hust.mso.mcmodel1.Chromosome;
import java.util.ArrayList;

/**
 *
 * @author thang.tb153544
 */
public interface IPopulation {
    public void Init();
     public Chromosome[] crossover(Chromosome A, Chromosome B);
    public Chromosome mutation(Chromosome A);
    public void calScalarFitness_SkillFactor();
    public void selection();
    
    
}
