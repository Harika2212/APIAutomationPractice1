package TestNGexamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG005 {

    @Test(groups = {"sanity","qa", "preprod"})
    public void sanityrun(){
        System.out.println("Sanity");
        System.out.println("QA");
    }

    @Test(groups = {"qa","preprod"})
    public void Regrun(){
        System.out.println("Reg");
    }

    @Test(groups = {"dev", "stage"})
    public void smokerun(){
        System.out.println("Samoke");
        Assert.assertTrue(false);
    }

}
