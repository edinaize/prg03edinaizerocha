/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade07;

public class PagamentoDinheiro implements Pagamento {

    public double calcularTotal(double valor) {
        return valor * 0.9;
    }

    public String imprimirRecibo(double valorOriginal, double valorFinal) {
        double desconto = valorOriginal * 0.10;

        return String.format(
            "----- PAGAMENTO DINHEIRO -----\n" +
            "Valor original:   R$ %8.2f\n" +
            "Desconto 10%%: -R$%8.2f\n" +
            "------------------------------\n" +
            "TOTAL:            R$ %8.2f",
            valorOriginal, desconto, valorFinal);
    }
}
