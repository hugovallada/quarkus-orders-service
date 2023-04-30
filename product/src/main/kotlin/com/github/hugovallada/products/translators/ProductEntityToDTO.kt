package com.github.hugovallada.products.translators

import com.github.hugovallada.products.dto.ProductDTO
import com.github.hugovallada.products.entity.ProductEntity

fun ProductEntity.toDTO() = ProductDTO(name,description, category, model, price)