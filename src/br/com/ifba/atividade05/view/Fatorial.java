/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade05.view;

/**
 *
 * @author edina
 */
public class Fatorial {
    private int valor;
    private int fatorial;
    private String formula;
    
    public void setValor(int n){
        valor = n;
        
        int fat = 1;
        String f = "";
        
        if (valor == 0){
            f = "0! = 1";
            fat = 1;
        } else {
            for (int i = valor; i >= 1; i--){
                fat *= i;
                f += i;
                
                if(i > 1){
                 f += "x";
                }
            }
        }
        
    f += " = ";
        
    this.fatorial = fat;
    this.formula = f;
    }
    public int getFatorial(){
        return fatorial;
    }
    
    public String getFormula(){
        return formula;
    }
}
