package com.github.hugovallada.products.controller

import com.github.hugovallada.products.dto.ProductDTO
import com.github.hugovallada.products.service.ProductService
import jakarta.transaction.Transactional
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType.APPLICATION_JSON
import jakarta.ws.rs.core.Response
import org.jboss.resteasy.reactive.ResponseStatus
import org.jboss.resteasy.reactive.RestResponse

@Path("/api/products/v1")
class ProductResource(private val productService: ProductService) {

	@POST
	@Produces(APPLICATION_JSON)
	@ResponseStatus(201)
	@Transactional
	fun save(productDTO: ProductDTO) = with(productService.saveProduct(productDTO)) {
		Response.status(201).build()
	}

	@GET
	@ResponseStatus(200)
	fun findAll(): RestResponse<Set<ProductDTO>> = with(productService.listAllProducts()) {
		RestResponse.ok(this)
	}

	@PUT
	@Path("/{id}")
	@ResponseStatus(202)
	@Transactional
	fun update(@PathParam("id") id: Long, productDTO: ProductDTO) = with(productService.update(id, productDTO)) {
		Response.accepted().build()
	}

	@DELETE
	@Path("/{id}")
	@ResponseStatus(204)
	@Transactional
	fun delete(@PathParam("id") id: Long) = with(productService.delete(id)) {
		Response.noContent().build()
	}
}