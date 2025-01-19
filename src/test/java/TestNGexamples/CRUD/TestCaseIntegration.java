package TestNGexamples.CRUD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCaseIntegration {


    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;

    String token;
    String bookingid;

    public String getToken(){

        String payload = "{ \n" +
                "                \"username\" : \"admin\", \n" +
                "                \"password\" : \"password123\"\n" +
                "    }";

        RequestSpecification R = RestAssured.given();
        R.baseUri("https://restful-booker.herokuapp.com");
        R.basePath("/auth");
        R.contentType(ContentType.JSON).log().all();
        R.body(payload);


        Response response = R.when().post();

        ValidatableResponse Vr = response.then().log().all();

        token = response.jsonPath().getString("token");
        return token;

    }


    public String getBookingId(){

        String payloadput = "{\n" +
                "    \"firstname\" : \"Harika\",\n" +
                "    \"lastname\" : \"Mullagura\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2025-01-01\",\n" +
                "        \"checkout\" : \"2025-01-10\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payloadput).log().all();

        Response response = requestSpecification.when().post();



        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        bookingid = response.jsonPath().getString("bookingid");
        System.out.println(bookingid);
        return bookingid;

    }

    @Test
    public void test_01_update_request_put(){

        token =getToken();
        bookingid = getBookingId();

        String payloadput = "{\n" +
                "    \"firstname\" : \"Akhil\",\n" +
                "    \"lastname\" : \"Mullagura\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2025-01-01\",\n" +
                "        \"checkout\" : \"2025-01-10\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/" +bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payloadput).log().all();

        Response response = requestSpecification.when().put();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }

    @Test
    public void test_02_update_request_get(){
        token =getToken();
        bookingid = getBookingId();

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/" +bookingid).log().all();

        Response response = requestSpecification.when().get();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }

    @Test
    public void test_03_delete_booking(){
        System.out.println(token);
        System.out.println(bookingid);

    }

    @Test
    public void test_04_afterdeleete_request_get(){
        System.out.println(bookingid);

    }

}
