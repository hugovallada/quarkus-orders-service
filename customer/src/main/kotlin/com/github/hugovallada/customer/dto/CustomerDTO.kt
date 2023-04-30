package com.github.hugovallada.customer.dto

@JvmRecord
data class CustomerDTO(
	val name: String,
	val phone: String,
	val email: String,
	val address: String,
	val age: Int
)