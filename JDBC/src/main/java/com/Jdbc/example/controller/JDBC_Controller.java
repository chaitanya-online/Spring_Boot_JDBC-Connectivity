package com.Jdbc.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JDBC_Controller {
	@Autowired
	JdbcTemplate jdbc;

	@PostMapping("/Insert")
	public String create() {

		String Query = "insert into bcci (playerFirst_Name,LastName,jersey_No) values('Yuvaraj','Singh',12);";
		String Query1 = "insert into bcci (playerFirst_Name,LastName,jersey_No) values('Sachin','Tendulkar',10);";
		String Query2 = "insert into bcci (playerFirst_Name,LastName,jersey_No) values('Amthul','Saba',09);";


		jdbc.execute(Query);
		jdbc.execute(Query1);
		jdbc.execute(Query2);

		
		

		return "Data Inserted";

	}

	@GetMapping("/PlayerBy/{id}")
	public String playerById(@PathVariable int id) {
		String Query = "select * from bcci where id=id;";
		jdbc.execute(Query);

		return "Data is of player is " + id;
	}

}
