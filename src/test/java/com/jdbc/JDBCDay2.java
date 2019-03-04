package com.jdbc;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.*;
import utils.DBUtils;

public class JDBCDay2 {
	
	String name = "SdetUserAuto";
	String lastName = "AutoLastName";

	@Before
	public void setup() {
		//When we are working with more then one data base in our automation framework, we need to specify driver type before connection
		//To make sure that we are using correct driver
		//make sure your url is valid. It means you have a jdbc atrinbutes, not only host name
		String url = "jdbc:postgresql://myrdspostgresql.cxvqfpt4mc2y.us-east-1.rds.amazonaws.com:5432/hr";
		String user = "sdetuser";
		String password = "sdetuser12345";
		DBUtils.createConnection(url, user, password);
	}
	
	@Ignore
	@Test
	public void test1() {
		//update client with client id 100 and change his email
		String query = "UPDATE employees SET email = 'sking@cybertekschool.com' WHERE employee_id = 100";
		DBUtils.executeQuery(query);
	}
	
	@Test
	public void test2() {
		//find employee that we added in pgAdmin, based on first name and last name
		String query = "SELECT * FROM employees WHERE first_name = 'SdetName' AND last_name = 'SdetLastName';";
		System.out.println(DBUtils.getQueryResultMap(query));
	}
	
	@Test
    public void test3 () {
		//this our command to add new employee to the employees table with parameters
        String query = "INSERT INTO employees (first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)\n" + 
        		"VALUES('"+name+"', '"+lastName+"', 'testemail@gmail.com', '515.123.4567', '2018-06-17 00:00:00', 'IT_PROG', 10101.01, 0.01, 100, 110);";
        //to execute our command
        DBUtils.executeQuery(query);
    }
	
	@Test
	public void test4() {
		//to verify that employee with first name and last name exists in the data base
		Assert.assertTrue(DBUtils.verifyEmployeeExists(name, lastName));
	}
	
	@After
	public void teardown() {
		DBUtils.destroy();
	}
	
}
