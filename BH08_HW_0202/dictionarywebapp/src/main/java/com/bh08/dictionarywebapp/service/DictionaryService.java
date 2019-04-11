package com.bh08.dictionarywebapp.service;

import java.util.Optional;

import com.bh08.dictionarywebapp.dao.DictionaryDAO;
import com.bh08.dictionarywebapp.model.HunEng;

public class DictionaryService {

	private DictionaryDAO dao = DictionaryDAO.getInstance();

	public Optional<HunEng> findByHun(String hun) {
		return dao.findByHun(hun);
	}

	public HunEng save(HunEng obj) {
		return dao.save(obj);
	}
}
