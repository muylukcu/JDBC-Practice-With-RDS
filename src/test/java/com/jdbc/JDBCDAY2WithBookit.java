package com.jdbc;

import org.junit.Before;
import org.junit.Test;

import utils.DBUtils;

public class JDBCDAY2WithBookit {
	
	@Before
	public void setup() {
		//When we are working with more then one data base in our automation framework, we need to specify driver type before connection
		//To make sure that we are using correct driver
		//make sure your url is valid. It means you have a jdbc atrinbutes, not only host name
		String url = "jdbc:postgresql://room-reservation-qa.cxvqfpt4mc2y.us-east-1.rds.amazonaws.com:5432/room_reservation_qa";
		String user = "qa_user";
		String password = "Cybertek11!";
		DBUtils.createConnection(url, user, password);
	}
	
	@Test
	public void test1() {
		String query = "SELECT * FROM room";
		System.out.println(DBUtils.getQueryResultMap(query));
	}
}
