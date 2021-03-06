/*
 * This file is generated by jOOQ.
 */
package projektor.database.generated.tables.daos;


import java.math.BigDecimal;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;

import projektor.database.generated.tables.TestCase;
import projektor.database.generated.tables.records.TestCaseRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TestCaseDao extends DAOImpl<TestCaseRecord, projektor.database.generated.tables.pojos.TestCase, Long> {

    /**
     * Create a new TestCaseDao without any configuration
     */
    public TestCaseDao() {
        super(TestCase.TEST_CASE, projektor.database.generated.tables.pojos.TestCase.class);
    }

    /**
     * Create a new TestCaseDao with an attached configuration
     */
    public TestCaseDao(Configuration configuration) {
        super(TestCase.TEST_CASE, projektor.database.generated.tables.pojos.TestCase.class, configuration);
    }

    @Override
    public Long getId(projektor.database.generated.tables.pojos.TestCase object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<projektor.database.generated.tables.pojos.TestCase> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(TestCase.TEST_CASE.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<projektor.database.generated.tables.pojos.TestCase> fetchById(Long... values) {
        return fetch(TestCase.TEST_CASE.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public projektor.database.generated.tables.pojos.TestCase fetchOneById(Long value) {
        return fetchOne(TestCase.TEST_CASE.ID, value);
    }

    /**
     * Fetch records that have <code>test_suite_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<projektor.database.generated.tables.pojos.TestCase> fetchRangeOfTestSuiteId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(TestCase.TEST_CASE.TEST_SUITE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>test_suite_id IN (values)</code>
     */
    public List<projektor.database.generated.tables.pojos.TestCase> fetchByTestSuiteId(Long... values) {
        return fetch(TestCase.TEST_CASE.TEST_SUITE_ID, values);
    }

    /**
     * Fetch records that have <code>idx BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<projektor.database.generated.tables.pojos.TestCase> fetchRangeOfIdx(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(TestCase.TEST_CASE.IDX, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>idx IN (values)</code>
     */
    public List<projektor.database.generated.tables.pojos.TestCase> fetchByIdx(Integer... values) {
        return fetch(TestCase.TEST_CASE.IDX, values);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<projektor.database.generated.tables.pojos.TestCase> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(TestCase.TEST_CASE.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<projektor.database.generated.tables.pojos.TestCase> fetchByName(String... values) {
        return fetch(TestCase.TEST_CASE.NAME, values);
    }

    /**
     * Fetch records that have <code>package_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<projektor.database.generated.tables.pojos.TestCase> fetchRangeOfPackageName(String lowerInclusive, String upperInclusive) {
        return fetchRange(TestCase.TEST_CASE.PACKAGE_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>package_name IN (values)</code>
     */
    public List<projektor.database.generated.tables.pojos.TestCase> fetchByPackageName(String... values) {
        return fetch(TestCase.TEST_CASE.PACKAGE_NAME, values);
    }

    /**
     * Fetch records that have <code>class_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<projektor.database.generated.tables.pojos.TestCase> fetchRangeOfClassName(String lowerInclusive, String upperInclusive) {
        return fetchRange(TestCase.TEST_CASE.CLASS_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>class_name IN (values)</code>
     */
    public List<projektor.database.generated.tables.pojos.TestCase> fetchByClassName(String... values) {
        return fetch(TestCase.TEST_CASE.CLASS_NAME, values);
    }

    /**
     * Fetch records that have <code>duration BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<projektor.database.generated.tables.pojos.TestCase> fetchRangeOfDuration(BigDecimal lowerInclusive, BigDecimal upperInclusive) {
        return fetchRange(TestCase.TEST_CASE.DURATION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>duration IN (values)</code>
     */
    public List<projektor.database.generated.tables.pojos.TestCase> fetchByDuration(BigDecimal... values) {
        return fetch(TestCase.TEST_CASE.DURATION, values);
    }

    /**
     * Fetch records that have <code>passed BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<projektor.database.generated.tables.pojos.TestCase> fetchRangeOfPassed(Boolean lowerInclusive, Boolean upperInclusive) {
        return fetchRange(TestCase.TEST_CASE.PASSED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>passed IN (values)</code>
     */
    public List<projektor.database.generated.tables.pojos.TestCase> fetchByPassed(Boolean... values) {
        return fetch(TestCase.TEST_CASE.PASSED, values);
    }

    /**
     * Fetch records that have <code>skipped BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<projektor.database.generated.tables.pojos.TestCase> fetchRangeOfSkipped(Boolean lowerInclusive, Boolean upperInclusive) {
        return fetchRange(TestCase.TEST_CASE.SKIPPED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>skipped IN (values)</code>
     */
    public List<projektor.database.generated.tables.pojos.TestCase> fetchBySkipped(Boolean... values) {
        return fetch(TestCase.TEST_CASE.SKIPPED, values);
    }
}
