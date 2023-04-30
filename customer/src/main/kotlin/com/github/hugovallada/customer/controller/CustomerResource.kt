package com.github.hugovallada.customer.controller

import com.github.hugovallada.customer.dto.CustomerDTO
import com.github.hugovallada.customer.service.CustomerService
import jakarta.transaction.Transactional
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType.APPLICATION_JSON
import jakarta.ws.rs.core.Response
import org.jboss.resteasy.reactive.ResponseStatus
import org.jboss.resteasy.reactive.RestResponse

@Path("/api/customers/v1")
class CustomerResource(private val customerService: CustomerService) {

	@POST
	@ResponseStatus(201)
	@Transactional
	fun create(customerDTO: CustomerDTO) = customerService.createNewCustomer(customerDTO).let {
		Response.status(Response.Status.CREATED).build()
	}

	@GET
	@Produces(APPLICATION_JSON)
	@ResponseStatus(200)
	fun findAllCustomers() = RestResponse.ok(customerService.findAll())

	@PUT
	@Path("/{id}")
	@ResponseStatus(202)
	@Transactional
	fun update(@PathParam("id") id: Long, customerDTO: CustomerDTO): Response {
		customerService.changeCustomer(id, customerDTO)
		return Response.status(Response.Status.ACCEPTED).build()
	}

	@DELETE
	@Path("/{id}")
	@ResponseStatus(204)
	@Transactional
	fun delete(@PathParam("id") id: Long): Response = customerService.delete(id).let { Response.status(204).build() }


}