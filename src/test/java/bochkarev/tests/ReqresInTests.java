package bochkarev.tests;

import bochkarev.model.ListUser;
import bochkarev.model.User;
import bochkarev.model.UserData;
import io.qameta.allure.AllureId;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static bochkarev.base.Specs.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ReqresInTests {

    @Test
    @AllureId("11732")
    @Story("with lombok")
    void listUsersTest() {
        String path = "/users/8",
                expectedEmail = "lindsay.ferguson@reqres.in",
                expectedName = "Lindsay",
                expectedLastName = "Ferguson",
                expectedUserAvatar = "https://reqres.in/img/faces/8-image.jpg";
        int listUserId = Integer.valueOf(8);
        ListUser data = given()
                .spec(requestSpec)
                .when()
                .get(path)
                .then()
                .spec(responseSpec)
                .log().body()
                .extract().as(ListUser.class);

        assertEquals(listUserId, data.getListUserData().getIdList());
        assertEquals(expectedEmail, data.getListUserData().getEmailList());
        assertEquals(expectedName, data.getListUserData().getFirstNameList());
        assertEquals(expectedLastName, data.getListUserData().getLastNameList());
        assertEquals(expectedUserAvatar, data.getListUserData().getAvatarList());
    }

    @Test
    @AllureId("11733")
    @Story("with groovy")
    void listUsersWithGroovyTest() {
        String path = "/users?page=2",
                expectedEmail = "lindsay.ferguson@reqres.in";
        given()
                .spec(requestSpec)
                .when()
                .get(path)
                .then()
                .log().body()
                .body("data.findAll{it.email =~/.*?@reqres.in/}.email.flatten()",
                        hasItem(expectedEmail));
    }

    @Test
    @AllureId("11734")
    void singleUserTest() {
        String path = "/users/2";
        given()
                .spec(requestSpec)
                .when()
                .get(path)
                .then()
                .spec(responseSpec)
                .log().body();
    }

    @Test
    @AllureId("11735")
    void singleUserWithModel() {
        String path = "/users/2";
        UserData data = given()
                .spec(requestSpec)
                .when()
                .get(path)
                .then()
                .spec(responseSpec)
                .log().body()
                .extract().as(UserData.class);
        assertEquals("2", data.getUser().getId());
    }

    @Test
    @AllureId("11736")
    void singleUserNotFoundTest() {
        String path = "/users/23";
        given()
                .spec(requestSpec)
                .when()
                .get(path)
                .then()
                .spec(responseSpecForNotFound)
                .log().body();
    }

    @Test
    @AllureId("11737")
    void createTest() {
        String name = "morpheus";
        String job = "leader";
        String path = "/users";
        HashMap bodyParams = new HashMap();
        bodyParams.put("name", name);
        bodyParams.put("job", job);
        User data = given()
                .spec(requestSpec)
                .body(bodyParams)
                .when()
                .post(path)
                .then()
                .spec(responseSpecForCreate)
                .log().body()
                .extract().as(User.class);

        assertNotEquals(null, data.getId());
        assertEquals(name, data.getName());
        assertEquals(job, data.getJob());
        assertNotEquals(null, data.getCreatedAt());
    }

    @Test
    @AllureId("11738")
    void updateTest() {
        String name = "morpheus";
        String job = "zion resident test new man";
        String path = "/users/2";
        HashMap bodyParams = new HashMap();
        bodyParams.put("name", name);
        bodyParams.put("job", job);
        User data = given()
                .spec(requestSpec)
                .body(bodyParams)
                .when()
                .put(path)
                .then()
                .spec(responseSpec)
                .log().body()
                .extract().as(User.class);
        assertEquals(name, data.getName());
        assertEquals(job, data.getJob());
    }
}
