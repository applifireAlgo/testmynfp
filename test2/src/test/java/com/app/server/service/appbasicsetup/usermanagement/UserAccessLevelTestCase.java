package com.app.server.service.appbasicsetup.usermanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessLevelRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessLevel;
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
public class UserAccessLevelTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

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

    private UserAccessLevel createUserAccessLevel(Boolean isSave) throws Exception {
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("h1t0IdSI40XtJ13bKMlGhbTd9etqAHjwmDrsPte0Bl6AYQfbTR");
        useraccesslevel.setLevelDescription("xBiJMVDGOPXA4ayQF5sqZ2l797Zy7K4YHSiG9XcQrWkT8POoPh");
        useraccesslevel.setLevelName("UemcAxTF35RZQgyyN4ErQu2qjejSKunQg7aYR4PjnptlizJ6mh");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelIcon("VWgMZW3fWirDJZ5pABgyJWU7wP86Af4VXwoCcusHrTUJ4TwqHp");
        useraccesslevel.setEntityValidator(entityValidator);
        return useraccesslevel;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessLevel useraccesslevel = createUserAccessLevel(true);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccesslevel.isValid();
            useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            UserAccessLevel useraccesslevel = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
            useraccesslevel.setLevelHelp("egkdXjDTrbnoV2Ed0xG8PgUFdCZZY1QY7HuI5wI1aWXfehvxBp");
            useraccesslevel.setLevelDescription("QpeY2eAXn0e2AOUikonzbdXxhofWUBnFgLajAuJ26sbweyDC1A");
            useraccesslevel.setLevelName("2DCuKTBX2JVPVgWgFJIKIGw4gE1LMnHGqBWwH6aAACdxQfWQqF");
            useraccesslevel.setUserAccessLevel(99120);
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelIcon("S8rK3XIrVc1givHzQ5cbrpUjviAxaYKTHleWzLuPNVxeDYUuWG");
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccesslevelRepository.update(useraccesslevel);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessLevel(EntityTestCriteria contraints, UserAccessLevel useraccesslevel) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccesslevelRepository.save(useraccesslevel);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessLevel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 152463));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "tcUQPrPilxsVANN1RduCIPzcy4fb3SAnMD9Eosbf31JmXzmyQ3VZPZHvfN0WOH3s2z1RS6I0IQUpiRhh7iSKKSUvWyRkDguEuYZFufEd01jdw3XiOyyJC1NfwF83r8zjU3hL3l4CvQQfUlu96xcgxMmoNhMv83yJFaycgGQIXBD93IEqz0e0AWHaAXwMe09HKrV5Jbmna7k2TcE10pOkfQZPnjKak1JHPmOS3EnVtyBBnpnvtV3HD6wjgfhM9v31X"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "ulk0BdqVF7Jfk5vT1cp3c6WVcz4qQNvIX1QJ7BZ4veuwrqtm6KLUXYl1eoOsv50oADc4tesReVGiinjCLHwJO5lEqHtUnIUNQH7e74TWBPFczYFJSBnAzfaNrh4z2orZsS49Y1nLZWDXoNNpEfa19suBB7LzsTW42Uk0GNYcv9nKjXMGAkjJYNNad9TOkWfGFLzlt7E8KbeL4eiUHSwERyL9LB9ra2E7jNJ9WRcnV24syGvD81nwitpttqamE5i3Y"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "1Xgp8VBhJHnBGEYo9lYU4CZ7PTrZ4CuZu2uWfatXAUrS3TOIQblnKJD5MlLny4Ntxt2oIHXhhUAi3v66sik2aLgO7q3n2rCyTimKeIAU0IGnU03k9Fg9Jmy47THMa35caBYzKPlJtbSQsZY47P8IY8Q23IAEyT1NRl91cQm4hl8WBeLv1kspWGj4Abg9oNdRz2nZbnWQxR8fPetcs6v0qphzfFzbPUAUokatC4eH6Pwlbh5RzIhdtRHKY0CsqGtwR"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        UserAccessLevel useraccesslevelUnique = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessLevel useraccesslevel = createUserAccessLevel(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccesslevel.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 2:
                        useraccesslevel.setUserAccessLevel(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 4:
                        useraccesslevel.setLevelName(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 6:
                        useraccesslevel.setLevelDescription(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 7:
                        useraccesslevel.setLevelHelp(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 8:
                        useraccesslevel.setLevelIcon(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 9:
                        useraccesslevel.setUserAccessLevel(useraccesslevelUnique.getUserAccessLevel());
                        validateUserAccessLevel(contraints, useraccesslevel);
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
