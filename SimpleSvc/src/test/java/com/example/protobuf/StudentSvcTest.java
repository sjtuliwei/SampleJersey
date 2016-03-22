package com.example.protobuf;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import com.example.StudentService;
import com.example.tutorial.Student;

public class StudentSvcTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig(StudentService.class);
    }
 
    @Test
    public void test() {
        final Student.Person student = target("student").request().get(Student.Person.class);
        assertEquals("William Li", student.getName());
    }
}
