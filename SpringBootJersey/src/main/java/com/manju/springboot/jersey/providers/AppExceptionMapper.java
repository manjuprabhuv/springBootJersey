package com.manju.springboot.jersey.providers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.manju.springboot.jersey.model.ApplicationException;

@Provider
@Configuration
public class AppExceptionMapper implements ExceptionMapper<Exception> {
	@Value("${boot.jersey.generic.exception.id}")
	private String errorId;
	@Value("${boot.jersey.generic.exception.message}")
	private String errorMessage;

	@Override
	public Response toResponse(Exception exception) {
		// TODO Auto-generated method stub

		ApplicationException ex = new ApplicationException(errorId, errorMessage);
		/*Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).type(MediaType.APPLICATION_JSON)
				.entity(ex).build();*/

		return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).type(MediaType.APPLICATION_JSON)
				.entity(ex).build();
	}

}
