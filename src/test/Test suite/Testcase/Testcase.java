package Testcase;

import API_Package.API;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.updCus.*;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static Variable.Variable.*;
import static org.hamcrest.Matchers.notNullValue;

public class Testcase {
    public static String token;

    @BeforeTest
    public void init() {
        RestAssured.baseURI = Uri;
    }

    @Test(priority = 0)
    public void signIn() {
        API api1_1 = new API();
        Response res = api1_1.signIn();
        token = res.jsonPath().getString("token");
        res.then().assertThat()
                .statusCode(HttpStatus.SC_OK)
                .cookie("jwt", notNullValue());
        System.out.println(token);

    }

    @Test(priority = 1)
    public void getCus() {
        API api3_1 = new API();
        Response res = api3_1.getCus(token);
        res.then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test(priority = 2)
    public void updCus() {
        API api3_2 = new API();
        Response res = api3_2.updCus(token);
        res.then().assertThat().statusCode(HttpStatus.SC_OK);
        res.prettyPrint();
    }

    @Test(priority = 3)
    public void getTrend() {
        API api4_1 = new API();
        Response res = api4_1.getTrend(token);
        res.then().assertThat().statusCode(HttpStatus.SC_OK);
    }
}