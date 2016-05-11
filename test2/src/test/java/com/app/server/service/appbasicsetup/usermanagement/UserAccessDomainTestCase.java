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
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessDomainRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessDomain;
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
public class UserAccessDomainTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

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

    private UserAccessDomain createUserAccessDomain(Boolean isSave) throws Exception {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainName("AiDAAke8eL3pDq4RDvHoDJFYKvGwKGPRemScET6AorAKgc4adK");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainDescription("8K3uI6DejYZ9C5OuOLpkhnvvFRmy8iSAo5E3RhFI8b569YgvPE");
        useraccessdomain.setDomainIcon("mddNASITnWZF8ftcqq2kEyQj85r2qsmK05l4XIXscIlqLywvFY");
        useraccessdomain.setDomainHelp("uR6LcZM9QrPutRbySC5FN19p4jUq4iAjqfCiLyYQeiFxGaGPAT");
        useraccessdomain.setEntityValidator(entityValidator);
        return useraccessdomain;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessDomain useraccessdomain = createUserAccessDomain(true);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccessdomain.isValid();
            useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            UserAccessDomain useraccessdomain = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
            useraccessdomain.setDomainName("OGLjjpJ4UUJgSJUIi052vCUJL2JW1rZuZHnPJGYxbFl6CEwKP0");
            useraccessdomain.setUserAccessDomain(83505);
            useraccessdomain.setDomainDescription("c2QfXoH0KEFOoc63QUwSzQ63xVT8R6QCPDJlVmXOrI8b3L0LTs");
            useraccessdomain.setDomainIcon("rRVSu5oemCAMtR7NnoyvkRxGD5zfOZkZb0TdZ6ibmYjmHk459t");
            useraccessdomain.setDomainHelp("6L4LfrYG26CabCBbr4gxUJwYgqFutCeAOXGjmTomC0cnJo7RXf");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccessdomainRepository.update(useraccessdomain);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessDomain(EntityTestCriteria contraints, UserAccessDomain useraccessdomain) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccessdomainRepository.save(useraccessdomain);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessDomain", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 192422));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "xf1pRWOT3cnk27v0bygG9NcyUblaJVKumqFPuaFxz8Zs0g3P9FLIw98MoFLx8C441hcLQ3NcjNydqvqaVDVmEV5HQgCB4M3ZmDn6LT7rDqTRH37wQCzB6NKfW2glh601D1zoYaQcCmzZg0zo2T4Cn9XoFGDKMEEUCQSrTwIlJ6XOKo665hPrirepcxP0r99JFEfbJBDQ6m9JkDQphZUPC0Zp9oCUxaHw6UfW8GaO6rdqUfXKuUzN4uB5NoolFlLlf"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "9wMTDxc8qLAxaio5lWL5MMULbRDGF4hgqkXNeQWwoGoN9av3S9k9vSHr4XLHLwihCopBDyeP6f09O3nm6ovJipFeEQKTJbMYaDCkWYuZMLp8bNYHkuYnYlpWixqNrPyWE9oHzgI8JOMN1Lvb2zcQnKkBxYc2YZwltiPlLCKf2MdoFLvGsouOKn29UoZLpGqWeDYrwpXWiF7QRrnxLKpIbAvLXmT78cPTevbUeC464dTCYixEDzrQSdFr7CDHWNR3a"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "4Z7k2RtyFJD4SLJXq0QoElGGMPr2120xmZIJJt88WW2YWUvJnkjpwTTm3YJv1FR3ypaNiMFZJwqKyHFevAgrZoO19JHISSaoJq4YVudvXWYU2WLqNt03cZX3WNpcFG8fOsOQVnNvUTKSaJOWAYxahg9CEYVyv9dNv4conYFJqwy61i99q4Ppac90CnpKMdQw4BPupF27Ame6hfjboixDqHeOF8TEyEPkyyXZN7jaSWoNQ0R6z33XWpD7wg2t5kqMe"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        UserAccessDomain useraccessdomainUnique = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessDomain useraccessdomain = createUserAccessDomain(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccessdomain.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 2:
                        useraccessdomain.setUserAccessDomain(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 4:
                        useraccessdomain.setDomainName(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 6:
                        useraccessdomain.setDomainDescription(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 7:
                        useraccessdomain.setDomainHelp(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 8:
                        useraccessdomain.setDomainIcon(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 9:
                        useraccessdomain.setUserAccessDomain(useraccessdomainUnique.getUserAccessDomain());
                        validateUserAccessDomain(contraints, useraccessdomain);
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
