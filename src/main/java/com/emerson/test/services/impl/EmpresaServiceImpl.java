package com.emerson.test.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.emerson.test.dao.EmpresaDao;
import com.emerson.test.respository.EmpresaRepository;
import com.emerson.test.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {
	
	@Autowired
	EmpresaRepository empresaRepository;

	@Override
	public List<Object> list() {
		return  empresaRepository.findTop3ByOrderByIdDesc();
	} 
	
	@Override
	@Transactional
	public EmpresaDao create(EmpresaDao empresa) {
		empresaRepository.save(empresa);
		return empresa;
	}

	


}
