package TestNGexamples;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG003 {

    @BeforeTest
    public void getToken(){
        System.out.println("1");
    }

    @BeforeTest
    public void getbookingID(){
        System.out.println("2");
    }

    @Test
    public void t3(){
        System.out.println("3");
    }

}
