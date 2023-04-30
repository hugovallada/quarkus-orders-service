package com.github.hugovallada.customer.service

import com.github.hugovallada.customer.dto.CustomerDTO
import com.github.hugovallada.customer.entity.CustomerEntity
import com.github.hugovallada.customer.repository.CustomerRepository
import com.github.hugovallada.customer.translators.toDTO
import com.github.hugovallada.customer.translators.toEntity
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class CustomerService(
	private val customerRepository: CustomerRepository
) {
	fun findAll(): List<CustomerDTO> = customerRepository.listAll().map { it.toDTO() }

	fun createNewCustomer(customerDTO: CustomerDTO) = customerRepository.persist(customerDTO.toEntity())

	fun changeCustomer(id: Long, customerDTO: CustomerDTO) {
		val customer = customerRepository.findById(id) ?: throw IllegalStateException("Customer não encontrado")
		with(customerDTO) {
			customer.name = name
			customer.address = address
			customer.email = email
			customer.phone = phone
			customer.age = age
		}
	}

	fun delete(id: Long) {
		customerRepository.deleteById(id)
	}
}