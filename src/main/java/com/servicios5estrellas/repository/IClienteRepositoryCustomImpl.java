package com.servicios5estrellas.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class IClienteRepositoryCustomImpl implements IClienteRepositoryCustom {
	
	@PersistenceContext
	private EntityManager em;
	int nextId;

	@Override
	public int getNextId() {
		Query query = em.createNativeQuery("SELECT max(CLIENTE_ID) FROM CLIENTE");
		if(query.getResultList().get(0)==null) {
			nextId = 1;
		} else {
			nextId = (Integer) query.getResultList().get(0)+1;
		}
		return nextId;
	}

}
