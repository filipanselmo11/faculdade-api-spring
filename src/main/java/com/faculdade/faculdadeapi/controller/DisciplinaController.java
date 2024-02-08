package com.faculdade.faculdadeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faculdade.faculdadeapi.disciplina.DadosAtualizacaoDisciplina;
import com.faculdade.faculdadeapi.disciplina.DadosCadastroDisciplina;
import com.faculdade.faculdadeapi.disciplina.DadosListagemDisciplina;
import com.faculdade.faculdadeapi.disciplina.Disciplina;
import com.faculdade.faculdadeapi.disciplina.DisciplinaRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("disciplinas")
public class DisciplinaController {
    
    @Autowired
    private DisciplinaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroDisciplina dados) {
        repository.save(new Disciplina(dados));
    }

    @GetMapping
    public Page<DadosListagemDisciplina> listar(@PageableDefault(size=10, sort={"titulo"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemDisciplina::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoDisciplina dados) {
        var disciplina = repository.getReferenceById(dados.id());
        disciplina.atualizarInformacoes(dados);
    }
}
