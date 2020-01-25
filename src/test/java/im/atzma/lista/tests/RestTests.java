package im.atzma.lista.tests;

import com.google.gson.JsonObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.apache.http.HttpHost;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.ssl.SSLContextBuilder;
import org.testng.annotations.Test;

import static io.restassured.config.EncoderConfig.encoderConfig;
import static io.restassured.config.RedirectConfig.redirectConfig;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;


public class RestTests {

    @Test
    public void testLogin() throws IOException, UnirestException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {

        baseURI = "https://lista.atzma.im";
        RestAssured.config = config().redirect(redirectConfig().followRedirects(true).and().maxRedirects(10)).and().
                and().config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));
        RestAssured.useRelaxedHTTPSValidation();

       Response response = given().
//                redirects().max(12).and().redirects().follow(true).
                header("Content-Type", "application/x-www-form-urlencoded").
                header("user-agent","alpalch-qpEzhaOvY0Ecb4e0").
                formParam("time_zone","Asia/Jerusalem").
                formParam(  "email","katalon@gmail.com").
                formParam( "pass","Pa$$w@rd").
                when().
                post("/check-login").
                then().
                assertThat().statusCode(201).extract().response();


//        Map<String, Object> jsonAsMap = new HashMap<>();
//        jsonAsMap.put("map", "TestCategory");

//        given().
//                header("content-type", "application/x-www-form-urlencoded").
//                header("Cookie", "7b7a53e239400a13bd6be6c91c4f6c4e=FDCEB8319563CE43893D28C0432F7F3E038B83F5DB84FB208FEF401AF540A6C4; Path=/; Expires=Sat, 01 Feb 2020 14:39:56 GMT; HttpOnly").
//                header("user-agent","alpalch-qpEzhaOvY0Ecb4e0").
//                formParam("name", "TestCategory").
//                when().
//                post("/catalog/services/categories").
//                then().
//                assertThat().
//                statusCode(201);



    }

}
