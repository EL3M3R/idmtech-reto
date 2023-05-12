package com.emerson.test.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import com.emerson.test.dao.EmpresaDao;


public interface EmpresaService  {

	EmpresaDao create(EmpresaDao empresa);
	List<Object> list();
}
