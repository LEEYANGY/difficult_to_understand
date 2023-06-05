package xyz.leeyangy.pojo;

/**
 * @Author liyangyang
 * @Date: 2023/04/23 16:09
 * @Package xyz.leeyangy.pojo
 * @Version 1.0
 * @Description:
 */
public class Stock {

    private Integer id;

    private String name;

    private Long quantity;

    public Stock() {
    }

    public Stock(Integer id, String name, Long quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
