package TestNGexamples;

import org.testng.annotations.Test;

public class TestNG002 {

    String token;
    Integer bookingID;

    public String getToken(){
        token = "123";
        return token;
    }

    public void getTokenAndbookingID(){
        token = getToken();
        bookingID = 123;
    }

    @Test
    public void testPUTReq(){
        System.out.println(token);
        System.out.println(bookingID);
    }

    @Test
    public void testPUTReq2(){
        System.out.println(token);
        System.out.println(bookingID);
    }

    @Test
    public void testPUTReq3(){
        System.out.println(token);
        System.out.println(bookingID);
    }


}
