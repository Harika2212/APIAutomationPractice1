package TestNGexamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNg008 {

    @Test(alwaysRun = true)
    public void test01(){
        Assert.assertTrue(false);
    }

    @Test(enabled = false)
    public void test02(){
        Assert.assertTrue(true);
    }

    @Test
    public void test03(){
        Assert.assertTrue(true);
    }

}
