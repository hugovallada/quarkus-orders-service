package com.github.hugovallada.products.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "product")
class ProductEntity(
	@Id
	@GeneratedValue
	val id: Long = 0L,
	var name: String,
	var description: String,
	var category: String,
	var model: String,
	var price: BigDecimal

)