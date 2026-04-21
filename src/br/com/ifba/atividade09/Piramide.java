/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09;

public class Piramide extends FormaTridimensional {
    private double base;
    private double altura;

    public Piramide(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double obterArea() {
        double areaBase = base * base;
        double areaLateral = 2 * base * Math.sqrt((base/2)*(base/2) + altura*altura);
        return areaBase + areaLateral;
    }

    @Override
    public double obterVolume() {
        return (base * base * altura) / 3;
    }

    @Override
    public String toString() {
        return "Base da pirâmide: " + base + ", Altura: " + altura;
    }
}
