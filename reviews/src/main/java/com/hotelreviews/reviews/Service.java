
package com.hotelreviews.reviews;
import okhttp3.*;
import okhttp3.Response;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
@org.springframework.stereotype.Service
public class Service {
    private final OkHttpClient client = new OkHttpClient();
    private final String apiKey = "EDA87A52AC2B4152A2B38D3FE8200897";

    public String fetchHotelReviews(Integer locationId) throws IOException {
        String apiUrl = "https://api.content.tripadvisor.com/api/v1/location/" + locationId + "/reviews?key=" + apiKey + "&language=en";
        Request request = new Request.Builder()
                .url(apiUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
    public String fetchHotelLocations(String hotel, String city) throws IOException {
        String encodedHotel = URLEncoder.encode(hotel, StandardCharsets.UTF_8.toString());
        String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8.toString());

        String apiUrl = "https://api.content.tripadvisor.com/api/v1/location/search?" +
                "key=" + apiKey +
                "&searchQuery=" + encodedHotel +
                "&address=" + encodedCity +
                "&language=en";
        Request request = new Request.Builder()
                .url(apiUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
