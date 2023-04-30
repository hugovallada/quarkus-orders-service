package com.github.hugovallada.order.dto

import java.math.BigDecimal

@JvmRecord
data class OrderDTO(
	val customerId: Long,
	val customerName: String,
	val productId: Long,
	val orderValue: BigDecimal
)