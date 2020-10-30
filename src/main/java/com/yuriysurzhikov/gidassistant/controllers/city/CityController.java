package com.yuriysurzhikov.gidassistant.controllers.city;
import com.yuriysurzhikov.gidassistant.model.client.CityFromClient;
import com.yuriysurzhikov.gidassistant.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/create")
    public ResponseEntity<?> createCity(@RequestBody CityFromClient city) {
        Integer code = cityService.addCityIfNotExists(city);
        if(code == Const.Repository.SAVE_SUCCESSFUL) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.TOO_MANY_REQUESTS);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllCities(@RequestParam String cityType) {
        return new ResponseEntity<>(cityService.getCities(cityType), HttpStatus.OK);
    }
}
