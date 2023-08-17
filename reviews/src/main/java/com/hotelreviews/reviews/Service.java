
package com.hotelreviews.reviews;
import okhttp3.*;
import okhttp3.Response;
import java.io.IOException;
@org.springframework.stereotype.Service
public class Service {
    private final OkHttpClient client = new OkHttpClient();

    public String fetchHotelReviews(Integer locationId) throws IOException {
        String apiUrl = "https://api.content.tripadvisor.com/api/v1/location/" + locationId + "/reviews?key=4CA089B09ABA420997FB374D3B3F1647&language=en";
        Request request = new Request.Builder()
                .url(apiUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
    public String fetchHotelLocations(String hotel) throws IOException {
        String apiUrl = "https://api.content.tripadvisor.com/api/v1/location/search?key=4CA089B09ABA420997FB374D3B3F1647&searchQuery=" + hotel + "&radius=5&radiusUnit=km&language=en";
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
