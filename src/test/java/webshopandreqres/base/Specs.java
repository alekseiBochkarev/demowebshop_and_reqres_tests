package webshopandreqres.base;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class Specs {
    /******* ENV VARIABLES ***********/
    public static String workingHost = "https://reqres.in";

    public static RequestSpecification requestSpec = with()
            .baseUri(workingHost)
            .basePath("/api")
            .log().all()
            .contentType(ContentType.JSON);

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();

    public static ResponseSpecification responseSpecForCreate = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .build();

    public static ResponseSpecification responseSpecForNotFound = new ResponseSpecBuilder()
            .expectStatusCode(404)
            .build();
}
