package io.cxh.spring.po;

import java.util.Date;

/**
 * Created by Administrator on 2017/3/10.
 */
public class Item {
    private Integer id;//商品id
    private String name;//商品名称
    private Float price;//商品价格
    private String pic;//商品图片
    private Date createTime;//创建时间
    private String detail;//详细信息

    public Item() {
    }


    // int/long, BigDecimal
    public Item(Integer id, String name, Float price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
