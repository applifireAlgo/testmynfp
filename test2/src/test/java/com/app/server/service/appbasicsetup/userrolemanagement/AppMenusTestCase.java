package com.app.server.service.appbasicsetup.userrolemanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appbasicsetup.userrolemanagement.AppMenusRepository;
import com.app.shared.appbasicsetup.userrolemanagement.AppMenus;
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
public class AppMenusTestCase extends EntityTestCriteria {

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

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

    private AppMenus createAppMenus(Boolean isSave) throws Exception {
        AppMenus appmenus = new AppMenus();
        appmenus.setAppId("QoosgK61JgOGr5KUso0p0C3iHvoVsvsD3avDryFOpJbiS2TQeW");
        appmenus.setMenuLabel("BZZoClAx2eShTpxEou192JaKZVUaMm58TDtrTyfP5AGkj34A1T");
        appmenus.setAppType(2);
        appmenus.setAutoSave(true);
        appmenus.setMenuDisplay(true);
        appmenus.setRefObjectId("zbrWoci0utQt8BiRPd5A3MyBvQFntLfXww3uaF9oBkhGjHnrzO");
        appmenus.setMenuAction("OzEdOgDCFQimB4z4sf9INkeZptNoxb4r6fJDvWRrlCH9zNDjmJ");
        appmenus.setMenuTreeId("JEsEWgbaj0q5U2jS4I1I3tEVil5i8yOLpYnjWtvLHhh73YymC7");
        appmenus.setMenuCommands("RMYgHk6l68YzS3h3DV6O2pROQBUsSs3HYTogk32qXM8iKBZLeN");
        appmenus.setMenuIcon("ujweF98hflD9fxCuYhpmtvI0lyiGDzGwT2DuvvwMu2dNomGxH6");
        appmenus.setUiType("dnK");
        appmenus.setMenuHead(true);
        appmenus.setMenuAccessRights(2);
        appmenus.setEntityValidator(entityValidator);
        return appmenus;
    }

    @Test
    public void test1Save() {
        try {
            AppMenus appmenus = createAppMenus(true);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.isValid();
            appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setAppId("TbPIQsEnm2sjaGYlPiTMbD2T0nqS3iP7s7upa2XJjxNhhUypU8");
            appmenus.setMenuLabel("qyFeyn4zCCY0IYHH6zLHNzJr37NFID9Fg3Ai3a3Wzmpww5ZAFU");
            appmenus.setAppType(2);
            appmenus.setRefObjectId("5jvhFVaYxrB37gPgcf00Mxr5Fn0FtCW5R25DVKCuFfzysHql4F");
            appmenus.setMenuAction("McsRozmHYB2ne4ZCTt66hcU5gCJP2geLaRjEi0p6dTocN4EuEp");
            appmenus.setMenuTreeId("vnHX4I9YrZum38ajyrlfZJFAyaKQF7aNCs66rawkIzrLYwoGe3");
            appmenus.setMenuCommands("pcvCYWvqSzonVZLwMJdjjT653brXsmey2dou6lcM9CBN2WFzPE");
            appmenus.setMenuIcon("hK8z28Y1gKVsTgnX66lWgYwsEJnm2pBrhK6emzNbOpAe6eYYom");
            appmenus.setVersionId(1);
            appmenus.setUiType("YVu");
            appmenus.setMenuAccessRights(4);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAppMenus(EntityTestCriteria contraints, AppMenus appmenus) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            appmenusRepository.save(appmenus);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "menuTreeId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "FgILv0y59lmw5tgnaNgLm6QIPT32SvZ4rNX5usybkDWgrTrkyvb7CZhtXDVGSF2tDaicqPZiNTuhpRXbjIjoOvVAehr1Tama6SDKCRbhqid8hXkFzCkmSMnkbP1NLmDIYHZUnQs2jf2nRdMZEl0fKDBHlS7X6o1OAaqKPB4PEES8wKVE0ay5LoDYddO888wQysFfqTcafOL9jgzhzjF9pLBfPH3AjwPzB2QIKTvPGCgyQHkNzCA3bn7S1XztZsuKa"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "AyxCDyTQzA3XiwfYVQBs8B1spFuolQm52dmAuaqFuyGthPvSyzOqi5SBFB55zj4WAcYUzBlkTogIow4I3t7rXrm9khUvgHEmZlT2Ix98e33oN9Lu2p4F2v3cd6PDjRXEjdX89Y3nYj5cNzyJCACZbUWSfr44MB4QghSMyRAV8nP1NsOsCxDlcqGfH5xnruAxHKS5FT4FNWKLSLXRlM0RSSW4lyCAX9ir7ZLp7Kc6CbAwCYTgq0FLZgnWLxuk2s9A9"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "NPevzxw9nendFrGvmHxwVbEEjrly4Eaq7vDdEmChAmkDII8ydNnJbf7gxLpYwljsd9jFDMNPlOyvBGo5jnW2ZER5z79uy0VMh5qxuNXdAj7CeUtUXDMfmfabRCqE41sq2fGLW2gyGXd5LpCfXoLwkvuR8eaYLRYhUlDOBgFckxxF4qRuYWyghYyMTa9b2cdAxkqIOgzyD4s5JsUKvahANjTl7gkx31s5eQUTR1MXjVWsqY41BZgCGH2ExM1QWvdqh"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "1f84tX31Fdpp34bZuSqeFQQIDctFNtbFRtstLFUIeiNBlI7FO4uXIPgZzoAzWnABD"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "fC3Wi0P5zECX1KwRjcFXfiAKQMcBBMu9n2YFOxw6faHSY9oUIfcMq1fWyDDigE1W3n39iVRXsOaKvkKnzDLabkV7w6wIoX3nKk83b7bOcUAViSTg65Vc7vctSqsOl3mFpx5wvHnG05lCig837xguV3lKxKhWt9Er8OLC5f8jydJrcWhKG7heZV0VKkJL8UX1rb0WBCNGHayN05dc2qILbwWe3qC9EZrkViTxLby0WHoN30bb3HZ1UYh1ihqRUiNit"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "qyXj"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "y3IvZ7pWUYDTNx9ZWaFgNp1bhwXbn8LhYtvC3XMXDsIHtI4N3cOyUxH6un57UXyluhvTSInkDD8mWJPiloFQ7Kmj9M30HJHT3OXrzsn8VsaCT2mYl1Fy42CO1gPo6ex3vWPVrNL4R0gHh1corgqMPrU7p9FdmWxJC01BSNcUBJG4h65BSuKn65KZ3sT8r7u2uUI5EsRodlAnFBRHnmG24k8dcDnahVUiixcLeyIFafyiLcE8pvKfV7vSK3kV4CiiA"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 12));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 4));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "Huw7K0oLehG9BvFFgUQTqvZQ9rb6qxp35vB96edTJ7AVLcbHA00XC5dBUqseeIRHGBO7ZS78LWorWp4h7e09xJ1UNAVx7Qef1ONkNpHRhYCDplfSWQxlKa2mbGTzhVHAdtBbRNvd7dvS2DDgB4egddInZU6e9K5ybsNkNoGuglFGgN2HzXqk7wMVGPe4VuKIIvlJjRsFfR13TB2d4TxjBolzF3CbOMnzVuh8fpZ3PLJ445QHfsCY3wBubX7ouNNMD"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 18, "autoSave", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 19, "autoSave", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                AppMenus appmenus = createAppMenus(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = appmenus.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 2:
                        appmenus.setMenuTreeId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 3:
                        appmenus.setMenuIcon(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 4:
                        appmenus.setMenuAction(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 5:
                        appmenus.setMenuCommands(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 7:
                        break;
                    case 8:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 9:
                        break;
                    case 10:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 11:
                        appmenus.setMenuLabel(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 12:
                        appmenus.setUiType(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 13:
                        appmenus.setRefObjectId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 14:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 15:
                        appmenus.setMenuAccessRights(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 16:
                        appmenus.setAppType(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 17:
                        appmenus.setAppId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 18:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 19:
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
