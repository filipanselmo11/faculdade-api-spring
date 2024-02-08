package com.faculdade.faculdadeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faculdade.faculdadeapi.aluno.AlunoRepository;
import com.faculdade.faculdadeapi.aluno.DadosCadastroAluno;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import com.faculdade.faculdadeapi.aluno.*;

@RestController
@RequestMapping("alunos")
public class AlunController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroAluno dados) {
        repository.save(new Aluno(dados));
    }
}
