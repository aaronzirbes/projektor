/*
 * This file is generated by jOOQ.
 */
package projektor.database.generated;


import javax.annotation.processing.Generated;

import projektor.database.generated.tables.ResultsProcessing;
import projektor.database.generated.tables.TestCase;
import projektor.database.generated.tables.TestFailure;
import projektor.database.generated.tables.TestRun;
import projektor.database.generated.tables.TestRunAttachment;
import projektor.database.generated.tables.TestRunSystemAttributes;
import projektor.database.generated.tables.TestSuite;
import projektor.database.generated.tables.TestSuiteGroup;


/**
 * Convenience access to all tables in public
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.results_processing</code>.
     */
    public static final ResultsProcessing RESULTS_PROCESSING = ResultsProcessing.RESULTS_PROCESSING;

    /**
     * The table <code>public.test_case</code>.
     */
    public static final TestCase TEST_CASE = TestCase.TEST_CASE;

    /**
     * The table <code>public.test_failure</code>.
     */
    public static final TestFailure TEST_FAILURE = TestFailure.TEST_FAILURE;

    /**
     * The table <code>public.test_run</code>.
     */
    public static final TestRun TEST_RUN = TestRun.TEST_RUN;

    /**
     * The table <code>public.test_run_attachment</code>.
     */
    public static final TestRunAttachment TEST_RUN_ATTACHMENT = TestRunAttachment.TEST_RUN_ATTACHMENT;

    /**
     * The table <code>public.test_run_system_attributes</code>.
     */
    public static final TestRunSystemAttributes TEST_RUN_SYSTEM_ATTRIBUTES = TestRunSystemAttributes.TEST_RUN_SYSTEM_ATTRIBUTES;

    /**
     * The table <code>public.test_suite</code>.
     */
    public static final TestSuite TEST_SUITE = TestSuite.TEST_SUITE;

    /**
     * The table <code>public.test_suite_group</code>.
     */
    public static final TestSuiteGroup TEST_SUITE_GROUP = TestSuiteGroup.TEST_SUITE_GROUP;
}
