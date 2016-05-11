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
import com.app.server.repository.appbasicsetup.userrolemanagement.RolesRepository;
import com.app.shared.appbasicsetup.userrolemanagement.Roles;
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
import com.app.shared.appbasicsetup.userrolemanagement.RoleMenuBridge;
import com.app.shared.appbasicsetup.userrolemanagement.AppMenus;
import com.app.server.repository.appbasicsetup.userrolemanagement.AppMenusRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RolesTestCase extends EntityTestCriteria {

    @Autowired
    private RolesRepository<Roles> rolesRepository;

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

    private Roles createRoles(Boolean isSave) throws Exception {
        Roles roles = new Roles();
        roles.setRoleDescription("SsCXs1fxDJjZaeMF6HBnf9cu2vWsGnSaDChS8ZldBJ7PGnfJws");
        roles.setRoleIcon("ZfLDVQWl5Rz6cT4BM3r1Qn2kgJ2TjhVD4RlLCAqcjj7PTzv2vH");
        roles.setRoleName("WCmCv2KmsowZfAsCKyhrVEm5RzX0reatG0954XxHyQWJqdoBVJ");
        roles.setRoleHelp("ISBxTigoSDCjI7JCpELDCwD8R3m29ZQcoSqRRT4nkGbqx1LoRU");
        java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
        RoleMenuBridge rolemenubridge = new RoleMenuBridge();
        rolemenubridge.setIsWrite(true);
        AppMenus appmenus = new AppMenus();
        appmenus.setAppId("IUtxYGZvzGZUalngH46imlvzgWeyUZL51Ajz6SItstLCgzYwiI");
        appmenus.setMenuLabel("sxdvU5vFWl5yPj5dZj5LT7WQbI1NKHtrx6hbFDBfs3uzh5JrZV");
        appmenus.setAppType(1);
        appmenus.setAutoSave(true);
        appmenus.setMenuDisplay(true);
        appmenus.setRefObjectId("c0o7txtJI5SAAtKg7KOFKY78bLzps6SpMpN19Ey3vNL4Et4iur");
        appmenus.setMenuAction("B3U0TM9AsoI1e2zMxE0aRmgmh5hbvP1zIYXQrchkgTJUnxRe5m");
        appmenus.setMenuTreeId("MVspCTV7LeJf9Ic8DjWZeuzerIue1R53yEEp65BoHMLU68xMBN");
        appmenus.setMenuCommands("c1dBFvI300Rh4cIfuujsVAf2ZqcyrD8ToyAGcaC4LgZZcqcYTJ");
        appmenus.setMenuIcon("C3o2XUYb4QgIWugl66zkfbGqzzM9zvUdngs4s7DHTWksXQFvVq");
        appmenus.setUiType("ZLC");
        appmenus.setMenuHead(true);
        appmenus.setMenuAccessRights(8);
        AppMenus AppMenusTest = new AppMenus();
        if (isSave) {
            AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        }
        rolemenubridge.setIsWrite(true);
        rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setIsRead(true);
        rolemenubridge.setRoles(roles);
        listOfRoleMenuBridge.add(rolemenubridge);
        roles.addAllRoleMenuBridge(listOfRoleMenuBridge);
        roles.setEntityValidator(entityValidator);
        return roles;
    }

    @Test
    public void test1Save() {
        try {
            Roles roles = createRoles(true);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            roles.isValid();
            rolesRepository.save(roles);
            map.put("RolesPrimaryKey", roles._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            Roles roles = rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
            roles.setRoleDescription("1QzT4SfhjIq9U4f4K2B0WKwZs1Een2BvHcnOEzmcm38WTDTjBy");
            roles.setVersionId(1);
            roles.setRoleIcon("0c0Mf02WJKcqieJVAcq6xrzCqpUkiMaCOTjSGT8JV9MrO6p60d");
            roles.setRoleName("mDTNjmrtDa1lrn5lZqINd6KOm29xrnFCNaStW2tKa9QQWwEL6k");
            roles.setRoleHelp("x3ZkEadPW7x7z2aem3AFzkGEWRfBudfPExZFguvXRvrRPHw7GM");
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            rolesRepository.update(roles);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey")); /* Deleting refrenced data */
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateRoles(EntityTestCriteria contraints, Roles roles) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            roles.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            roles.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            roles.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            rolesRepository.save(roles);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "RoleName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "ZhKbqBkFaR4Zgp1g5Zx6VuEH3AseUyuafp2DpUMGnieVYoczRVpHPc4xebAizMEEgXFZS5s4Qa8QzAoO5JPMVSBw9uVh0QS8Sf8ETuUg4k9xkp4HbQU325HSiKnEspU6LhSBM69As1alnF893wGvSVSZ4Cq4u9wt3fxUylHRARrqz2AOyIXt1jmK2BiYqRRFu046GjHbLzWp79jUcR6Lil73oWobPBv0GwaWZem8B4CfQ2vX2T2E8kbufMVD9XsOU"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "RoleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "roleDescription", "krJxkfiU3Y0V3uJQdZnMOL1Nu92R76aULpx9YR3EN0xrhdN6kVn3Y49OyuLZv6FT1P6Zy1GwTHvVON6rBlmcFXmUUlVIqvGxLiKqqXBcVSAUouVv1acAdDszkHX6MphzE0LWyLJhEJ1Tzg4Rt3NuWlAt91GLdHlh9Fg8mUYxvtZspsTK4o6JrNaOf3Sq5t7tfCuT91yCzO0VUIyoAnBdgSsuZbgFETtJxKvWD0okdIZl2u4LwbY71s5F6eDErKfdg"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "roleIcon", "KSK4Dm6nptq6ZizvrMdUTxnDVR6cUXHiE3KYcu2khFqmGhSBgkEVIkqFcMUzuLpgM"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "roleHelp", "P3xU45J60BUTbWbineQBV208nCaMCNnjf0kMPPD12C8A83bVr8Hju1TrgKlYqbnAC4SgX01rPb8sgNJMn9HyjGmpbdn9aPDI143yWMr8q6lFWO8Km4AISbHKst6GsfZleXs7PK4ueSbuEnb7qK2v6jWcxcAfaFyd5DEzseZ0GIuoYL0tI2L1erOruvVKlHmwpND0LZ1tSlMdfE3tZNzpxBD6baFqLqXPmj2K94rSzMlvtzA8yMzwJIxEqE4T4YqF0"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Roles roles = createRoles(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = roles.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 2:
                        roles.setRoleName(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 4:
                        roles.setRoleDescription(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 5:
                        roles.setRoleIcon(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 6:
                        roles.setRoleHelp(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
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
