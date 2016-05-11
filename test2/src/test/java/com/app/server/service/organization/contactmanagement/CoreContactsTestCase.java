package com.app.server.service.organization.contactmanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organization.contactmanagement.CoreContactsRepository;
import com.app.shared.organization.contactmanagement.CoreContacts;
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
import com.app.shared.organization.locationmanagement.Timezone;
import com.app.server.repository.organization.locationmanagement.TimezoneRepository;
import com.app.shared.organization.contactmanagement.Title;
import com.app.server.repository.organization.contactmanagement.TitleRepository;
import com.app.shared.organization.contactmanagement.Gender;
import com.app.server.repository.organization.contactmanagement.GenderRepository;
import com.app.shared.organization.locationmanagement.Language;
import com.app.server.repository.organization.locationmanagement.LanguageRepository;
import com.app.shared.organization.contactmanagement.CommunicationData;
import com.app.shared.organization.contactmanagement.CommunicationType;
import com.app.server.repository.organization.contactmanagement.CommunicationTypeRepository;
import com.app.shared.organization.contactmanagement.CommunicationGroup;
import com.app.server.repository.organization.contactmanagement.CommunicationGroupRepository;
import com.app.shared.organization.locationmanagement.Address;
import com.app.server.repository.organization.locationmanagement.AddressRepository;
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.locationmanagement.AddressType;
import com.app.server.repository.organization.locationmanagement.AddressTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase extends EntityTestCriteria {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    private CoreContacts createCoreContacts(Boolean isSave) throws Exception {
        Timezone timezone = new Timezone();
        timezone.setUtcdifference(4);
        timezone.setGmtLabel("OJlWDuIMLQKIaeGozAY3Esf2uZl6PBOZwxOfnbhzpdLeQjWPcB");
        timezone.setCities("oLQdMtw96wbD7bkwU4dCqCRszqhJ7vBbWycwFzMo9ynTp692eZ");
        timezone.setCountry("YwQf3hPeZegylbdXcofFVWHxboFSjnyAPWVqp4AFdB8a4kWvPv");
        timezone.setTimeZoneLabel("bSj5NzcMxbOWaqmHYrYV22L7IOmoZcJdJcsmGjg1wM9hWHUKTa");
        Title title = new Title();
        title.setTitles("o4VYys2Nwv14AGF9iBhowEzYuG6PA7vxLZifYuKInO0SVVfkun");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("nf50ZeC8SCoBycwqTsUAhkRldzbVYEwybsyCP34Wmk6mhMPKJN");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Language language = new Language();
        language.setAlpha4parentid(9);
        language.setLanguageDescription("22R9yK8MTUxoinZzhLNoRzvITpmqjUNVt8pM8K8pcxYE2nlLxR");
        language.setAlpha2("mp");
        language.setLanguageIcon("XZ7gEKnXDvEztP5eI0XFzZrwUpHuRug0gpFyrPph7i6REk8dMR");
        language.setAlpha4("gdW8");
        language.setLanguageType("Bir8ZvT0L01XGN0BQvavaKKFs29JCCnw");
        language.setLanguage("vu1mSzBZlb17I1VjK096Q0Il1lCd9jwF1JXTBjbCcSWUDFULMo");
        language.setAlpha3("jlh");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setLastName("3qMZn5FfmPtPLp1z77YcNeUcDhrN6iXsxcbQvNKsgKsku8FvC9");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setAge(38);
        corecontacts.setFirstName("Yn28V0gs9jp8A31b2HJoZGwjtt2v3qCISkDlzkkBI4bqwxLjw2");
        corecontacts.setNativeTitle("WzhSHTgPwJpAAzJ7WM9e2B6QDTvJjXeHVdUf8hRFcREhjekhdh");
        corecontacts.setEmailId("Mq27DYwwX0g5YzpBTxJTHh8KXtJ9YSSTimtBn8riwD3qDgac07");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setMiddleName("vN0R2JiGBEzhss8CFCgICVu7cPnIgt7rmA079B4ya2uvGAWfGM");
        corecontacts.setNativeMiddleName("3Nx53vUb2vbirbT7K25IVQ4uOi5TYQCe3WipnKzXn9g06X0ftT");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1462963818450l));
        corecontacts.setPhoneNumber("wlBCr48flNlpCsw50InF");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1462963818450l));
        corecontacts.setNativeLastName("jAvr4dqBRh2VOtatXH3pfeh3f7mZiwnn4ijzC31AU6C4UOpI2g");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("y8tufQbChP4phU1MAkG9tZ3mR0TYanRkgC9nEiwuNGUHX1fcP6");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("D9vFWuonuMUrLGNMHK64BvkwFbkzcoB1HlCoyMSfC992qHJYlH");
        communicationtype.setCommTypeDescription("fnmSf1RKGHB1jwhVGeojj6tbxlNzNmqdHGzmc3yemQ2LK8bHxO");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("PFJsq33ySJl7yoIxJlqhGKT6inwTThavM9hsMfsUirCqva1QsN");
        communicationgroup.setCommGroupName("blq637Jsi9ueaf7UrbJjZ97flICRijr6l51blnQfjsYNZcvodr");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeName("svUCAW3lEeueKpQgNrZU7ITgFEYD5Jn2OXw3IZ15sXzV1G0SJm");
        communicationtype.setCommTypeDescription("vzRkfaJegkwBY9JFKVRITWtWvjxI3k5o8K2sYpzyC3ls4A8iz9");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("U4pwWGoYdc");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setLatitude("JFjA8xA48GoOdm6UNZshl5fZlt0Lygp5YLAxgu3iR2ABWiIVp8");
        address.setLongitude("tMsluaaSO2Npr1SHZGr7NwPHe9brH46kQmGvzd4bbvmyH2eKkK");
        City city = new City();
        city.setCityDescription("5z1g8DMopzBCNlbnDZEhNd1W6kjwNWW8zRquWnWrnj4lzshmpG");
        city.setCityCode(2);
        Country country = new Country();
        country.setCurrencyCode("yL3");
        country.setCapital("vBttuWW1IvMalj0prreYcE6AbvBR6W6Q");
        country.setCurrencySymbol("AFebXyEZwnsDtl31FPmMBnvD8cohRWD7");
        country.setCountryFlag("1GX3Vlmn1Fqk7nCcYobYNNUh1PKmwoXRDBE5oXcKwwoRgjfzXX");
        country.setCountryName("jaxqtOlUPM94TQSXQKW6B3Z1COlXL7GUKFNK0FzGuL37RWE92w");
        country.setCapitalLatitude(8);
        country.setCurrencyName("SA6kTxCbYizwHKOezpRotRB6CioTwbO36BTDd1jXLxm4yI6NM6");
        country.setCountryCode2("B82");
        country.setCapitalLongitude(7);
        country.setCountryCode1("Kr9");
        country.setIsoNumeric(644);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapital("1e9bPAmX6ZQ6nP0EfNGxtg2QKAnQngy6fdqZRhVsUNtZLRhoaP");
        state.setStateName("aCEHKR5U1bTLLnOtIXecgWQHwYL251RIVoLALvs3q8sdNl9Nfh");
        state.setStateCodeChar3("Afx19xZv9GayAWRLlODfiqMNbcsc5QdX");
        state.setStateCapitalLatitude(7);
        state.setStateFlag("xI8q22AbWjVsJVSkNnbxgKmY8GNH4M6CH03posjZP5Xpqcw7F8");
        state.setStateCode(2);
        state.setStateDescription("FroVStS1ICKD2Ry565B6PXHwkMz5KoAY7EymsZZXQmgYyHHE8h");
        state.setStateCodeChar2("15iFaOYljpqizfArLJQrIc0I2uazJ5bs");
        state.setStateCapitalLongitude(2);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityDescription("qGTPrUdWLAWAxIGZYp8nV6jpT6nQ5KWGGsnc7YGgYw79peztDG");
        city.setCityCode(2);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("WFL1RDTaeMQOToZZEWAa6fcCJJ9m7KI1IvP2k4l650UVaSMFic");
        city.setCityLatitude(4);
        city.setCityFlag("4PK7hsJ6x0QM262INDLA5jQJpghYWthNKclCSdjx5JiJpKk8yB");
        city.setCityCodeChar2("RtO5HssSCCDJ1BGTnZMbQSYJKgMyU6qK");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(3);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("qz9zEC8HLsmystfea7S8mAnMNu16vRvTykrcaDGZ01roaVpPdJ");
        addresstype.setAddressType("5mYJLXFll4lzrLC5dPBZJdjFwNXva0THTB176Gpu7DkLRv00fo");
        addresstype.setAddressTypeDesc("CDT1YF6oqLfHEX2t4jU0NDoOBaPW8KVoYgadQuDL0ybTxCP3KF");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setLatitude("iSz8JDZYWLwrpPhiWugZo2cebsMVbdv13oz9q3L0cvJAueL6i5");
        address.setLongitude("tHUGHVhEP9muHXzg0TRfoiEW9h4ryQe43mVtfnJGqTwAfMmZ43");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("428VMcJDLCbGJH3JUzg3szYc4ms78GuDzADyJq2XntUKQGiqGo");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("gRgYrBUXSTmFauoP9p67M3IWYmeIA8R5uHya1dHfWSN6GP13vs");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("hL4g8caY01cMDNnH1WH609gdMd2nbuXGvVQkilSg0jnyGZHTWj");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        address.setAddressLabel("9aCkOVBlTQX");
        address.setZipcode("RMOTYK");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        corecontacts.setEntityValidator(entityValidator);
        return corecontacts;
    }

    @Test
    public void test1Save() {
        try {
            CoreContacts corecontacts = createCoreContacts(true);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setLastName("v65SENSmKCcXwSUeqUzM3YHO1M6U7l3Gi958dzdAQERWwsn3xL");
            corecontacts.setAge(102);
            corecontacts.setFirstName("nvvdoHm1N4S1V2ytKsJM05gVR3CrXbV3QnrlqZfijUR3A674uf");
            corecontacts.setNativeTitle("fT9FQEdP72WDRJogqAJl2W2YAjaa2eKtYIecwZkmgtHlv6eC43");
            corecontacts.setEmailId("MLPwrkWWk3uWF8rny3qREzRjyRJ3beEnmpOhjHeWqcNM1gjC8X");
            corecontacts.setMiddleName("2umJD8rrzH7bkXdTlOWtBpY3BpOHh38BYWqE62lKHajw1qlfZH");
            corecontacts.setNativeMiddleName("xcuPqEggXpUgpBSexN7fFZJ7JrraLiP9uBVykdsG1isszNR1YV");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1462963818873l));
            corecontacts.setPhoneNumber("wXvnzQORrQJvvD6TZgAo");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1462963818890l));
            corecontacts.setNativeLastName("k3CSzZaTNn1cOtHIoxJr2unhEsDdikqQXYZH4RHUnv59KnaMw2");
            corecontacts.setVersionId(1);
            corecontacts.setNativeFirstName("AZDSagq3x930Trb4CH7Y8MBSG5hjSXq90mp6Xk5pCiXwmaN0py");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCoreContacts(EntityTestCriteria contraints, CoreContacts corecontacts) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            corecontactsRepository.save(corecontacts);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "firstName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "OuWn4f2UW5VLcjNFZhuBQmtlv9m7a3Kio2ReE7vbonYJUOPv6NfqN5SCVCCcig0npijFZ9rlCG2e1bLI16vMbdpWMbp3qsmteMjApd8Y74nuxVEYda3EMLkAbbBIUrZ3mkCHaAPl65HLBkHz3R66yMwRzgxS28iBkIGxSBzvlf1da9Y08RrsJWWNOC186irpG0jft1RG7gV0651jdEJCZeDM0ezIMPXSmZgqHRZXS2NRZF3KLzUQ4xpn40MiWQWZ3"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "D1mIPf1V4umrqNCOiw9IkW8VXU2cwhRQubHsAlaAA1vY9GgTLbIugPR02caaEbK49EzRZkpWKQR8hSZHN1d0Xn02YIpuRkFuDGTLvxNVBDUrS7OrgO0VuzWNsUIg4RpKewI1hx1witWh5UBFTehdfTQLMBN2CUGstZVJ3tMpLauStlAtVKqQytf33mXSBFxdSHK8OV2L7dCVnb8OqksdtGraDtbmMcLSdU7e3FR9ufovMfO8AolQNxXxCku06ZV4f"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "JaolnG8mvxYY7X9A1la066YcM2tiKzlKOL8xsKhWm5lWsumSKVS2ViO2DRBxGBIFhj0UDIFE1ibHyhsC5lITLkEwG7dJQ8EBrhM2tVRz1XoOcrPkopcxrbntDn1ncpKkTIb6y9hcR8fINeiU34mxFldUalWiUtgElI81O65nSr875rbA9MYtg1dA2RyZitcSPpwkE9ou6HrmmxV93psQnU1qmQBJSjPqYjsC1A6Quw2QXWX91GqZ4RaS6KZiy64mE"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "lCtcXLtESde5q62Npi9RuzHu9irHjSuhWMsDK4dYDEjYv044Y2zXA7RTSwpCcmYF5"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "SkiqzwHGBZzN05X6vPZ49eBz3T5KFoKQlKEGZw2VWzgkJG8FUmNA3aP4TkU6S1RrmNA7DFxq3Ik46trpVskjyIdgeWB2Ttfgpc83iemsQXAL9MsBtPFTSSFvXUsBiqJKZLgdDLmh538dcf2vapeJsO8XXCne4EkXSvvAXkVnLJ56ggWjVozk3wWeYEhP5RWx4nYk9pcNSTd8WHC7i7tBOMebTsgXkOT3IxEAII5tdAa93x66O6n7Z3DmTQbtVRQzQ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "O99lAoVCbh44cz4FpH2zrl1MBDGXmtBz0zN35WIQZVN3SdX3mSFHeWbFHiuGZyvhn31z77Mr9lAUFE46mIagWEoAzVXX2cA6WeqgMGt6ZBUszn10v5i9tiSdes1dhtlEE0t3yL9Gypy6HPUTepa9TBcYi697XnttfBmq1mLXvWSXfeAHsoUy83KNoQ7Q6ysHPTRmUnBl3z1dPkDOw6zAfGsQ6VTHYqwsksqXlMjARFA5PsF8t3mtEMbXkuEBypfvd"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "AcwcTggIa4dNNJefxKzp2N6nTxDJ2Qwzu5dv84noYML8xjEReDndV0ziKjCRl84E55Bu1Iry0gQUo93pDWMHxlEhr3BNgSPOZxj6KU3HqqoqpgrFeyhTK4PlXxDJqsy6WmupBaaDjx3XccpXYnRM3RiBURYVFcpEMNNLwGg1qqu8fpVC0abyjRAyloraLCjfdodYYwmrLeWxNYA2IqJuMotjp1EMzqLMfSPQRPbUvgC13bjhmb6u4qqTUn0yOfFtz"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 230));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "iOsVeLI6QV4xWQNnMD3RfrkivJneS25VEZSpLfvblGtBX7MUg1yczhziJYataHtUjdSJFtyTOunps4nndm7slWj3AiKSN02TWRmxlBXMbVcYodaVyQKhybXB1MDWFlJaQ8GT2XrIvAXtuC0BWm2bmFWvkZgXqlfAPVt385UqQLLkEBoFihYVbyV6aYLLlZKceCHd375ljJ8RSE12mcomTAyW2IqB79RYXewXlFHxhaqPGRqww6heOLgvmsvFnHlQd"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "KOIzbGx0bOBUpxdIoGZ3h"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CoreContacts corecontacts = createCoreContacts(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = corecontacts.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 2:
                        corecontacts.setFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 3:
                        corecontacts.setMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 5:
                        corecontacts.setLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 6:
                        corecontacts.setNativeTitle(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 7:
                        corecontacts.setNativeFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 8:
                        corecontacts.setNativeMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 9:
                        corecontacts.setNativeLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 10:
                        corecontacts.setAge(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 11:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 12:
                        corecontacts.setEmailId(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 13:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 14:
                        corecontacts.setPhoneNumber(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
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
