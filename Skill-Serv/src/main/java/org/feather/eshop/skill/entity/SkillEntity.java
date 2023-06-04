package org.feather.eshop.skill.entity;

/**
 * @projectName: EShop
 * @package: org.feather.eshop.skill.entity
 * @className: SkillEntity
 * @author: feather
 * @description: TODO
 * @since: 2023-06-04 10:59
 * @version: 1.0
 */

import java.io.Serializable;

/**
 * 用户排队抢单信息实体
 */
public class SkillEntity implements Serializable {
    private Long productId;
    private String userId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
