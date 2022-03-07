package inpt.sud.springbackendkotlin.controllers

import inpt.sud.springbackendkotlin.dao.ProductRepository
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.nio.file.Files
import java.nio.file.Paths


@RestController
class MyRestController(var productRepository: ProductRepository) {

    @GetMapping(path = ["/photoProduct/{id}"], produces = [MediaType.IMAGE_PNG_VALUE])
    @Throws(Exception::class)
    fun getPhoto(@PathVariable("id") id: Long): ByteArray? {
        val p = productRepository.findById(id).get()
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/ecom/products/" + p.getPhotoName()))
    }
}

