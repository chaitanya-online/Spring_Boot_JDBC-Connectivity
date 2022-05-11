package com.Jdbc.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Jdbc.example.Dao.SeroleRepository;
import com.Jdbc.example.Entity.Serole;

@RestController
public class Serole_Controller {
	@Autowired
	SeroleRepository serolerepository;
	private static final Logger LOG = LoggerFactory.getLogger(Serole_Controller.class);

	@PostMapping("/SaveEmployee")
	public Serole saveEmployee(@RequestBody Serole serole) {
		LOG.info("Save");
		return serolerepository.saveEmployee(serole);
	}

	@PutMapping("/Update")
	public Serole updateEmployee(@RequestBody Serole serole) {
		return serolerepository.updateEmployee(serole);
	}

	@PutMapping("/UpdateEmail")
	public Serole updateEmployeeEmail(@RequestBody Serole serole) {
		return serolerepository.updateEmployeeEmail(serole);
	}

	@GetMapping("/GetEmployee")
	public Serole getEmployeeById(@RequestBody Serole serole) {
		LOG.info("GotEmployees");
		
		return serolerepository.getEmployeeById(serole);

	}

	@DeleteMapping("/DeleteById/{id}")
	public String deleteById(@PathVariable("id") int id) {
		return serolerepository.deleteById(id);
	}

	@GetMapping("/AllEmployees")
	public List<Serole> allEmployees() {
		return serolerepository.allEmployees();
	}

}
