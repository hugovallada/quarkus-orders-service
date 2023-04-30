package com.github.hugovallada.order.translators

import com.github.hugovallada.order.dto.OrderDTO
import com.github.hugovallada.order.entity.OrderEntity

fun OrderEntity.toDTO() = OrderDTO(
	customerId, customerName, productId, orderValue
)