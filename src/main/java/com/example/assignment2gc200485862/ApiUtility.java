package com.example.assignment2gc200485862;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiUtility {
    public static ApiResponse getProductsFromApi(String keyword, int pageNumber){
        keyword = keyword.replace(" ", "%20");
        String uri = "https://axesso-axesso-amazon-data-service-v1.p.rapidapi.com/amz/amazon-search-by-keyword-asin?domainCode=com&keyword="+keyword+"&page="+pageNumber+"&excludeSponsored=false";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).header("X-RapidAPI-Host", "axesso-axesso-amazon-data-service-v1.p.rapidapi.com")
                .header("X-RapidAPI-Key", "0820e5a413msh9383d6a1a9e32f0p116ac2jsnb3523ebf2fc2")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        try {
            HttpResponse<String> response = client.send(httpRequest, HttpResponse
                    .BodyHandlers.ofString());
            Gson gson = new Gson();
            return gson.fromJson(response.body(), ApiResponse.class);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * This method receives an imdbID for a movie or show and returns
     * a MovieDetails object
     */
   /* public static ProductDetails getProductDetails(String asinID)
    {
        String uri = "https://axesso-axesso-amazon-data-service-v1.p.rapidapi.com/amz/amazon-lookup-product?url=https%3A%2F%2Fwww.amazon.com%2F"+dpUrl+"&merchant="+asinID;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).header("X-RapidAPI-Host", "axesso-axesso-amazon-data-service-v1.p.rapidapi.com")
                .header("X-RapidAPI-Key", "0820e5a413msh9383d6a1a9e32f0p116ac2jsnb3523ebf2fc2")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        try {
            HttpResponse<String> response = client.send(httpRequest, HttpResponse
                    .BodyHandlers.ofString());
            Gson gson = new Gson();
            return gson.fromJson(response.body(), ProductDetails.class);

        } catch (Exception e)
        {
            System.out.println("something went wrong when sending the request to API from APIUtility");
            e.printStackTrace();
        }
        return null;
    }*/


}
