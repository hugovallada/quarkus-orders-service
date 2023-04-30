package com.github.hugovallada.order.service

import com.github.hugovallada.order.client.CustomerClient
import com.github.hugovallada.order.client.ProductClient
import com.github.hugovallada.order.dto.OrderDTO
import com.github.hugovallada.order.repository.OrderRepository
import com.github.hugovallada.order.translators.toDTO
import com.github.hugovallada.order.translators.toEntity
import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.rest.client.inject.RestClient

@ApplicationScoped
class OrderService(
	private val orderRepository: OrderRepository,
	@RestClient
	private val customerClient: CustomerClient,
	@RestClient
	private val productClient: ProductClient
) {

	fun save(orderDTO: OrderDTO) {
		val customer = customerClient.getCustomerById(orderDTO.customerId)

		if (customer.name == orderDTO.customerName
			&& productClient.getProductById(orderDTO.productId) != null
		) {
			orderRepository.persist(orderDTO.toEntity())
		} else {
			throw RuntimeException("Not Found!")
		}
	}

	fun listOrders() = orderRepository.listAll().map { it.toDTO() }


}