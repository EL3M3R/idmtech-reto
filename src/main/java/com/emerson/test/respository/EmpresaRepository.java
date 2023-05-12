package com.emerson.test.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.emerson.test.dao.EmpresaDao;

@Repository
public interface EmpresaRepository extends CrudRepository<EmpresaDao, Long> {
	List<Object> findTop3ByOrderByIdDesc();
}
