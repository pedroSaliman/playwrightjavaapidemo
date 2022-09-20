package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ApiTest {
    Playwright play;
    APIRequestContext apicontext;
    @BeforeTest
    void before(){
        play=Playwright.create();
        apicontext=play.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL("https://reqres.in/")


        );

    }

    @Test
    void api(){

        int status=apicontext.get("api/users?page=2").status();
        String response=apicontext.get("api/users?page=2").text();
        System.out.println(response);
        Assert.assertEquals(status,200);
        JsonObject json =new Gson().fromJson(response,JsonObject.class);
        System.out.println(json.get("page"));
        Assert.assertNotNull(json.get("page"));
    }
    //////
    @Test
    void singleuser(){
        APIResponse response =apicontext.get("api/users/2");

        System.out.println(response.text());
        Assert.assertEquals(200,response.status());


    }

    @Test
    void listuser(){
        APIResponse response =apicontext.get("api/unknown");

        System.out.println(response.text());
        Assert.assertEquals(200,response.status());


    }


    ////////////////////////////////////////////////////




    @Test
    void singleresource(){
        APIResponse response =apicontext.get("api/unknown/2");

        System.out.println(response.text());
        Assert.assertEquals(200,response.status());


    }








    @Test
    void postuser(){
        APIResponse response =apicontext.post("api/users", RequestOptions.create().setData(Data.api()));

        System.out.println(response.text());
        Assert.assertEquals(201,response.status());



    }

    //////////////////////////////////


    @Test
    void puttuser(){
        APIResponse response =apicontext.put("api/users/2", RequestOptions.create().setData(Data.put()));

        System.out.println(response.text());
        Assert.assertEquals(200,response.status());



    }



    @Test
    void deleteuser(){
        APIResponse response =apicontext.delete("api/users/2");

        System.out.println(response.text());
        Assert.assertEquals(204,response.status());



    }


    @Test
    void register(){
        APIResponse response =apicontext.post("api/register", RequestOptions.create().setData(Data.register()));

        System.out.println(response.text());
        Assert.assertEquals(400,response.status());



    }

































    @AfterTest
    void after(){
        apicontext.dispose();
        play.close();
    }
}
