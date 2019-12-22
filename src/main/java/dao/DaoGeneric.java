package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import pos_java_maven_hibernate.HibernateUtil;

public class DaoGeneric<E> {
	
	private EntityManager entityManager = HibernateUtil.getEntityManager();
	
	
	public void salvar(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade);
		transaction.commit();
	}
	
	public E pesquisar(E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);
		E e = (E) entityManager.find(entidade.getClass(), id);
		return e;
	}
	
	public E pesquisar(Long id, Class<E> entidade) {
		return (E) entityManager.find(entidade, id);		
	}
	
	//salva ou atualiza
	public E updateMerge(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		E e = entityManager.merge(entidade);
		transaction.commit();
		
		return e;
	}
	

}
