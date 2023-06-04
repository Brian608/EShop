package org.feather.eshop.skill.dao;

import org.feather.eshop.skill.entity.SkillOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @projectName: EShop
 * @package: org.feather.eshop.skill.dao
 * @className: SkillOrderRepository
 * @author: feather
 * @description: TODO
 * @since: 2023-06-04 10:56
 * @version: 1.0
 */
@Repository
public interface SkillOrderRepository extends JpaRepository<SkillOrder,Long> {
}
