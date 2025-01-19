package TestNGexamples;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG001 {

    @Severity(SeverityLevel.NORMAL)
    @Description("verify that true == true")
    @Test
    public void Tc_01(){

        Assert.assertEquals(true,true);

    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("verify that true != false")
    @Test
    public void Tc_02(){

        Assert.assertEquals(true,false);

    }

}
