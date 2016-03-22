package com.example.SampleClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import com.example.tutorial.AddressBookProtos;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Client client = ClientBuilder.newClient();
    	
    	String entity = client.target("http://localhost:8080/SimpleSvc/webapi")
                .path("/myresource")
                .request(MediaType.TEXT_PLAIN_TYPE)
                .get(String.class);
    	System.out.println(entity);
    	
    	AddressBookProtos.Person addressbook = client.target("http://localhost:8080/SimpleSvc/webapi")
                .path("/person")
                .request("application/x-protobuf")
                .get(AddressBookProtos.Person.class);
    	System.out.println(addressbook.getEmail());
    	
    	AddressBookProtos.Person person = client.target("http://localhost:8080/SimpleSvc/webapi")
                .path("/person")
                .request(MediaType.APPLICATION_JSON)
                .get(AddressBookProtos.Person.class);
    	System.out.println(person.getEmail());
    	
    }
}
