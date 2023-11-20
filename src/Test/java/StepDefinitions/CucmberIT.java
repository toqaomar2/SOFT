package StepDefinitions;

import com.app.customer.SpringJdbcTemplate2OracleApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberContextConfiguration
@SpringBootTest(classes = {SpringJdbcTemplate2OracleApplication.class,
                                  CucmberIT.class},
                                  webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberOptions(features = "C://Users//PC//Desktop//SoftPro//src//Test//resources//features" ,
        glue = "StepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports" })


public class CucmberIT {
}