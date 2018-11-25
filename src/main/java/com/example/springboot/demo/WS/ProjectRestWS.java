/*****
 *  Author Srikant N @ CA
 */

package com.example.springboot.demo.WS;

import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ProjectRestWS
{
    private static int counter = 0;

    public void validateWS() {
     
        HttpClientBuilder httpClient = HttpClientBuilder.create();
        
        try {
          // specify the host, protocol, and port
          HttpHost target = new HttpHost("agilemanifesto.org", 80, "http");
          
          // specify the get request
          HttpGet getRequest = new HttpGet("/principles");

          System.out.println("validateWS executing request to Before  " + Thread.currentThread().getName() + " Thread Name " + Thread.currentThread().getId());
          

          int timeout = 7000;
          RequestConfig.Builder requestBuilder = RequestConfig.custom();
          requestBuilder = requestBuilder.setConnectTimeout(timeout);
          requestBuilder = requestBuilder.setConnectionRequestTimeout(timeout);
          
          CloseableHttpResponse httpResponse = null;
          
          if ( counter % 8 == 0) {
              httpResponse = httpClient.setDefaultRequestConfig(requestBuilder.build()).build().execute(target, getRequest);
              HttpEntity entity = httpResponse.getEntity();
          
          }
          System.out.println("validateWS executing request Done " + ((httpResponse == null) ? "Null response" : httpResponse.getStatusLine()));

       /* if (entity != null) {
          System.out.println(EntityUtils.toString(entity));
        }
        */


        
      } catch (Exception e) {
        e.printStackTrace();
      }
        
        //System.out.println("In ValidateWS " + Thread.currentThread().getName() + " Thread Name " + Thread.currentThread().getId());
        
    }
    
    public void test() {
        
    }

}
