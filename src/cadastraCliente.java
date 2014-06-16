import br.com.dao.*;
import br.com.model.*;

public class cadastraCliente {
	
	public static void main(String args[]){
			
		Aluno aluno = new Aluno();
		
		aluno.setNome("Cesar Martins");
		aluno.setEndereco("Rua Portugal");
		aluno.setTelefone("99225998");
		
		alunoDao dao = new alunoDao();
		dao.add(aluno);
	}
}
