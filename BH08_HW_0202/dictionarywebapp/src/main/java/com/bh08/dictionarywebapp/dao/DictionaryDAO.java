package com.bh08.dictionarywebapp.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.bh08.dictionarywebapp.model.HunEng;

public class DictionaryDAO {

	private static DictionaryDAO instance;

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("HunEngDict");

	private DictionaryDAO() {
	}
	
	public static DictionaryDAO getInstance() {
		if (instance == null) {
			instance = new DictionaryDAO();
		}
		return instance;
	}
	
	public Optional<HunEng> findByHun(String hun) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<HunEng> q = em.createQuery("SELECT t FROM HunEng t WHERE t.hungarian = :hun", HunEng.class);
		q.setParameter("hun", hun);
		try {
			HunEng result = q.getSingleResult();
			return Optional.of(result);
		} catch (NoResultException e) {
			return Optional.empty();
		} finally {
			em.close();
		}
	}

	public HunEng save(HunEng obj) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(obj);
		
		tx.commit();
		
		em.close();
		return obj;
		
	}
	
}
