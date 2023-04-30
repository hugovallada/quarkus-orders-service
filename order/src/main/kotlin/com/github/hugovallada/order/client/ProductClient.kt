package com.github.hugovallada.order.client

import com.github.hugovallada.order.dto.ProductDTO
import jakarta.enterprise.context.ApplicationScoped
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient

@Path("/products/v1")
@RegisterRestClient
@ApplicationScoped
interface ProductClient {
	@GET
	@Path("/{id}")
	fun getProductById(id: Long): ProductDTO?
}