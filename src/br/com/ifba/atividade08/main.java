/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade08;

import br.com.ifba.atividade08.*;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {

        PerfilUsuario admin = new PerfilUsuario(
                1L,
                "Administrador",
                Arrays.asList("CRUD", "RELATORIO")
        );

        Usuario user = new Usuario(1L, admin, "Lisa", "lloud@email.com", "12345", true);

        user.logar("12345");

        Sessao sessao = user.criarSessao();

        System.out.println(user);
        System.out.println(sessao);

        user.getLogs().forEach(System.out::println);
    }
}
