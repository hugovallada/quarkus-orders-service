package com.github.hugovallada.order.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "orders")
class OrderEntity(
	@Id
	@GeneratedValue
	val id: Long = 0L,
	var customerId: Long,
	var customerName: String,
	var productId: Long,
	var orderValue: BigDecimal
)