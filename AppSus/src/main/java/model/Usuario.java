package model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Usuario extends Pessoa {

	@Column(unique = true, nullable = false)
	private String username;

	@Column(nullable = false)
	private String senha;

	private String papel; // Ex: "ADMIN", "MEDICO", "AUXILIAR", "PACIENTE"

	private boolean possuiDeficiencia;

	@Enumerated(EnumType.STRING)
	private TipoDeficiencia tipoDeficiencia;

	private String observacoesDeficiencia;

	private boolean ativo;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chamado> chamados = new ArrayList<>();

	public Usuario() {
		super();
		this.possuiDeficiencia = false;
		this.ativo = true;
	}

	public Usuario(String nome, String cpf, LocalDate dataDeNascimento, Endereco endereco, String telefoneContato, String emailContato, String crm, String especialidade) {
		super(nome, cpf, dataDeNascimento, telefoneContato, emailContato, endereco);
		this.username = username;
		this.senha = senha;
		this.papel = papel;
		this.possuiDeficiencia = possuiDeficiencia;
		this.tipoDeficiencia = tipoDeficiencia;
		this.observacoesDeficiencia = observacoesDeficiencia;
	}

	public boolean isPossuiDeficiencia() {
		return possuiDeficiencia;
	}

	public void setPossuiDeficiencia(boolean possuiDeficiencia) {
		this.possuiDeficiencia = possuiDeficiencia;
	}

	public TipoDeficiencia getTipoDeficiencia() {
		return tipoDeficiencia;
	}

	public void setTipoDeficiencia(TipoDeficiencia tipoDeficiencia) {
		this.tipoDeficiencia = tipoDeficiencia;
	}

	public String getObservacoesDeficiencia() {
		return observacoesDeficiencia;
	}

	public void setObservacoesDeficiencia(String observacoesDeficiencia) {
		this.observacoesDeficiencia = observacoesDeficiencia;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}
	public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    public void addChamado(Chamado chamado) {
        chamados.add(chamado);
        chamado.setUsuario(this);
    }

    public void removeChamado(Chamado chamado) {
        chamados.remove(chamado);
        chamado.setUsuario(null);
    }
}