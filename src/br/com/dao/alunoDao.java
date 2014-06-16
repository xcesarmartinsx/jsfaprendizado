package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import javax.persistence.Query;

import br.com.model.Aluno;

public class alunoDao {
		
	private EntityManager em;
	private EntityTransaction tx;
	private EntityManagerFactory emf;
	
	public alunoDao() {
		// TODO Auto-generated constructor stub
		this.emf = Persistence.createEntityManagerFactory("default");
		this.em = emf.createEntityManager();
		this.tx = em.getTransaction();
	}
	
	//adiciona um aluno no banco
	public void add(Aluno aluno){
		tx.begin();
		em.persist(aluno);
		tx.commit();
		em.close();
		emf.close();
	}
	
	
	//traz todos os alunos
	public List<Aluno> listAlunos(){
	
		Query q = this.em.createQuery("select a from Aluno a", Aluno.class);
		return q.getResultList();
		
	}
	
	//deleta o aluno
	public void remove(Aluno aluno){
		tx.begin();
		em.remove(aluno);
		tx.commit();
		em.close();
		emf.close();
	}
	
}
