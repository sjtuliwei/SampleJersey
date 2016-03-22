package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.tutorial.Student;
import com.example.tutorial.Student.Person;

@Path("/student")

public class StudentService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Person getStudent(){
		Person student = Student.Person.newBuilder().setAge(16).setName("William Li").build();

		return student;
	}
}
