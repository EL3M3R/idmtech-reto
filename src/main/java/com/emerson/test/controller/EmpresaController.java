package com.emerson.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emerson.test.dao.EmpresaDao;
import com.emerson.test.services.EmpresaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class EmpresaController {
 
	@Autowired 
	EmpresaService empresaService;
	
	private static final String RESPONSE_ERROR = "error";
	private static final String RESPONSE_MENSAJE = "mensaje";
	
	
	@PostMapping( value = "/create" )
    @PreAuthorize("hasRole('USER')")
	public ResponseEntity<Object> create ( @RequestBody EmpresaDao empresa ){
		Map<String, Object> response = new HashMap<>();
		EmpresaDao empresaNuevo = null;

		try {
			empresaNuevo = empresaService.create(empresa);
			response.put(RESPONSE_MENSAJE, "Ha sido insertado con éxito");
			response.put("empresa", empresaNuevo);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (DataAccessException e) {
			response.put(RESPONSE_MENSAJE, "Error al insertarlo en la base de datos");
			response.put(RESPONSE_ERROR, e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/list")
    @PreAuthorize("hasRole('USER')")
	public ResponseEntity<Object> list(){
		return ResponseEntity.ok(empresaService.list());
	}
}
