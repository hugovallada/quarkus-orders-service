package com.github.hugovallada.order.dto

import java.math.BigDecimal

@JvmRecord
data class ProductDTO(
	val name: String,
	val description: String,
	val category: String,
	val model: String,
	val price: BigDecimal
)