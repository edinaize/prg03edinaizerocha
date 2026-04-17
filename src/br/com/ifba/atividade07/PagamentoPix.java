/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade07;

public class PagamentoPix implements Pagamento {

    public double calcularTotal(double valor) {
        return valor * 0.98;
    }

    public String imprimirRecibo(double valorOriginal, double valorFinal) {
        double cashback = valorOriginal * 0.02;

        return String.format(
            "----- PAGAMENTO PIX ------\n" +
            "Valor original:   R$ %8.2f\n" +
            "Cashback 2%%:  -R$ %8.2f\n" +
            "-------------------------------\n" +
            "TOTAL:            R$ %8.2f",
            valorOriginal, cashback, valorFinal);
    }
}