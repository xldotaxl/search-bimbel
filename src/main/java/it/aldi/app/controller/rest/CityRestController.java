package it.aldi.app.controller.rest;

import it.aldi.app.controller.Routes;
import it.aldi.app.domain.City;
import it.aldi.app.service.CityService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Routes.API_CITIES)
public class CityRestController {

    private final @NonNull CityService cityService;

    public CityRestController(@NonNull CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<List<City>> getCityByProvince(@RequestParam(name = "province") Long provinceId) {
        return new ResponseEntity<>(cityService.findByProvinceId(provinceId), HttpStatus.OK);
    }
}
