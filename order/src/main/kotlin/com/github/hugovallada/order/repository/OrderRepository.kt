package com.github.hugovallada.order.repository

import com.github.hugovallada.order.entity.OrderEntity
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class OrderRepository: PanacheRepository<OrderEntity>