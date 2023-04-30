package com.github.hugovallada.products.service

import com.github.hugovallada.products.dto.ProductDTO
import com.github.hugovallada.products.repository.ProductRepository
import com.github.hugovallada.products.translators.toDTO
import com.github.hugovallada.products.translators.toEntity
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class ProductService(private val productRepository: ProductRepository) {

	fun listAllProducts(): Set<ProductDTO> = productRepository.listAll().map { it.toDTO() }.toSet()

	fun saveProduct(productDTO: ProductDTO) = productRepository.persist(productDTO.toEntity())

	fun update(id: Long, productDTO: ProductDTO) {
		productRepository.findById(id)?.let {
			with(productDTO) {
				it.name = name
				it.price = price
				it.description = description
				it.category = category
				it.model = model

				productRepository.persist(it)
			}
		}
	}

	fun delete(id: Long) = productRepository.deleteById(id)
}