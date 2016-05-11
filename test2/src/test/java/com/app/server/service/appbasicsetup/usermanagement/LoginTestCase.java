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
import com.app.server.repository.appbasicsetup.usermanagement.LoginRepository;
import com.app.shared.appbasicsetup.usermanagement.Login;
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
import com.app.shared.organization.contactmanagement.CoreContacts;
import com.app.server.repository.organization.contactmanagement.CoreContactsRepository;
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
import com.app.shared.appbasicsetup.usermanagement.User;
import com.app.server.repository.appbasicsetup.usermanagement.UserRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessDomain;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessDomainRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessLevel;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessLevelRepository;
import com.app.shared.appbasicsetup.usermanagement.PassRecovery;
import com.app.shared.appbasicsetup.usermanagement.Question;
import com.app.server.repository.appbasicsetup.usermanagement.QuestionRepository;
import com.app.shared.appbasicsetup.usermanagement.UserData;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase extends EntityTestCriteria {

    @Autowired
    private LoginRepository<Login> loginRepository;

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

    private Login createLogin(Boolean isSave) throws Exception {
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setLastName("cJVzqegXKjY8pzjvsxmmDHsiPwIJ2NxgueL5ZcToUkE7i7lpGz");
        Timezone timezone = new Timezone();
        timezone.setUtcdifference(7);
        timezone.setGmtLabel("YiygvqHbv1e3aZYbupWouBvLVYGkEwJ2IDqtpKjyxf3CTbSDzt");
        timezone.setCities("mbF7KFmiMWl0rH5Fz4DACQYOJdrbqnxbOWmdjwvyvxPHq8YTBY");
        timezone.setCountry("cWLVajqvGZUznyMOscwOywdIAVxS3I93eY7lZ4G1NvUb7ylHsV");
        timezone.setTimeZoneLabel("ldnsQck3OpJbezUjMYRgY9Li5JgReGgqPh41rssJbHUTU78jgn");
        Title title = new Title();
        title.setTitles("rWcyOmhWF4FCo9qkiXHQgEwEoeZ00CzzChxwN0273llvvmDfO2");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("YC4kB6Bj1S6zH13593ba2OgzUiJhaZi8iZhv8o6dWJahgR9KZT");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Language language = new Language();
        language.setAlpha4parentid(3);
        language.setLanguageDescription("NheCJoG8MwfIxuWLz2HWafILoKvY9bqBDNIEyMel6OO96WqGtY");
        language.setAlpha2("DG");
        language.setLanguageIcon("FzjpZoaM9nE8vdIVUOdp0qp4CKz8GF8vgnq9hfPNnJX8yTi8Hf");
        language.setAlpha4("h6rz");
        language.setLanguageType("eWQqc6VRtj9PvDF8wZVUaBr77BmQFlkM");
        language.setLanguage("UtTJAsSwwc16dRezV8raaZVFSIppe9BFZWFifsFOsUY1f5AeM4");
        language.setAlpha3("VQr");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        corecontacts.setLastName("VnPIlyax6FroXsxP5Ull1ChnEmcEBdtDEGkhKQusDEC2wMzDz5");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setAge(90);
        corecontacts.setFirstName("oBfjp4C1IvXwc2RrHZrm6NftOgRCbqbQuHTiNfFUSgJ5db9zMJ");
        corecontacts.setNativeTitle("IeiXb5SxfPGMQ5sBCnfnPkaNpgJPhB7q3Bhx1rSz0YszuFgNJD");
        corecontacts.setEmailId("wGUrpWzGQooCRnzQnwtWYIMIkXnqPVZNPn8EkEElZh6Q6BME3o");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setMiddleName("Z3teEaaMR90CRzheeYRRZ6kEhQHdBavSLM390S8iS5TxCM2VjJ");
        corecontacts.setNativeMiddleName("ImEnc6bdgazAnVxxUQxdH8jFFisdBoUylWALH2PoY5CFofzTGm");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1462963825173l));
        corecontacts.setPhoneNumber("xSEyJ8gIddHixmulqGSg");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1462963825173l));
        corecontacts.setNativeLastName("K1OccZ4WJ3lQe8suTYc2OHePZw74uRVFBjuXQOMQHZnA8D1OHJ");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("7lIXrZ341jcwNvjFNrgZVmthLzppucBL8sMkj40PweqUO14tWU");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeName("E10LPkTBmOvi01u3kI6SM8Kqb9d8kUNdIxIjZPBsGDtCWEyBRI");
        communicationtype.setCommTypeDescription("YnVSLe39iOnupHIE78mwBFzA4FQ5KV6e4Vf0iSSUGouDZT6suO");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("4bBqMpnGZqlZRGBivkky9YtzuVE2w0ZIvXgr2YHZAZiGmFnMlH");
        communicationgroup.setCommGroupName("cc7CX2SWwNfLuOcfotUwGJA0N8mwexROXMiNdFtMDjhsGeRqxC");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeName("ZCJFn1YFlUpS44iUnIFwKHg8QMpEMpyVX3VdLw9nHDuWrC0ivQ");
        communicationtype.setCommTypeDescription("QjXZwiUSSlhS8XZ3GlRga4r9Q0U9hlGPNEHoa4AmRs5pMiFOK8");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("WhP7rt8gHe");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setLatitude("O8OIuCaWFZeW3sDSaxrQTL442He1723c6RJdXAKJC9Zv2jLN2I");
        address.setLongitude("Q79pCGjpwh55LRp92bnE6dFQ6pdSYLC4ZTB4UxF6jrq7G9NWkT");
        City city = new City();
        city.setCityDescription("qLNq4p5A9WqrDpEAUiNKKpI1kLhdL5ErypDzYQobh624CEt02T");
        city.setCityCode(1);
        Country country = new Country();
        country.setCurrencyCode("0It");
        country.setCapital("Nv6avGTc9at123ymJFhXeNlt1BbcLatJ");
        country.setCurrencySymbol("BK8iLGEnibBUmqpn2QXq1aj3dmUUAcs6");
        country.setCountryFlag("Qa6gUrBDFyjKKVPs7WWEUsTXvOT0vZR5I2W3Z3orhRGIGc10hW");
        country.setCountryName("rEIlyTYtbOZguADFZbr6ViUNCvlfFKr93Z5YQEZKv0JaKm3L0S");
        country.setCapitalLatitude(3);
        country.setCurrencyName("6DOTvR8i8OxcPoZudx1pruB8gR8UIBieUS7QFtvRBCZDdWQiO2");
        country.setCountryCode2("m2N");
        country.setCapitalLongitude(8);
        country.setCountryCode1("mT3");
        country.setIsoNumeric(225);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapital("vdbuK8DbhOUOtEl9qNE7aF3Nkx9kZQWDSfmwWO496QFmbUdvSv");
        state.setStateName("Xk0O8oMxo3Kyu0KWdKra8DbpUdc5sulqBoOl9BUSsgdvlAIwWL");
        state.setStateCodeChar3("7tZMjOVz2aCW3EEbPN5nzXTzOJfxwq3H");
        state.setStateCapitalLatitude(6);
        state.setStateFlag("IHKGjj66dlFxu8tLcymZiiAu2BWgqPxGuKsmxRYwz2p0f7u436");
        state.setStateCode(2);
        state.setStateDescription("7esPgFZ664DD4amwtuxFYOaRalOwUKoisBxfYDvb5PUXEe9sJi");
        state.setStateCodeChar2("emJIkokTKkAg2iNBXHTaYaNNXoIcxE02");
        state.setStateCapitalLongitude(6);
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityDescription("P5qMWRFu5bdmHKyj6Fcp2PMlqgdidd649y2xEvN9lKvkdwpj0T");
        city.setCityCode(3);
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("8quOuwNQqZg2kM6mcXGSFd3fFEU7EAcHNgV3DMi2LZ8gwn95DR");
        city.setCityLatitude(7);
        city.setCityFlag("OwITKKJNJ3pzRCbZZPvMJ9JCP8Ic2QHt4qpXiJwBAoYojOGBba");
        city.setCityCodeChar2("whdyeW48DwcxpLuLDytUkaa1CSENmE9L");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityLongitude(7);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("k4BeEb0uo49JrVFDd9KiHkuBwfkTM78p94MV5yYXHXY9Qpk3Wj");
        addresstype.setAddressType("FkMuPckPi07CeFqe8UqIpL2I3wYlEPuRzEh5gBujAjjiRmhXVs");
        addresstype.setAddressTypeDesc("szhmvh3ydGz3hHJUuv73uv9jiqALuHEPpgvGg9k3A0yq3tVOmB");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setLatitude("L8m3t0Ps6qBFMYZZfl5RK6jREPU6L5l0O35GbigDL0VQ3zvACt");
        address.setLongitude("ttK7HAOxwtyJIyyd25Ny8CDSn3F0G4AOVSB9FLyLPDWE3rJLJp");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("Lwd0nuxL2b7SleuaHNOOO1ko3rmYmuaMl6zwvc9Tg0AaqjtfEY");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("muf04F1cfInnLLk3xeE2qwXUgMAfcB4PCTMwi1nd3mRx1R8PVo");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("nvwfdkvRMXs6zaEavVlgVrqIXcDgGHuQt3PivFxN6wofD4unMf");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("0KCrD53oAkf");
        address.setZipcode("9kRm2q");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        User user = new User();
        user.setSessionTimeout(1271);
        user.setIsDeleted(1);
        user.setIsLocked(1);
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainName("dd2x1BB16h9dQY8AeushVo3yJFmvB8Taz8SwinOUlMEeVS5gEm");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainDescription("EgWbXr0ZLHmhvF2W7sh9d4khVDaROdzmeCS0UMuRVXGgLVkbc6");
        useraccessdomain.setDomainIcon("YMo3vKCOgWPqVA1IWLAxGHxNNI2sJTr5W1zxX9QayUBrCuqfkL");
        useraccessdomain.setDomainHelp("zwE3KxIkeb5ur1EPqLI1VMClASscq9HQdeo0hwYJ77ui2UKhZz");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("2wAIcjndFhiZA8KMEWqI9u4kkIr98Igm2Uj2oWEOQATfJ7tNEj");
        useraccesslevel.setLevelDescription("XEZ8pEwdN5OstbtWmYcDqcTRVW1AvUCfgQ7hJc1iLG07qUwqVF");
        useraccesslevel.setLevelName("GXPAFZZ9IHkA7Jeh1fM7K82q2WXTaoH54pP99GP8A4svUN5uPG");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelIcon("374dFCHxWv97zR5R614O4GaCPB0JIK33YlRx6lPugaEEn3iz19");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setSessionTimeout(2413);
        user.setIsDeleted(1);
        user.setIsLocked(1);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setGenTempOneTimePassword(1);
        user.setPasswordExpiryDate(new java.sql.Timestamp(1462963825553l));
        user.setChangePasswordNextLogin(1);
        user.setMultiFactorAuthEnabled(1);
        user.setPasswordAlgo("cvXle46CGQRHoz6At7SDmEvoBVDX1eM7KbGb8JzTcq6UNgSiFI");
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1462963825553l));
        user.setUserAccessCode(11933);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setAllowMultipleLogin(1);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestionDetails("464RnjPcTc");
        question.setQuestionIcon("VqKV0hSXc7hKDM28Pam6X7GXlxh1VocmcXukSW0lgJsSsZ8iZ9");
        question.setQuestion("kKSOXOEH36l28mKEfyFPne04gbI5okcWYbWBQvMKDAZRghUqM8");
        question.setLevelid(1);
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setUser(user);
        passrecovery.setAnswer("HM7FsYKSSsowyHz9OVElkqdooHA8puFRg766G0Hv6uqlYwr6U4");
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePasswordExpiry(5);
        userdata.setOneTimePassword("e1UD3XKwCHcyC2yBKfYRP6ApGPhYqdDG");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1462963825735l));
        userdata.setPassword("lN1J72OhWpxjGhquhpqSAr4Br4ZW3R6s1T0pSIIHl26lyO2yWs");
        userdata.setOneTimePasswordExpiry(8);
        userdata.setOneTimePassword("E33EPsOixUgd8MH7Gu3RoI4cNHytY3eq");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1462963825755l));
        userdata.setPassword("8GrOMKg7if2ZJoi6CuxN3G8kLVZW0BTphQUz72nJmMkZJ491F7");
        userdata.setUser(user);
        userdata.setLast5Passwords("mTVVwREiM8UiiSmttJIEvpgBSmQyJw1U9VgcM97dVPBJgsMGLB");
        user.setUserData(userdata);
        Login login = new Login();
        login.setLoginId("hvY0IcEi26XPbiOlNVcC6LYK0lI56yw8rUFPpH4YTJyyQW3bQj");
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setServerAuthText("4sX0NxHk0Dsn8Wbf");
        login.setServerAuthImage("BqnBxCHlTq7gRR69UkpJCZIyRV1SGOdC");
        login.setFailedLoginAttempts(5);
        login.setIsAuthenticated(true);
        user.setUserId(null);
        login.setUser(user);
        login.setEntityValidator(entityValidator);
        return login;
    }

    @Test
    public void test1Save() {
        try {
            Login login = createLogin(true);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setLoginId("ID3ZJ1xHlviYnv6MV9TdhJbKkvGD4O59bReAxmn2Fb98Yadngh");
            login.setServerAuthText("c9TdEPimj78mq7P3");
            login.setServerAuthImage("ijfh6LBBlzQszYXQQ5mk4igNfD6b0cr5");
            login.setFailedLoginAttempts(10);
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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

    private void validateLogin(EntityTestCriteria contraints, Login login) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            login.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            login.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            login.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            loginRepository.save(login);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "loginId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "aa8KiplP1kaPAHr3QOEbYuhNlWHEeRYanteQwGgKIEXYDSOqo1fPMu0iKYxYAiFpERYBSfvyuu41hWCZXxqn9WAZ9iEWobva4TvehIoSG3TD0IiCbwiIQ0yIn3WVkEjtyNlDKv1PDj9EmiQduOARPHuRMZq94QEU6iFLc5rHIE3tCOm26bR2478sVyvjJW9lXzchadfRu"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "E5XKzIZx534SBjdBTiJBykKEc62wzM4XW"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "NZWJvGwYJzjtD4TXv"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 21));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "isAuthenticated", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Login login = createLogin(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = login.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(login, null);
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 2:
                        login.setLoginId(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 3:
                        login.setServerAuthImage(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 4:
                        login.setServerAuthText(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 5:
                        login.setFailedLoginAttempts(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 6:
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
