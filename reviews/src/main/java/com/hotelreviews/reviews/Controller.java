package com.hotelreviews.reviews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    private Service Service;

    @GetMapping("/get-reviews/{locationId}")
    public String getHotelReviews(@PathVariable Integer locationId) {
        try {
           return Service.fetchHotelReviews(locationId);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred";
        }
    }
    @GetMapping("/get-locations")
    public String getLocationId(@RequestParam("hotel") String hotel, @RequestParam("city") String city) {
        try {
            return Service.fetchHotelLocations(hotel, city);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred";
        }
    }


}
