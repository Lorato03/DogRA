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

public class PostFavouritesTest {
    RequestSpecification reqSpec = null;
    JSONObject obj = null;
    JSONObject obj2 = null;
    ResponseSpecification success = null;

    @BeforeEach
    public void initialObject(){
        reqSpec = Helpers.getReqSpec();
        success = Helpers.SUCCESS();


        obj = new JSONObject();
        obj.put("image_id", "9ccXTANkbb");
        obj.put("sub_id", "my-user1236");

        obj2 = new JSONObject();
        obj2.put("image_id", "8ccXTANkbb");

    }

    @Test
    @Story("POST Request")
    @Severity(SeverityLevel.NORMAL)
    public void testThatIcanAddaFavourite(){
        given().when()
                .spec(reqSpec)
                .body(obj.toJSONString())
                .post(Constants.URL)
                .then()
                .assertThat().statusCode(200)
                .spec(success);

    }
    @Test
    @Story("POST Request")
    @Severity(SeverityLevel.NORMAL)
    public void testThatIcanAddaFavouriteWithoutSub_id(){
        given().when()
                .spec(reqSpec)
                .body(obj2.toJSONString())
                .post(Constants.URL)
                .then()
                .assertThat().statusCode(405)
                .spec(Helpers.Success());

    }

}

