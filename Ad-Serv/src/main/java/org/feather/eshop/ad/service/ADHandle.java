package org.feather.eshop.ad.service;
import org.feather.eshop.ad.entity.AdEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.javatool.canal.client.handler.EntryHandler;
/**
 * @projectName: EShop
 * @package: org.feather.eshop.ad.service
 * @className: ADHandle
 * @author: feather
 * @description: TODO
 * @since: 2023-06-05 21:46
 * @version: 1.0
 */

@Component
public class ADHandle implements EntryHandler<AdEntity> {

    @Autowired
    private ADService adService;

    @Override
    public void insert(AdEntity adEntity) {
        adService.modify(adEntity);
    }

    @Override
    public void update(AdEntity before, AdEntity after) {
        adService.modify(after);
    }

    @Override
    public void delete(AdEntity adEntity) {
        adService.delete(adEntity.getId());
    }
}

