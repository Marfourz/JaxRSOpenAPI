package fr.istic.taa.jaxrs.dao.generic;


import java.io.Serializable;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public abstract class AbstractJpaDao<K, T extends Serializable> implements IGenericDao<K, T> {

	protected Class<T> clazz;

	protected EntityManager entityManager;

	public AbstractJpaDao(Class<T> clazzToSet) {
		
		this.entityManager = EntityManagerHelper.getEntityManager();
		this.clazz = clazzToSet;
	}

	public void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	public T findOne(K id) {
		return entityManager.find(clazz, id);
	}

	public List<T> findManyById(List<K> ids) {
		return entityManager.createQuery("select e from " + clazz.getName() + " as e  WHERE e.id IN :ids",clazz).setParameter("ids", ids).getResultList();
	}

	public T getReference(K id) {
		return entityManager.getReference(clazz, id);
	}

	public List<T> findAll() {
		return entityManager.createQuery("select e from " + clazz.getName() + " as e",clazz).getResultList();
	}

	public void save(T entity) {
		EntityTransaction t = this.entityManager.getTransaction();
		t.begin();
		entityManager.persist(entity);
		t.commit();

	}

	public T update(final T entity) {
		EntityTransaction t = this.entityManager.getTransaction();
		t.begin();
		T res = entityManager.merge(entity);
		t.commit();
		return res;

	}

	public void delete(T entity) {
		EntityTransaction t = this.entityManager.getTransaction();
		t.begin();
		entityManager.remove(entity);
		t.commit();

	}

	public void deleteById(K entityId) {
		T entity = findOne(entityId);
		delete(entity);
	}



}
