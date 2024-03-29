package com.faculdade.faculdadeapi.aluno;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "alunos")
@Entity(name = "Aluno")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String matricula;
    private String email;
    // private Boolean ativo;

    public Aluno(DadosCadastroAluno dados) {
        this.nome = dados.nome();
        this.matricula = dados.matricula();
        this.email = dados.email();
    }

    public void atualizarInformacoes(DadosAtualizacaoAluno dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if (dados.matricula() != null) {
            this.matricula = dados.matricula();
        }

        if (dados.email() != null) {
            this.email = dados.email();
        }
    }

}
