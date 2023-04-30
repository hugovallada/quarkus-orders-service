package com.github.hugovallada.products.translators

import com.github.hugovallada.products.dto.ProductDTO
import com.github.hugovallada.products.entity.ProductEntity

fun ProductDTO.toEntity() = ProductEntity(
	name = name, description = description, category = category,
	model = model, price = price
)