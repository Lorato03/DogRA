package tests;

import Utils.Constants;
import Utils.Helpers;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PostCategoryTest {
    RequestSpecification reqSpec = null;
    JSONObject obj = null;
    ResponseSpecification success = null;

    @BeforeEach
    public void initialObject(){
        reqSpec = Helpers.getReqSpec();
        success = Helpers.Success();


        obj = new JSONObject();
        obj.put("id", 8);
        obj.put("name", "jerseys");


    }
    @Test
    @Story("POST Request")
    @Severity(SeverityLevel.NORMAL)
    public void testThatIcanAddaCategory(){
        given().when()
                .spec(reqSpec)
                .body(obj.toJSONString())
                .post(Constants.URL)
                .then()
                .spec(success);

    }
}
