package com.github.hugovallada.order.translators

import com.github.hugovallada.order.dto.OrderDTO
import com.github.hugovallada.order.entity.OrderEntity

fun OrderDTO.toEntity() = OrderEntity(
	customerId = customerId, customerName = customerName, productId = productId, orderValue = orderValue
)