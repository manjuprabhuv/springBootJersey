package com.demo.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.demo.model.Test;
import com.manju.springboot.jersey.annotation.SpringBootJerseyController;
import com.manju.springboot.jersey.model.ApplicationException;

@Path("/test")
@SpringBootJerseyController
@Component
public class TestResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Test getTestResource() {
		Test testObj = new Test();
		testObj.setId(1);
		testObj.setMessage("Test Message");
		return testObj;
	}
	
	@GET
	@Path("/exception")
	@Produces(MediaType.APPLICATION_JSON)
	public Test getTestExceptionResource() {
		throw new ApplicationException("ERR_02", "Custom error Message");
		/*Test testObj = new Test();
		testObj.setId(1);
		testObj.setMessage("Test Message");
		return testObj;*/
	}

}
