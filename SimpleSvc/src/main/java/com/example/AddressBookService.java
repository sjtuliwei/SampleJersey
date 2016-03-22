package com.example;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.tutorial.AddressBookProtos;

@Path("/person")
public class AddressBookService {
    @GET
//    @Produces({"application/x-protobuf", MediaType.APPLICATION_JSON})
//    @Consumes({"application/x-protobuf", MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)

//    @Produces(MediaType.APPLICATION_XML)
    public AddressBookProtos.Person getPerson() {
        return AddressBookProtos.Person.newBuilder()
                .setId(1)
                .setName("Sam")
                .setEmail("sam@sampullara.com")
               .addPhone(AddressBookProtos.Person.PhoneNumber.newBuilder()
                        .setNumber("415-555-1212")
                       .setType(AddressBookProtos.Person.PhoneType.MOBILE)
                       .build())
                .build();
    }

    @POST
    @Consumes("application/x-protobuf")
    @Produces("application/x-protobuf")
    public AddressBookProtos.Person reflect(AddressBookProtos.Person person) {
        return person;
    }
}