package com.faculdade.faculdadeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroAluno dados) {
        repository.save(new Aluno(dados));
    }

    @GetMapping
    public Page<DadosListagemAluno> listar(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemAluno::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoAluno dados) {
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizarInformacoes(dados);
    }

    // @DeleteMapping("/{id}")
    // @Transactional
    // public void excluir(@PathVariable Long id) {
    //     repository.deleteById(id);
    // }
}   
