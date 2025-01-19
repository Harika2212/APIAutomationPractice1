package TestNGexamples.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import static org.assertj.core.api.Assertions.*;
import org.testng.annotations.Test;

public class TestNg011_Assertions {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;

    String token;
    Integer bookingid;

    @Test
    public void test_post(){



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

        //bookingid = response.jsonPath().getString("bookingid");

//        validatableResponse.body("booking.firstname", Matchers.equalTo("Harika"));
//        validatableResponse.body("booking.lastname", Matchers.equalTo("Mullagura"));
//        validatableResponse.body("booking.depositpaid", Matchers.equalTo(false));
//        validatableResponse.body("bookingid", Matchers.notNullValue());

        bookingid = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("Harika");

//        Assert.assertNotNull(bookingid);
//        Assert.assertEquals(firstname,"Harika");

        assertThat(bookingid).isNotNull();
        assertThat(firstname).isEqualTo("Harika").isNotEmpty().isNotBlank();





    }

}
