/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.entity.Curso;
import java.util.List;
import org.springframework.stereotype.Service;
import br.com.ifba.curso.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author edina
 */

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    public List<Curso> findAll() {
        return repository.findAll();
    }

    public Curso findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Curso> findByNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public Curso save(Curso curso) {
        return repository.save(curso);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}