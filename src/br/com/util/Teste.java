package br.com.util;

import java.util.List;

import br.com.dao.AlunoDAO;
import br.com.model.Aluno;

public class Teste {

	public static void main(String[] args) {
		
		AlunoDAO dao = new AlunoDAO();
		
		Aluno kleyson = new Aluno();
		
		kleyson.setNome("Kleyson");
		kleyson.setTelefone("123123123");
		kleyson.setEndereco("Av. Brasil");
		
		dao.save(kleyson);
		
		List<Aluno> alunos = dao.listAlunos();
		
		for (Aluno aluno : alunos) {
			System.out.println(aluno.getNome());
		}

		
	}
	
	
}
