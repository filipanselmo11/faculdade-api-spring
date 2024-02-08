package com.faculdade.faculdadeapi.disciplina;

public record DadosListagemDisciplina(Long id, String titulo, String codigo, Integer turmas) {
    public DadosListagemDisciplina(Disciplina disciplina) {
        this(disciplina.getId(), disciplina.getTitulo(), disciplina.getCodigo(), disciplina.getTurmas());
    }
}
