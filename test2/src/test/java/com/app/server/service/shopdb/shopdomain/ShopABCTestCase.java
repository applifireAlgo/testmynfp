package com.app.server.service.shopdb.shopdomain;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.shopdb.shopdomain.ShopABCRepository;
import com.app.shared.shopdb.shopdomain.ShopABC;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.app.server.service.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.springframework.mock.web.MockServletContext;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.server.pluggable.interfaces.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class ShopABCTestCase extends EntityTestCriteria {

    @Autowired
    private ShopABCRepository<ShopABC> shopabcRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        MockServletContext mockServletContext = new MockServletContext("file:src/main/webapp");
        try {
            String _path = mockServletContext.getRealPath("/WEB-INF/conf/");
            LogManagerFactory.createLogManager(_path, AppLoggerConstant.LOGGER_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo("customer", "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
        runtimeLogInfoHelper.setRequestHeaderBean(new RequestHeaderBean(new RuntimeLogUserInfoBean("AAAA", "AAAA", request.getRemoteHost(), 0, 0, 0), "", methodCallStack.getRequestId()));
    }

    private ShopABC createShopABC(Boolean isSave) throws Exception {
        ShopABC shopabc = new ShopABC();
        shopabc.setPkone("2AlBo2sMl2ncWPdo9sCn4svOjuNIbpYJ6rJ6cIBuC2H6rXC9rK");
        shopabc.setEntityValidator(entityValidator);
        return shopabc;
    }

    @Test
    public void test1Save() {
        try {
            ShopABC shopabc = createShopABC(true);
            shopabc.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            shopabc.isValid();
            shopabcRepository.save(shopabc);
            map.put("ShopABCPrimaryKey", shopabc._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("ShopABCPrimaryKey"));
            ShopABC shopabc = shopabcRepository.findById((java.lang.String) map.get("ShopABCPrimaryKey"));
            shopabc.setPkone("fXItISL7qO7K4C0AFTExiiOvO36BrOQ2CffW5x8n0Mzn5swPB5");
            shopabc.setVersionId(1);
            shopabc.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            shopabcRepository.update(shopabc);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("ShopABCPrimaryKey"));
            shopabcRepository.findById((java.lang.String) map.get("ShopABCPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("ShopABCPrimaryKey"));
            shopabcRepository.delete((java.lang.String) map.get("ShopABCPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateShopABC(EntityTestCriteria contraints, ShopABC shopabc) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            shopabc.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            shopabc.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            shopabc.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            shopabcRepository.save(shopabc);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "pkone", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "pkone", "vFGwNYTmmd8Cag0rxNZWGLlteK8neBY5mgmV4QgqYPPjdhjohtIpV77JFRmR4LnSmzYF1QBY9vzKLEEFWiyuf0HFpt504bfLI8USBJnGtwM34IIRtaaZHFXAFm8pc8gIX3rNCz1qYIlIbg7deBGhDAgcz2bAkBuXlukMvr3MZPKv9x51jVOpe8rUMJU5bBP7HhR3YSQZ0X7mWD1UvDRS7L0vcJ0Xfhg7PPKtoSchdI7ejzW0nZpWSknDmCLMLsFo8"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                ShopABC shopabc = createShopABC(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = shopabc.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(shopabc, null);
                        validateShopABC(contraints, shopabc);
                        failureCount++;
                        break;
                    case 2:
                        shopabc.setPkone(contraints.getNegativeValue().toString());
                        validateShopABC(contraints, shopabc);
                        failureCount++;
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
