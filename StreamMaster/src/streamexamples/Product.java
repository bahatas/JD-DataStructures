package streamexamples;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@With

@NoArgsConstructor
public class Product {

    private Long id;
    private String name;
    private String category;
    @With
    private Double price;
    private Set<Order> orders;

    public Product(Long id, String name, String category, Double price, Set<Order> orders) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.orders = orders;
    }

    public Product(Long id, String name, String category, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public static List<Product> findAll(){
        List<Product> res = new ArrayList<>();
        res.add(new Product(1l,"pr1", "Baby",100.00));
        res.add(new Product(2l,"pr2", "Books",150.00));
        res.add(new Product(3l,"pr3", "Baby",15.00));
        return  res;
    }
}
