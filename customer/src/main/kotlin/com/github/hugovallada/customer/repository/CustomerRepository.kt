package com.github.hugovallada.customer.repository

import com.github.hugovallada.customer.entity.CustomerEntity
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class CustomerRepository : PanacheRepository<CustomerEntity>