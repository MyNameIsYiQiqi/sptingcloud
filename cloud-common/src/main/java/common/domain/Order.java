package common.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <>
 *
 * @author : 177
 * @date :  2020/1/6 17:07
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Order {

    private Long id; // 主键id
    private String name; // 商品名称
    private Double price; // 商品价格
    private String dbSource; // 所存的数据库

    public Order() {
    }

    public Order(Long id, String name, Double price, String dbSource) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.dbSource = dbSource;
    }


    public void test01(){

    }

}
