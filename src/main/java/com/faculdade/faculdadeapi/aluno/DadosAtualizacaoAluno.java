package com.faculdade.faculdadeapi.aluno;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAluno(
    @NotNull
    Long id,
    String nome,
    String matricula,
    String email
) {
}
