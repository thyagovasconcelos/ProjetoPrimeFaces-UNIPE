package br.com.triadworks.erp.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.triadworks.erp.dao.FuncionarioDao;
import br.com.triadworks.erp.modelo.Funcionario;
import br.com.triadworks.erp.util.FacesUtils;

@ManagedBean
public class FuncionarioBean {

	private Funcionario funcionario = new Funcionario();
	
	public Funcionario getFuncionario(){
		return this.funcionario;
	}
	
	/**
	 * Efetua a gravacao
	 * @throws InterruptedException 
	 */
	public void salva() throws InterruptedException{
		
		FuncionarioDao dao = new FuncionarioDao();
		
		if(this.funcionario.getId() == null)
			dao.adiciona(funcionario);
		else
			dao.atualiza(funcionario);		
	
		this.funcionario = new Funcionario();
		
		new FacesUtils().adicionaMensagemDeSucesso("Funcionário gravado com sucesso");
	}
	
	/**
	 * Listagem de funcionarios
	 */
	
	public List<Funcionario> getFuncionarios(){
		
		FuncionarioDao dao = new FuncionarioDao();
		return dao.lista();
	}
	
	/**
	 * Remover	 * 
	 */
	
	public void remove(Funcionario funcionario){
		
		FuncionarioDao dao = new FuncionarioDao();
		dao.remove(funcionario);
		
		new FacesUtils().adicionaMensagemDeSucesso("Funcionário removido com sucesso");
	}
	
	/**
	 * 
	 * @param funcionario
	 */
	public void setFuncionario(Funcionario funcionario){
		this.funcionario = funcionario;
	}
	
	/**
	 * Cancelar
	 */
	
	public void cancela(){		
		this.funcionario = new Funcionario();
	}
}
