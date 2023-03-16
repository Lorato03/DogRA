package Utils;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Helpers {

    //Response spec
    public static ResponseSpecification SUCCESS(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
    public static ResponseSpecification Success(){
        return new ResponseSpecBuilder()
                .expectStatusCode(405)
                .build();
    }
    //favourites
    public static RequestSpecification getReqSpec(){
        return new RequestSpecBuilder()
                .addHeader("x-api-key",Constants.APIkey)
                .setContentType(ContentType.JSON)
                .setBaseUri(Constants.URL)
                .setBasePath("favourites/")
                .build()
                .filter(new AllureRestAssured());


    }
    //votes
    public static RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder()
                .addHeader("x-api-key",Constants.APIkey)
                .setContentType("application/json")
                .setAccept("application/json")
                .setBaseUri(Constants.URL)
                .setBasePath("votes/")
                .build()
                .filter(new AllureRestAssured());
    }

    // categories
    public static RequestSpecification getReqSpecification(){
        return new RequestSpecBuilder()
                .addHeader("x-api-key",Constants.APIkey)
                .setContentType("application/json")
                .setAccept("application/json")
                .setBaseUri(Constants.URL)
                .setBasePath("categories/")
                .build()
                .filter(new AllureRestAssured());
    }
    //breed
    public static RequestSpecification getRequestSpecifications(){
        return new RequestSpecBuilder()
                .addHeader("x-api-key",Constants.APIkey)
                .setContentType("application/json")
                .setAccept("application/json")
                .setBaseUri(Constants.URL)
                .setBasePath("breeds/")
                .build()
                .filter(new AllureRestAssured());
    }

}
