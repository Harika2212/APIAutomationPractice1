package TestNGexamples;

import org.testng.annotations.Test;

public class TestNG006 {

    @Test
    public void serverstartedok(){
        System.out.println("I will start first");
    }

    @Test(dependsOnMethods = "serverstartedok")
    public void method1(){
        System.out.println("method1");
    }

}
