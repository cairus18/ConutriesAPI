
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EndPointNameTests {

    private String urlBase = "https://restcountries.com/v3.1/";

    @Test(priority = 0)
    @Parameters({"nameEndPoint", "countryName", "statusCode", "expected"})
    public void Verify_GetResponse_Ok_And_Capital_Value_Retrieved_For_EndPoint_Name(String nameEndPoint, String countryName, int statusCode, String expected) {
        Response response = RestAssured.get(urlBase + nameEndPoint + countryName);

        //Phase Act
        var body = response.getBody().as(List.class);
        Map<String,Object> mapBody = (Map<String, Object>) body.get(0);

        var capital = mapBody.get("capital").toString();

        //Phase Assert
        Assert.assertEquals(response.statusCode(), statusCode, String.format("Status Code was {0} but {1} was expected", response.statusCode(), statusCode));
        Assert.assertEquals(capital.substring(1,capital.length()-1), expected, "Attempting to get Capital for a country");
    }

    @Test(priority = 1)
    @Parameters({"nameEndPoint", "countryName", "statusCode"})
    public void Verify_GetResponse_NotFound_For_EndPoint_Name(String nameEndPoint, String countryName, int statusCode) {
        //Phase Arrange
        Response response = RestAssured.get(urlBase + nameEndPoint + countryName);

        //Phase Assert
        Assert.assertEquals(response.statusCode(), statusCode, String.format("Status Code was {0} but {1} was expected", response.statusCode(), statusCode));
    }

    @Test(priority = 2)
    @Parameters({"nameEndPoint", "countryName", "statusCode", "expected"})
    public void Verify_GetResponse_Ok_And_Multiple_results_retrieved_For_EndPoint_Name(String nameEndPoint, String countryName, int statusCode, int expected) {
        //Phase Arrange
        Response response = RestAssured.get(urlBase + nameEndPoint + countryName);

        //Phase Act
        var body = response.getBody().as(List.class);
        var countriesFound = body.stream().count();

        //Phase Assert
        Assert.assertEquals(response.statusCode(), statusCode, String.format("Status Code was {0} but {1} was expected", response.statusCode(), statusCode));
        Assert.assertEquals(countriesFound, expected, String.format("Expected results were {0} but {1} was expected", countriesFound, expected));
    }

    @Test(priority = 4)
    @Parameters({"codeEndPoint", "code", "statusCode", "expected"})
    public void Verify_GetResponse_Ok_And_Capital_Value_Retrieved_For_EndPoint_Code(String codeEndPoint, String code, int statusCode, String expected) {
        Response response = RestAssured.get(urlBase + codeEndPoint + code);

        //Phase Act
        var body = response.getBody().as(List.class);
        Map<String,Object> mapBody = (Map<String, Object>) body.get(0);

        var capital = mapBody.get("capital").toString();

        //Phase Assert
        Assert.assertEquals(response.statusCode(), statusCode, String.format("Status Code was {0} but {1} was expected", response.statusCode(), statusCode));
        Assert.assertEquals(capital.substring(1,capital.length()-1), expected, String.format("Attempting to get Capital for a country with code {0}", code));
    }

    @Test(priority = 5)
    @Parameters({"codeEndPoint", "code", "statusCode", "expected"})
    public void Verify_GetResponse_Ok_And_Capital_Value_Retrieved_With_Code_In_Upper_For_EndPoint_Code(String codeEndPoint, String code, int statusCode, String expected) {
        Response response = RestAssured.get(urlBase + codeEndPoint + code);

        //Phase Act
        var body = response.getBody().as(List.class);
        Map<String,Object> mapBody = (Map<String, Object>) body.get(0);

        var capital = mapBody.get("capital").toString();

        //Phase Assert
        Assert.assertEquals(response.statusCode(), statusCode, String.format("Status Code was {0} but {1} was expected", response.statusCode(), statusCode));
        Assert.assertEquals(capital.substring(1,capital.length()-1), expected, String.format("Attempting to get Capital for a country with code {0}", code));
    }

    @Test(priority = 6)
    @Parameters({"codeEndPoint", "code", "statusCode", "expected"})
    public void Verify_GetResponse_Ok_And_Capital_Value_Retrieved_With_Code_In_Lower_For_EndPoint_Code(String codeEndPoint, String code, int statusCode, String expected) {
        Response response = RestAssured.get(urlBase + codeEndPoint + code);

        //Phase Act
        var body = response.getBody().as(List.class);
        Map<String,Object> mapBody = (Map<String, Object>) body.get(0);

        var capital = mapBody.get("capital").toString();

        //Phase Assert
        Assert.assertEquals(response.statusCode(), statusCode, String.format("Status Code was {0} but {1} was expected", response.statusCode(), statusCode));
        Assert.assertEquals(capital.substring(1,capital.length()-1), expected, String.format("Attempting to get Capital for a country with code {0}", code));
    }

    @Test(priority = 7)
    @Parameters({"codeEndPoint", "code", "statusCode", "expected"})
    public void Verify_GetResponse_Ok_And_Capital_Value_Retrieved_With_Code_Two_Letters_For_EndPoint_Code(String codeEndPoint, String code, int statusCode, String expected) {
        Response response = RestAssured.get(urlBase + codeEndPoint + code);

        //Phase Act
        var body = response.getBody().as(List.class);
        Map<String,Object> mapBody = (Map<String, Object>) body.get(0);

        var capital = mapBody.get("capital").toString();

        //Phase Assert
        Assert.assertEquals(response.statusCode(), statusCode, String.format("Status Code was {0} but {1} was expected", response.statusCode(), statusCode));
        Assert.assertEquals(capital.substring(1,capital.length()-1), expected, String.format("Attempting to get Capital for a country with code {0}", code));
    }

    @Test(priority = 8)
    @Parameters({"codeEndPoint", "code", "statusCode", "expected"})
    public void Verify_GetResponse_Ok_And_Capital_Value_Retrieved_With_Code_Digits_For_EndPoint_Code(String codeEndPoint, String code, int statusCode, String expected) {
        Response response = RestAssured.get(urlBase + codeEndPoint + code);

        //Phase Act
        var body = response.getBody().as(List.class);
        Map<String,Object> mapBody = (Map<String, Object>) body.get(0);

        var capital = mapBody.get("capital").toString();

        //Phase Assert
        Assert.assertEquals(response.statusCode(), statusCode, String.format("Status Code was {0} but {1} was expected", response.statusCode(), statusCode));
        Assert.assertEquals(capital.substring(1,capital.length()-1), expected, String.format("Attempting to get Capital for a country with code {0}", code));
    }

    //This tests is failing to me the API in this case is wrong, after sending a bad code it's returning a 200 with empty body instead of 400
    @Test(priority = 8)
    @Parameters({"codeEndPoint", "code", "statusCode"})
    public void Verify_GetResponse_NotFound_With_Bad_Code_For_EndPoint_Code(String codeEndPoint, String code, int statusCode) {
        Response response = RestAssured.get(urlBase + codeEndPoint + code);

        //Phase Assert
        Assert.assertEquals(response.statusCode(), statusCode, String.format("Status Code was {0} but {1} was expected", response.statusCode(), statusCode));
    }
}
