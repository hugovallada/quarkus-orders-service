package com.github.hugovallada.customer.translators

import com.github.hugovallada.customer.dto.CustomerDTO
import com.github.hugovallada.customer.entity.CustomerEntity

fun CustomerDTO.toEntity() = CustomerEntity(
	name = name, phone = phone, email = email, address = address, age = age
)
