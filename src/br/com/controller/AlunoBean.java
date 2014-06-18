package br.com.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.dao.AlunoDAO;
import br.com.model.Aluno;

@ManagedBean
@RequestScoped
public class AlunoBean implements Serializable {

	private static final long serialVersionUID = -8617449298454815446L;
	private Aluno aluno = new Aluno();
	private AlunoDAO dao = new AlunoDAO();
	private List<Aluno> alunos;

	// retorna os alunos do bacno
	public List<Aluno> getAlunos() {
		this.alunos = dao.listAlunos();
		return alunos;
	}

	public Aluno getAluno() {
		if (aluno == null) {
			aluno = new Aluno();
		}

		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	// salva aluno no banco
	public String salvaAluno() {
		dao.save(aluno);
		return "listar?faces-redirect=true";
	}
	
	public String excluir() {
		dao.remove(aluno);
		return "listar?faces-redirect=true";
	}
}
