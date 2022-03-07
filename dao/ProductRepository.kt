package inpt.sud.springbackendkotlin.dao

import inpt.sud.springbackendkotlin.data.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource
import org.springframework.web.bind.annotation.CrossOrigin


@CrossOrigin("*")
@RepositoryRestResource
interface ProductRepository: JpaRepository<Product,Long> {
    @RestResource(path = "/selectedProducts")
    fun findBySelectedIsTrue(): List<Product?>?
}

