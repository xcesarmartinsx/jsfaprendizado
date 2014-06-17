package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.model.Aluno;

public class AlunoDAO {
		
	private EntityManager em;
	private EntityTransaction tx;
	
	public AlunoDAO() {
		// TODO Auto-generated constructor stub
		this.em = getEntityManager();
		this.tx = em.getTransaction();
	}
	
	//adiciona um aluno no banco
	public void save(Aluno aluno){
		tx.begin();
		em.merge(aluno);
		tx.commit();
	}
	
	
	//traz todos os alunos

	public List<Aluno> listAlunos(){
		Query q = getEntityManager().createQuery("select a from Aluno a", Aluno.class);
		return q.getResultList();
	}
	
	//deleta o aluno
	public void remove(Aluno aluno){
		tx.begin();
		em.remove(aluno);
		tx.commit();
	}
	
	private EntityManager getEntityManager(){
		if (em == null){
			this.em = Persistence.createEntityManagerFactory("default").createEntityManager();	
		}
		return em;
	}
	
}
