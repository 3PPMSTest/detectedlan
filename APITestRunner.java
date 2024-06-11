package Automation;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.FilenameFilter;
import java.io.IOException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class APITestRunner {
    public static Response response = null;

    @BeforeClass
    public static void beforeClass() throws Exception {
        // TestBase.beforeClass();
    }

    @Test
    public void testParallel() {
        Results results = Runner.path("classpath:Automation")
                .outputCucumberJson(true)
                .outputJunitXml(true)
                .karateEnv("OLAH007")
                .parallel(1);
        generateReport(results.getReportDir());
        assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
    }
}
