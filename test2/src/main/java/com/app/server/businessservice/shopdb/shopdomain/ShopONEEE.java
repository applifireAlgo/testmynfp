package com.app.server.businessservice.shopdb.shopdomain;
import com.app.server.repository.shopdb.shopdomain.ShopABCRepository;
import com.app.shared.shopdb.shopdomain.ShopABC;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShopONEEE {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private ShopABCRepository<ShopABC> shopABCRepository;

    public void shopONEE() throws Exception {
        com.app.shared.shopdb.shopdomain.ShopABC shopABC = new com.app.shared.shopdb.shopdomain.ShopABC();
        shopABC.setPkone("oneee");
        com.app.shared.shopdb.shopdomain.ShopABC shopABC1 = shopABCRepository.save(shopABC);
    }
}
