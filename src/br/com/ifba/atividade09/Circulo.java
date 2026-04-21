/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09;

public class Circulo extends FormaBidimensional {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double obterArea() {
        return Math.PI * raio * raio;
    }

    @Override
    public String toString() {
        return "Raio do círculo: " + raio;
    }
}
