package inpt.sud.springbackendkotlin.data

import lombok.AllArgsConstructor
import lombok.Data
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.ToString
import javax.persistence.*

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
class Product(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private var id: Long?,
        private var name: String,
        private var description: String?,
        private var currentPrice: Int,
        private var promotion: Boolean,
        private var selected: Boolean,
        private var available: Boolean,
        private var photoName: String,
        @ManyToOne
        private var category: Category,
): java.io.Serializable{
        fun getId(): Long? {
                return id
        }
        fun getName(): String {
                return name
        }
        fun getDescription(): String? {
                return description
        }
        fun getCurrentPrice(): Int{
                return currentPrice
        }
        fun getPromotion(): Boolean {
                return promotion
        }
        fun getSelected(): Boolean {
                return selected
        }
        fun getAvailable(): Boolean {
                return available
        }
        fun getPhotoName(): String {
                return photoName
        }
        fun getCategory(): Category {
                return category
        }
}