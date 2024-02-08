package com.faculdade.faculdadeapi.aluno;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroAluno(
    @NotBlank
    String nome,
    @NotBlank
    String matricula,
    @NotBlank
    @Email
    String email
) {
}
