package com.example.carruselrafaelrosario.repository;

import com.example.carruselrafaelrosario.model.Response;
import com.example.carruselrafaelrosario.repository.interfaces.ICarruselRepository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

@Repository
public class CarruselRepository implements ICarruselRepository {

    @Override
    public List<Response> getCupon() {

        String POSTS_API_URL = "https://cs-hsa-api-coupons.herokuapp.com/coupons";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(POSTS_API_URL))
                .GET() //este es el metodo
                .header("accept", "application/json")
                .build();
        try{
            CompletableFuture<HttpResponse<String>> response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.thenApply(HttpResponse::body).get(10,TimeUnit.SECONDS);
                ObjectMapper mapper = new ObjectMapper();
                List<Response> responses = mapper.readValue(responseBody, new TypeReference<List<Response>>(){});
                return responses;

        }catch(IOException | InterruptedException | ExecutionException | TimeoutException e){
            return new ArrayList<>();
        }
    }
}
