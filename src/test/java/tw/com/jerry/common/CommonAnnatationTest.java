package tw.com.jerry.common;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootApplication
public class CommonAnnatationTest {
    @Before
    public void before() {
        log.info("before");
    }

    @After
    public void after() {
        log.info("after");
    }

    @BeforeClass
    public static void beforeClass() {
        log.info("beforeClass");
    }

    @AfterClass
    public static void afterClass() {
        log.info("afterClass");
    }

    @Test
    public void test_a() {
        log.info("test_a");
    }

    @Ignore("废弃方法")
    @Test
    public void test_ignore() {
        log.info("ignore");
    }

    @Test(timeout = 1)
    public void test_timeout() {
        Integer count = 0;
        do {
            count++;
        } while (count > 0);
    }
}