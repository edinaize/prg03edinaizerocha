/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade08;

import java.time.LocalDateTime;

public class LogAuditoria {
    private Long id;
    private Usuario usuario;
    private String acao;
    private LocalDateTime dataHora;
    private String ip;

    public LogAuditoria(Long id, Usuario usuario, String acao, String ip) {
        this.id = id;
        this.usuario = usuario;
        this.acao = acao;
        this.ip = ip;
        this.dataHora = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Usuario getUsuario() { return usuario; }
    public String getAcao() { return acao; }
    public LocalDateTime getDataHora() { return dataHora; }
    public String getIp() { return ip; }

    @Override
    public String toString() {
    return "\n--- LOG ---" +
           "\nUsuário: " + usuario.getNomeUsuario() +
           "\nAção: " + acao +
           "\nData/Hora: " + dataHora;
    }
}
