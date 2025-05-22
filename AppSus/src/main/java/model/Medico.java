package model;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class Medico extends Pessoa {

	private String crm;
	private String especialidade;

	public Medico() {
		super();
	}

	public Medico(String nome, String cpf, LocalDate dataDeNascimento, Endereco endereco, String telefoneContato, String emailContato, String crm, String especialidade) {
		super(nome, cpf, dataDeNascimento, telefoneContato, emailContato, endereco);
		this.crm = crm;
		this.especialidade = especialidade;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
}