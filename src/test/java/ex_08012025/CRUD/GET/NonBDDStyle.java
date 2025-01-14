package ex_08012025.CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyle {
    static RequestSpecification Rs = RestAssured.given();
    public static void main(String[] args) {
        Rs.baseUri("https://api.zippopotam.us");
        test1();
        test2();
        test3();
    }
    private static void test1(){
        Rs.basePath("/IN/500039");
        Rs.when().get();
        Rs.then().log().all().statusCode(200);
    }
    private static void test2(){
        Rs.basePath("/IN/515001");
        Rs.when().get();
        Rs.then().log().all().statusCode(200);
    }
    private static void test3(){
        Rs.basePath("/IN/500036");
        Rs.when().get();
        Rs.then().log().all().statusCode(200);
    }
}
