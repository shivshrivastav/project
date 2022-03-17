package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GenericDao {
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void save(Object obj) {
		em.persist(obj);
		
	}
	public <E> E fetchById(Class<E> clazz, Object pk) {
		E e = em.find(clazz, pk);
		return e;
		
	}

}