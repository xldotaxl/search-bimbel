package it.aldi.app.controller.rest;

import it.aldi.app.controller.Routes;
import it.aldi.app.domain.Province;
import it.aldi.app.util.HttpRequestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProvinceRestControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private HttpRequestHelper requestHelper;

    @Test
    public void getAllProvince() {
        ResponseEntity<Province[]> responseEntity = testRestTemplate.exchange(Routes.API_PROVINCE, HttpMethod.GET,
            requestHelper.getRequestHeaders(), Province[].class
        );

        assertEquals("Status should be 200", HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Content-Type should be JSON", MediaType.APPLICATION_JSON_UTF8,
            responseEntity.getHeaders().getContentType()
        );
    }
}
