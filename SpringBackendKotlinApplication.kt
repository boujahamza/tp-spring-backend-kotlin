package inpt.sud.springbackendkotlin

import inpt.sud.springbackendkotlin.dao.CategoryRepository
import inpt.sud.springbackendkotlin.dao.ProductRepository
import inpt.sud.springbackendkotlin.data.Category
import inpt.sud.springbackendkotlin.data.Product
import net.bytebuddy.utility.RandomString
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import java.util.*

@SpringBootApplication
class SpringBackendKotlinApplication(
        @Autowired
        var productRepository: ProductRepository,
        @Autowired
        var categoryRepository: CategoryRepository,
        @Autowired
        var repositoryRestConfiguration: RepositoryRestConfiguration
): CommandLineRunner {
    override fun run(vararg args: String?) {
        repositoryRestConfiguration.exposeIdsFor(Product::class.java,Category::class.java)

        categoryRepository.save(Category(null,"Computers",null,null))
        categoryRepository.save(Category(null,"Printers",null,null))
        categoryRepository.save(Category(null,"Smartphones",null,null))

        var rnd: Random = Random()

        categoryRepository.findAll().forEach{
            for(i in 0..9){
                var p: Product = Product(
                        null,
                        RandomString.make(10),
                        null,
                        100 + rnd.nextInt(10000),
                        rnd.nextBoolean(),
                        rnd.nextBoolean(),
                        rnd.nextBoolean(),
                        "unknown.png",
                        it
                )
                productRepository.save(p)
            }
        }
    }
}

fun main(args: Array<String>) {
    runApplication<SpringBackendKotlinApplication>(*args)
}
