/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author edina
 */
@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService service;

    public List<Curso> findAll() {
        return service.findAll();
    }

    public Curso findById(Long id) {
        return service.findById(id);
    }

    public List<Curso> findByNome(String nome) {
        return service.findByNome(nome);
    }

    public Curso save(Curso curso) {
        return service.save(curso);
    }

    public void delete(Long id) {
        service.delete(id);
    }
}
