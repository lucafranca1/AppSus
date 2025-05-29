package com.example.app_sus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import com.example.app_sus.model.enums.TipoDeDeficiencia;

import java.time.LocalDate;

@Entity
public class Paciente extends Pessoa {

    @NotNull(message= "É necessário informar se o paciente possui deficiência")
    private boolean possuiDeficiencia;

    @Enumerated(EnumType.STRING)
    private TipoDeDeficiencia tipoDeDeficiencia;

    private String observacoesDeficiencia;

    public Paciente() {
        super();
    }

    public Paciente(String nome, String cpf, LocalDate dataDeNascimento, String telefoneContato, String emailContato,
                    Endereco endereco, boolean possuiDeficiencia, TipoDeDeficiencia tipoDeDeficiencia, String observacoesDeficiencia) {
        super(nome, cpf, dataDeNascimento, telefoneContato, emailContato, endereco);
        this.possuiDeficiencia = possuiDeficiencia;
        this.tipoDeDeficiencia = tipoDeDeficiencia;
        this.observacoesDeficiencia = observacoesDeficiencia;
    }

    public boolean getPossuiDeficiencia() {
        return possuiDeficiencia;
    }

    public void setPossuiDeficiencia(boolean possuiDeficiencia) {
        this.possuiDeficiencia = possuiDeficiencia;
    }

    public TipoDeDeficiencia getTipoDeficiencia() {
        return tipoDeDeficiencia;
    }

    public void setTipoDeficiencia(TipoDeDeficiencia tipoDeDeficiencia) {
        this.tipoDeDeficiencia = tipoDeDeficiencia;
    }

    public String getObservacoesDeficiencia() {
        return observacoesDeficiencia;
    }

    public void setObservacoesDeficiencia(String observacoesDeficiencia) {
        this.observacoesDeficiencia = observacoesDeficiencia;
    }
}
