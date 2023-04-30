package com.github.hugovallada.order.client

import com.github.hugovallada.order.dto.CustomerDTO
import jakarta.enterprise.context.ApplicationScoped
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient

@Path("/customers/v1")
@RegisterRestClient
@ApplicationScoped
interface CustomerClient {
	@GET
	@Path("/{id}")
	fun getCustomerById(@PathParam("id") id: Long): CustomerDTO
}