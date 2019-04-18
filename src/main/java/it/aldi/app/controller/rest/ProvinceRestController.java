package it.aldi.app.controller.rest;

import it.aldi.app.controller.Routes;
import it.aldi.app.domain.Province;
import it.aldi.app.service.ProvinceService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Routes.API_PROVINCE)
public class ProvinceRestController {

    private final @NonNull ProvinceService provinceService;

    public ProvinceRestController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @GetMapping
    public ResponseEntity<List<Province>> getAllProvince() {
        return new ResponseEntity<>(provinceService.findAll(), HttpStatus.OK);
    }
}
