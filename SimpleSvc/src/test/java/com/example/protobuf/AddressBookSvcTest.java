package com.example.protobuf;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import com.example.AddressBookService;
import com.example.tutorial.AddressBookProtos;

public class AddressBookSvcTest extends JerseyTest {
    @Override
    protected Application configure() {
        ResourceConfig resourceConfig = new ResourceConfig(AddressBookService.class);
		return resourceConfig;
    }
 
    @Test
    public void test() {
        Builder request = target("person").request();
        request.accept("application/x-protobuf");
		final AddressBookProtos.Person person = request.get(AddressBookProtos.Person.class);
        assertEquals("sam@sampullara.com", person.getEmail());
    }

}
