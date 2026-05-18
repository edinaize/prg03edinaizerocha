/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09;

public class Main {
    public static void main(String[] args) {

        Forma[] formas = new Forma[6];

        formas[0] = new Circulo(3);
        formas[1] = new Quadrado(4);
        formas[2] = new Triangulo(5, 2);
        formas[3] = new Esfera(3);
        formas[4] = new Cubo(2);
        formas[5] = new Piramide(4, 6);

        for (Forma f : formas) {
            System.out.println(f);

            if (f instanceof FormaBidimensional) {
                FormaBidimensional fb = (FormaBidimensional) f;
                System.out.println("Área: " + fb.obterArea());
            } else if (f instanceof FormaTridimensional) {
                FormaTridimensional ft = (FormaTridimensional) f;
                System.out.println("Área: " + ft.obterArea());
                System.out.println("Volume: " + ft.obterVolume());
            }

            System.out.println("-------------------");
        }
    }
}
