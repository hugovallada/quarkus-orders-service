package com.github.hugovallada.products.repository

import com.github.hugovallada.products.entity.ProductEntity
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class ProductRepository: PanacheRepository<ProductEntity>