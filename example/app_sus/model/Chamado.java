package com.example.app_sus.model;

import jakarta.persistence.*;
import com.example.app_sus.model.enums.StatusChamado;

import java.time.LocalDateTime;

    @Entity
    public class Chamado {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(optional = false)
        @JoinColumn(name = "usuario_id")
        private Usuario usuario;

        @ManyToOne(optional = false)
        @JoinColumn(name = "paciente_id")
        private Paciente paciente;

        @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "endereco_atendimento_id", referencedColumnName = "id", nullable = false)
        private Endereco enderecoAtendimento;

        private String sintomas;

        private String observacoesAdicionais;

        private LocalDateTime dataHoraChamado;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private StatusChamado status;

        public Chamado() {
            this.dataHoraChamado = LocalDateTime.now();
            this.status = StatusChamado.NOVO;
        }

        public Chamado(Usuario usuario, Paciente paciente, Endereco enderecoAtendimento,
                       String sintomas, String observacoesAdicionais) {
            this();
            this.usuario = usuario;
            this.paciente = paciente;
            this.enderecoAtendimento = enderecoAtendimento;
            this.sintomas = sintomas;
            this.observacoesAdicionais = observacoesAdicionais;
        }
}
