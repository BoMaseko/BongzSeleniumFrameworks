package org.bongz.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.File;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SendCustomerChat {

    private SendCustomerChat() {}

    public static Response sendCustomerChat(File jsonFile) throws Exception {

            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> map = mapper.readValue(jsonFile, Map.class);

            Response response = given().header("Content-Type", "application/json")
                    .relaxedHTTPSValidation()
                    .log()
                    .all()
                    .body(map)
                    .post("https://scc-hybrid-chat-cim-qa.fnb.co.za/ef-chat/fnb-cme/send-message/v1");

        if (response.statusCode() == 200) {
            response.prettyPrint();
        } else {
            System.out.println("Failed to retrieve chat. Status code: " + response.statusCode());
        }

        return response;

    }

}
