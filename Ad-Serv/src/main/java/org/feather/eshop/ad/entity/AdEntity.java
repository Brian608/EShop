package org.feather.eshop.ad.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @projectName: EShop
 * @package: org.feather.eshop.ad.entity
 * @className: AdEntity
 * @author: feather
 * @description: TODO
 * @since: 2023-06-05 21:43
 * @version: 1.0
 */

@Entity
@Table(name = "ad")
public class AdEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public AdEntity() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    /**
     * 跳转地址
     */
    @Column(name = "click_url")
    private String clickUrl;

    /**
     * 图片地址
     */
    @Column(name = "img_url")
    private String imgUrl;
    /**
     * 审核状态0 未生效 1 已生效
     */
    @Column(name = "status")
    private String status;


    /**
     * 排序
     */
    @Column(name = "order")
    private Integer order;

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

    public String getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}

