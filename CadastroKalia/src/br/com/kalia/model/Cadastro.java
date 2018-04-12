package br.com.kalia.model;

import java.util.Date;

public class Cadastro {
	private int idRequisitante;
	private String objeto;
	private String tipo;
	private String requisitante;
	private String dataEmprestimo;
	private String dataDevolucao;
	private String email;
	
	
	public void setidRequisitante(int idCadidRequisitanteastro) {
		this.idRequisitante = idCadidRequisitanteastro;
	}
	
	public int getIdRequisitante() {
		return idRequisitante;
	}
	
	
	public String getObjeto() {
		return objeto;
	}
	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getRequisitante() {
		return requisitante;
	}
	public void setRequisitante(String requisitante) {
		this.requisitante = requisitante;
	}
	
	public String getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	
	public String getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}
