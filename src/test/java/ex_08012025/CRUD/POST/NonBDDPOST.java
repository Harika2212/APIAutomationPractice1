package ex_08012025.CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class NonBDDPOST {
    public static void main(String[] args) {

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

        ValidatableResponse Vr = response.then();


    }


}
