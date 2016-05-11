package com.app.server.service.shopdb.shopdomain;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import com.app.shared.shopdb.shopdomain.ShopABC;
import java.util.List;
import com.athena.server.pluggable.utils.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "", versionNumber = "1", comments = "Service for ShopABC Transaction table", complexity = Complexity.MEDIUM)
public abstract class ShopABCService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(ShopABC entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<ShopABC> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(ShopABC entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<ShopABC> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}
