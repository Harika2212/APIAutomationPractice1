package ex_08012025.CRUD.GET;

import io.restassured.RestAssured;

public class BDDStyleGET {

    public static void main(String[] args) {

        RestAssured.given()
                        .baseUri("https://api.zippopotam.us")
                        .basePath("/IN/500039")
                    .when()
                         .log().all().get().
                     then()
                         .log().all().statusCode(200);

    }

}
