package com.app.server.service.organization.locationmanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.locationmanagement.State;
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
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class StateTestCase extends EntityTestCriteria {

    @Autowired
    private StateRepository<State> stateRepository;

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

    private State createState(Boolean isSave) throws Exception {
        Country country = new Country();
        country.setCurrencyCode("H5o");
        country.setCapital("f18c4OsbCqqJLcYr2S5xkLbMziEntZql");
        country.setCurrencySymbol("qSrzYbrhGO8XGzP9ds16bOmAAaxjyWG0");
        country.setCountryFlag("hskvyfwD4DbwOXUOUZqdK5O6rGEAXvCTgFJGUiCUjhKyvGW9RD");
        country.setCountryName("ZY8miRPsziIJnzqLEysnB66myLdSLHrGjNB5d2x8GPeMp8C0s1");
        country.setCapitalLatitude(4);
        country.setCurrencyName("c8COs0gFoAg3D2fq8YysmTL8Q6hV0NzjlLV0mlvkbtoIWCnhk6");
        country.setCountryCode2("7w2");
        country.setCapitalLongitude(1);
        country.setCountryCode1("eRF");
        country.setIsoNumeric(867);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateCapital("Vm8S4o3YrC3HohfFAA16Z9vwsqaFEVKh8SHyRZaSfjD93WG6IB");
        state.setStateName("mFEZp9L1MSyqaezlbczcIrm6mVTROKGa6II3BELBIYGge6Ru4F");
        state.setStateCodeChar3("ADGjJ85G2A8Xn69IXz7DbId7SjiSvzAZ");
        state.setStateCapitalLatitude(5);
        state.setStateFlag("u0vlPCYxCv7oCSTQH7RcALASKnOimbO2ZOrPgdApFdOzx042Co");
        state.setStateCode(1);
        state.setStateDescription("gewkZfzqxzTjT9BZk0nDRZQrhkNgRbaqMxqCbX90fOotmNSTo2");
        state.setStateCodeChar2("LcCeprQ9DrKGwcZiYUSqutY9ybs4JNf0");
        state.setStateCapitalLongitude(7);
        state.setEntityValidator(entityValidator);
        return state;
    }

    @Test
    public void test1Save() {
        try {
            State state = createState(true);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            state.isValid();
            stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            State state = stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
            state.setStateCapital("fjE1kVl19IIyuSQYBgfBs7DY5ABOCdWkUgDdHDzjqvDdasj9JD");
            state.setStateName("Nx10CbvbROjzlOMAjS4yQhS3UaDv4w2NMXoYHkM6jLFz2mYG4r");
            state.setStateCodeChar3("I7ihaFIvCxeyLj4C3hUJKS1yn7SFxe8s");
            state.setVersionId(1);
            state.setStateCapitalLatitude(3);
            state.setStateFlag("5I4S0PHdbtVBO0Zhuds2s5Rlnbjz27qmtDQ9upg9lOjlUgTxlb");
            state.setStateCode(1);
            state.setStateDescription("xCw3vpGQyBeXbRCRcSZOWuWA7yRJvBEVBw1kc8m2X1XSsueJt9");
            state.setStateCodeChar2("ThUHkNX26UIK1FtEMKfWpby2OnF5CZlU");
            state.setStateCapitalLongitude(2);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<State> listofcountryId = stateRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateState(EntityTestCriteria contraints, State state) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            state.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            state.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            state.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            stateRepository.save(state);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "stateName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "VAmU5HnL4I5jqkFhCzxU2mG401NPY5q0vSayGTW3Nhi5GpoajBwIrZhW2vNaqfd9eUcfhE6ZgPA7jeuP06RYrc3aHdHNcaISTyNiMavkORikBrvJFot7d22I8zmb2NfNIaDA7th24OVeBdzmU82sWCOmqbBvEKufcPE6QCvwzFHubKykTIb6ZO6LdvV6p5kSeI9cM3NomyiKRohxzdxQSCChw9mpFNvw5LkP1u1lPp4mhcMtEOw1oloDQ6i5GGdnG"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 3));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "LTAKEo3J6grHrOkiRtMH8v0r0FIruxzzI"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "WQy6iRXfI9TdLKSQTN7528EAqVZuNUrz6"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "TGQ0zEEOQBMPlFyr1O8XsMRDwMpJMET8XXwQB9CjTInfxbepMr0Xnq16GnbUhWoHznLmvi3M3ksJGWWz3YRx7ZRaBEqc3JfH2veWPck9DxqLc4p5KVLomUH2sTPnYruXDxZYZAKlyxrNvs0WCwJQgy31lWXKY9THd70xHbXxJmTm11zeR3MRvRhZzaIzAf7gcgSJdSvaRLT6uPmTkJGl3gDTSTquwMxjOtxfNKntK2DtFEOCVrxLE632Ltg5thh4K"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "Od1jdOGhfaOOls2nXVtV2aoDOs3Jf4Tj2lfXmNOEkvxqYsy7qFjtxDgpGGV1p7McxT0O6MB8XQSynNeK9UqsLn1Kkh6XZqpn078IQVgxNJC0GUH5mMoP3QK5Y62TCG65j"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "BrQZZsoiyZfy1upU3dIsoX7Yfs5JRztTjjAzjXvISrAtwH1mULLlqG3cuFqwZ1Y1XJTlx4F9yR7OEF1iIndHiacypbJ6qlSVsPNaD8uv2jaG2xFG9ksYPTrQj4oxoJrjk"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 21));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 12));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                State state = createState(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = state.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 2:
                        state.setStateName(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 3:
                        state.setStateCode(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 5:
                        state.setStateCodeChar2(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 6:
                        state.setStateCodeChar3(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 7:
                        state.setStateDescription(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 8:
                        state.setStateFlag(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 9:
                        state.setStateCapital(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 10:
                        state.setStateCapitalLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 11:
                        state.setStateCapitalLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
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
