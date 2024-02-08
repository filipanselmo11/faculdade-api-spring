package com.faculdade.faculdadeapi.disciplina;

import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroDisciplina(
    @NotBlank
    String titulo,
    @NotBlank
    String codigo,
    @NotNull
    Integer turmas
) {
    
}
