package br.com.controller;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import br.com.dao.*;
import br.com.model.*;

@ManagedBean
@RequestScoped
public class alunoBean {
	

		private Aluno aluno = new Aluno();
		private alunoDao dao = new alunoDao();
		
		private List<Aluno> alunos;
		
		//retorna os alunos do bacno
		public List<Aluno> getAlunos() {
			this.alunos = dao.listAlunos();
			return alunos;
		}

		public void setAlunos(List<Aluno> alunos) {
			this.alunos = alunos;
		}

		public alunoDao getDao() {
			return dao;
		}

		public void setDao(alunoDao dao) {
			this.dao = dao;
		}

		public Aluno getAluno() {
			return aluno;
		}

		public void setAluno(Aluno aluno) {
			this.aluno = aluno;
		}
		
		//salva aluno no banco
		public String salvaAluno(Aluno aluno){
			dao.add(aluno);
			return "listar?faces-redirect=true";	
		}
		
		public void excluir(Aluno aluno){
			dao.remove(aluno);
		}
}
