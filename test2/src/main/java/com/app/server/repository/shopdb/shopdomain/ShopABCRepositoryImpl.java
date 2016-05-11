package com.app.server.repository.shopdb.shopdomain;
import com.app.server.repository.core.SearchInterfaceImpl;
import com.app.shared.shopdb.shopdomain.ShopABC;
import org.springframework.stereotype.Repository;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.helper.ResourceFactoryManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.spartan.pluggable.logger.alarms.AppAlarm;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import java.lang.Override;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Repository
@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "", versionNumber = "1", comments = "Repository for ShopABC Transaction table", complexity = Complexity.MEDIUM)
public class ShopABCRepositoryImpl extends SearchInterfaceImpl implements ShopABCRepository<ShopABC> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<ShopABC> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.app.shared.shopdb.shopdomain.ShopABC> query = emanager.createQuery("select u from ShopABC u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("SHSD324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "ShopABCRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public ShopABC save(ShopABC entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("SHSD322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "ShopABCRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<ShopABC> save(List<ShopABC> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.shopdb.shopdomain.ShopABC obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("SHSD322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "ShopABCRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.app.shared.shopdb.shopdomain.ShopABC s = emanager.find(com.app.shared.shopdb.shopdomain.ShopABC.class, id);
        emanager.remove(s);
        Log.out.println("SHSD328100200", runtimeLogInfoHelper.getRequestHeaderBean(), "ShopABCRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void update(ShopABC entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("SHSD321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "ShopABCRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<ShopABC> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.shopdb.shopdomain.ShopABC obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("SHSD321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "ShopABCRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public ShopABC findById(String pk) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("ShopABC.findById");
        query.setParameter("pk", pk);
        com.app.shared.shopdb.shopdomain.ShopABC listOfShopABC = (com.app.shared.shopdb.shopdomain.ShopABC) query.getSingleResult();
        Log.out.println("SHSD324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "ShopABCRepositoryImpl", "findById", "Total Records Fetched = " + listOfShopABC);
        return listOfShopABC;
    }
}
