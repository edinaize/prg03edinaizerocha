/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade07;

public class PagamentoCartao implements Pagamento {

    public double calcularTotal(double valor) {
        return valor * 1.05;
    }

    public String imprimirRecibo(double valorOriginal, double valorFinal) {
        double taxa = valorOriginal * 0.05;

        return String.format(
            "----- PAGAMENTO CARTÃO -----\n" +
            "Valor original:   R$ %8.2f\n" +
            "Taxa 5%%:      +R$ %8.2f\n" +
            "----------------------------\n" +
            "TOTAL:            R$ %8.2f",
            valorOriginal, taxa, valorFinal
        );
    }
}