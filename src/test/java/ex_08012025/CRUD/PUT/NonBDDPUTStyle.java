package ex_08012025.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.Map;

public class NonBDDPUTStyle {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;

//    public void get_token(){
//
//    }
//
//    public  get_booking_id(){
//        return bookingid;
//
//    }

    @Test
        public void test_put_postivie_tc(){

            String token = "daf09c0ff6ca2aa";
            String bookingid = "330";



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
           requestSpecification.basePath("/booking/" +bookingid);
           requestSpecification.contentType(ContentType.JSON);
           requestSpecification.cookie("token",token);
           requestSpecification.body(payloadput).log().all();

           Response response = requestSpecification.when().put();



        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


        }


}
