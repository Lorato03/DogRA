package tests;
import Utils.Helpers;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class DelVotesTest {
    RequestSpecification reqSpec = null;
    ResponseSpecification success = null;

    @BeforeEach
    public void initialObject(){
        reqSpec = Helpers.getReqSpec();

    }
    @Test
    @Story("DELETE Request")
    @Severity(SeverityLevel.NORMAL)
    public void testThatIcanDeleteaVoteById(){
        given().when()
                .spec(reqSpec)
                .basePath("votes/" + "426")
                .delete()
                .then()
                .assertThat()
                .statusCode(400);


    }
}
