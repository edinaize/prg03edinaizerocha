/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade08;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Usuario {
    private Long id;
    private PerfilUsuario perfil;
    private String nomeUsuario;
    private String email;
    private String senha;
    private LocalDateTime ultimoLogin;
    private boolean ativo;

    private List<LogAuditoria> logs = new ArrayList<>();
    private List<Sessao> sessoes = new ArrayList<>();

    public Usuario(Long id, PerfilUsuario perfil, String nomeUsuario, String email, String senha, boolean ativo) {
        this.id = id;
        this.perfil = perfil;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public PerfilUsuario getPerfil() { return perfil; }
    public void setPerfil(PerfilUsuario perfil) { this.perfil = perfil; }

    public String getNomeUsuario() { return nomeUsuario; }
    public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public LocalDateTime getUltimoLogin() { return ultimoLogin; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    public List<LogAuditoria> getLogs() { return logs; }
    public List<Sessao> getSessoes() { return sessoes; }

    public boolean logar(String senha) {
        if (this.senha.equals(senha)) {
            this.ultimoLogin = LocalDateTime.now();
            logs.add(new LogAuditoria(1L, this, "Login realizado", "127.0.0.1"));
            return true;
        } else {
            logs.add(new LogAuditoria(2L, this, "Tentativa inválida", "127.0.0.1"));
            return false;
        }
    }

    public Sessao criarSessao() {
        String token = UUID.randomUUID().toString();
        Sessao sessao = new Sessao((long) (sessoes.size() + 1), this, token);
        sessoes.add(sessao);
        return sessao;
    }

    @Override
    public String toString() {
    return "\n--- USUÁRIO ---" +
           "\nID: " + id +
           "\nNome: " + nomeUsuario +
           "\nPerfil: " + perfil.getDescricao() +
           "\nÚltimo Login: " + ultimoLogin +
           "\nAtivo: " + ativo;
    }
}