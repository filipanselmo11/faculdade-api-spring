package com.faculdade.faculdadeapi.disciplina;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "disciplinas")
@Entity(name = "Disciplina")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Disciplina {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String codigo;
    private Integer turmas;

    public Disciplina(DadosCadastroDisciplina dados) {
        this.titulo = dados.titulo();
        this.codigo = dados.codigo();
        this.turmas = dados.turmas();
    }

    public void atualizarInformacoes(DadosAtualizacaoDisciplina dados){
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }

        if (dados.codigo() != null) {
            this.codigo = dados.codigo();
        }

        if (dados.turmas() != null) {
            this.turmas = dados.turmas();
        }
    }
}
