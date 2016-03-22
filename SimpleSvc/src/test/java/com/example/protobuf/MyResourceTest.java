package com.example.protobuf;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import com.example.MyResource;

public class MyResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(MyResource.class);
    }
 
    @Test
    public void test() {
        final String hello = target("myresource").request().get(String.class);
        assertEquals("Got it!", hello);
    }
}
