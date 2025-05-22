package model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;

import java.time.LocalDateTime;

@Entity
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "endereco_atendimento_id", referencedColumnName = "id", nullable = false)
    private Endereco enderecoAtendimento;

    private String sintomas;
    private String observacoesAdicionais;

    private LocalDateTime dataHoraChamado;

    private String status;

    public Chamado() {
        this.dataHoraChamado = LocalDateTime.now();
        this.status = "NOVO";
    }

    public Chamado(Usuario usuario, Endereco enderecoAtendimento, String sintomas, String observacoesAdicionais) {
        this();
        this.usuario = usuario;
        this.enderecoAtendimento = enderecoAtendimento;
        this.sintomas = sintomas;
        this.observacoesAdicionais = observacoesAdicionais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Endereco getEnderecoAtendimento() {
        return enderecoAtendimento;
    }

    public void setEnderecoAtendimento(Endereco enderecoAtendimento) {
        this.enderecoAtendimento = enderecoAtendimento;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getObservacoesAdicionais() {
        return observacoesAdicionais;
    }

    public void setObservacoesAdicionais(String observacoesAdicionais) {
        this.observacoesAdicionais = observacoesAdicionais;
    }

    public LocalDateTime getDataHoraChamado() {
        return dataHoraChamado;
    }

    public void setDataHoraChamado(LocalDateTime dataHoraChamado) {
        this.dataHoraChamado = dataHoraChamado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}