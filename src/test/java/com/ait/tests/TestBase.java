package com.ait.tests;

import com.ait.phonebook.fwd.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

     static ApplicationManager app = new ApplicationManager();
    Logger logger = LoggerFactory.getLogger(TestBase.class);
    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

    @BeforeMethod
    public void startTest(Method m, Object[] p){
        logger.info("Start test" + m.getName() +"with data: "+ Arrays.asList(p));
    }
    @AfterMethod
    public void stopTest(ITestResult result){
        if(result.isSuccess()){
            logger.info("PASSED: test method  " + result.getMethod().getMethodName() );
        }
        else{
            logger.error("FAILED: Test method " + result.getMethod().getMethodName() );
        }
        logger.info("==============================================");

    }

}
