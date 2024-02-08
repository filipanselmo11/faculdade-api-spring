package com.faculdade.faculdadeapi.aluno;

public record DadosListagemAluno(Long id, String nome, String matricula, String email) {
    public DadosListagemAluno(Aluno aluno) {
        this(aluno.getId(), aluno.getNome(), aluno.getMatricula(), aluno.getEmail());
    }
    
}
