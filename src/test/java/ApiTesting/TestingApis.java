package ApiTesting;


import ApiTesting.POJO.DeckBean;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestingApis {

    DeckBean deckBean = new DeckBean();

    //creating new deck of cards
    @Test (priority = 1)
    public void gettingNewDeck(){
        Response response = get(" https://deckofcardsapi.com/api/deck/new/");
        int statusCode = response.getStatusCode();
        JsonPath jsonPathEvaluator = response.jsonPath();
        String responseId = jsonPathEvaluator.get("deck_id");
        deckBean.setDeckId(responseId);
        int remaining = jsonPathEvaluator.get("remaining");
        Assert.assertEquals(statusCode, 200); //checking status code
        Assert.assertEquals(remaining,52); //checking total cards
    }

    //Support adding Jokers with a POST
    @Test (priority = 2)
    public void addingJockers(){
       Response response = given().
                        queryParam("jokers_enabled", true).
                        when().
                        get("https://deckofcardsapi.com/api/deck/new/").
                        then().
                        contentType(ContentType.JSON).
                        body("remaining",equalTo(54)).// checking total no. of cards
                        extract().
                        response();
       int statusCode = response.getStatusCode();
       Assert.assertEquals(statusCode,200);
    }

    //Drawing two cards from already creatsed deck
    @Test (priority = 3)
    public void drawingCard(){
        Response response = get(    "https://deckofcardsapi.com/api/deck/"+deckBean.getDeckId()+"/draw/?count=2");
        String responseData = response.asString();
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200); //Checking status code

        Assert.assertTrue(responseData.contains("remaining")); //Checking if response body contains a specific field

        JsonPath jsonPathEvaluator = response.jsonPath();
        String responseId = jsonPathEvaluator.get("deck_id");
        Assert.assertTrue(responseId.equalsIgnoreCase(deckBean.getDeckId()));// Checking if the specific JSON element is equal to expected value
    }
}

