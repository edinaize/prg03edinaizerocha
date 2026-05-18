/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade07;

public interface Pagamento {
    double calcularTotal(double valor);
    String imprimirRecibo(double valorOriginal, double valorFinal);
}
