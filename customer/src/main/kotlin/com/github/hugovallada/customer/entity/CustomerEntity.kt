package com.github.hugovallada.customer.entity

import jakarta.persistence.*

@Entity
@Table(name = "customer")
class CustomerEntity(
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	val id: Long = 0L,
	var name: String,
	var phone: String,
	var email: String,
	var address: String,
	var age: Int
)