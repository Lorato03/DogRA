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

public class GetFavouritesTest {
 RequestSpecification reqSpec = null;
         ResponseSpecification success = null;

@BeforeEach
public void initialObject(){
        reqSpec = Helpers.getReqSpec();
        success = Helpers.SUCCESS();


        }
    @Test
    @Story("GET Request")
    @Severity(SeverityLevel.NORMAL)
    public void testThatIcanGetaFavouriteById(){
        given().when()
                .spec(reqSpec)
                .basePath("favourites/" + "4")
                .get()
                .then()
                .spec(success);

    }

}
