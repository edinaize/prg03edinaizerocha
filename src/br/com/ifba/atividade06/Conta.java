/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade06;

public class Conta {
    public static void main(String[] args){
    ContaBanco p1 = new ContaBanco();
    p1.setNumConta(1111);
    p1.setDono ("Jubileu");
    p1.abrirConta("CC");
    
    ContaBanco p2 = new ContaBanco();
    p2.setNumConta(2222);
    p2.setDono("Creuza");
    p2.abrirConta("CP");
    
    p1.estadoAtual();
    p2.estadoAtual();
    }
}
