package com.github.hugovallada.order.controller

import com.github.hugovallada.order.dto.OrderDTO
import com.github.hugovallada.order.service.OrderService
import jakarta.transaction.Transactional
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType.APPLICATION_JSON
import jakarta.ws.rs.core.Response
import org.jboss.resteasy.reactive.ResponseStatus
import org.jboss.resteasy.reactive.RestResponse

@Path("/api/orders/v1")
class OrderResource(private val orderService: OrderService) {

	@POST
	@ResponseStatus(201)
	@Consumes(APPLICATION_JSON)
	@Transactional
	fun save(orderDTO: OrderDTO) = with(orderService.save(orderDTO)) {
		Response.status(201).build()
	}

	@GET
	@ResponseStatus(200)
	@Produces(APPLICATION_JSON)
	fun listAll() = with(orderService.listOrders()) {
		RestResponse.ok(this)
	}

}