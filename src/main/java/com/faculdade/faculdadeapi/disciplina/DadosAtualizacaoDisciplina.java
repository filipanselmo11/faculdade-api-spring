package com.faculdade.faculdadeapi.disciplina;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoDisciplina(
    @NotNull
    Long id,
    String titulo,
    String codigo,
    Integer turmas
) {
    
}
