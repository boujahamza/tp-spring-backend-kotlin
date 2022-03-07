package inpt.sud.springbackendkotlin.data

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import lombok.ToString
import javax.persistence.*

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long?,
    private var name: String,
    private var description: String?,
    @OneToMany(mappedBy = "category")
    private var products: Collection<Product>?
    ) : java.io.Serializable {
        fun getId(): Long? {
            return id
        }
        fun getName(): String {
            return name
        }
        fun getDescription(): String? {
            return description
        }
        fun getProducts(): Collection<Product>? {
            return products
        }
    }

