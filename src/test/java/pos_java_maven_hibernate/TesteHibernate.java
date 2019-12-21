package pos_java_maven_hibernate;

import org.junit.Test;

import dao.DaoGeneric;
import model.UsuarioPessoa;

public class TesteHibernate {

	@Test
	public void testeHibernateUtil(){
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setIdade(45);
		pessoa.setLogin("teste");
		pessoa.setNome("maria 2");
		pessoa.setSenha("123");
		pessoa.setSobrenome("rosario");
		pessoa.setEmail("teste@teste.com");
		
		daoGeneric.salvar(pessoa);
	}
	
}
