package ex_08012025.CRUD.TestNg;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Test004 {

    @Test
    public void Test_GET(){

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/500039")
                .when()
                .log().all().get().
                then()
                .log().all().statusCode(200);

    }

}
