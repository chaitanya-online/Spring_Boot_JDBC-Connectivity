package com.Jdbc.example.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.Jdbc.example.Entity.Serole;

@Repository
public class SeroleRepository_Impl implements SeroleRepository {
	String INSERT_EMPLOYEE = "insert into serole (E_id,E_Name,E_Mail)values(:id,:e_name,:e_mail)";
	private static final String UPDATE_Employee_BY_ID_ = "UPDATE serole SET E_Name=? WHERE E_Id=?";
	private static final String UPDATE_EMPLOYEE_EMAIL_BY_ID2 = "UPDATE serole set E_mail=:e_mail where E_Id=:e_id";
	private static final String GET_Employee_BY_ID_QUERY = "SELECT * FROM serole WHERE E_Id=:id";
	private static final String DELETE_Employee_BY_ID = "delete from serole where E_Id=?";
	private static final String GET_Employees = "SELECT * FROM serole";

	@Autowired
	private JdbcTemplate jdbc;
	@Autowired
	private NamedParameterJdbcTemplate template;

	@Override
	// public Serole saveEmployee(Serole serole) {
	// jdbc.update(INSERT_EMPLOYEE, serole.getE_id(), serole.getE_Name(),
	// serole.getE_Mail());
	// return serole;

	// }
	public Serole saveEmployee(Serole serole) {
		SqlParameterSource name = new MapSqlParameterSource("id", serole.getE_id())
				.addValue("e_name", serole.getE_Name()).addValue("e_mail", serole.getE_Mail());
		template.update(INSERT_EMPLOYEE, name);
		return serole;
	}

	@Override
	public Serole updateEmployee(Serole serole) {
		jdbc.update(UPDATE_Employee_BY_ID_, serole.getE_Name(), serole.getE_id());
		return serole;
	}

	public Serole updateEmployeeEmail(Serole serole) {
		SqlParameterSource email = new MapSqlParameterSource("e_mail", serole.getE_Mail()).addValue("e_id",
				serole.getE_id());
		template.update(UPDATE_EMPLOYEE_EMAIL_BY_ID2, email);
		return serole;
	}

	// @Override
//	public Serole getEmployeeById(int id) {
//		return jdbc.queryForObject(GET_Employee_BY_ID_QUERY, (rs, rowNum) -> {
//
//			return new Serole(rs.getInt("E_Id"), rs.getString("E_Name"), rs.getString("E_Mail"));
//		}, id);
//	}

	public Serole getEmployeeById(Serole serole) {
		SqlParameterSource employeebyid = new MapSqlParameterSource("id", serole.getE_id());

		return (Serole) template.queryForObject(GET_Employee_BY_ID_QUERY, employeebyid, new EmployeeMapper());
	}

	class EmployeeMapper implements RowMapper<Serole> {

		@Override
		public Serole mapRow(ResultSet rs, int rowNum) throws SQLException {
			Serole ser = new Serole();
			ser.setE_id(rs.getInt("E_id"));
			ser.setE_Name(rs.getString("E_Name"));
			ser.setE_Mail(rs.getString("E_Mail"));
			return ser;
		}

	}

	@Override
	public String deleteById(int id) {
		jdbc.update(DELETE_Employee_BY_ID, id);
		return "Employee Deleted with id" + id;
	}

	@Override
	public List<Serole> allEmployees() {
		return jdbc.query(GET_Employees, (rs, rowNum) -> {
			return new Serole(rs.getInt("E_Id"), rs.getString("E_Name"), rs.getString("E_Mail"));
		});
	}

}
