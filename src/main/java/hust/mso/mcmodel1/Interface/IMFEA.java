/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.mso.mcmodel1.Interface;

import hust.mso.mcmodel1.Chromosome;

/**
 *
 * @author thang.tb153544
 */
public interface IMFEA {
    public Chromosome[] offspring_pop();
    public void run();
}
