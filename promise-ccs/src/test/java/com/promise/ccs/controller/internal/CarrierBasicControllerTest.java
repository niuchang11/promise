package com.promise.ccs.controller.internal;

import com.promise.ccs.common.RestResponsePage;
import com.promise.ccs.controller.internal.CarrierBasicController;
import com.promise.ccs.data.dto.internal.CarrierBasicCreateDTO;
import com.promise.ccs.data.dto.internal.CarrierBasicListDTO;
import com.promise.ccs.data.dto.internal.CarrierBasicViewDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class CarrierBasicControllerTest {
    @Autowired
    private CarrierBasicController carrierBasicController;

    // inject the runtime port, it requires the webEnvironment
    @LocalServerPort
    private int port;

    // we use TestRestTemplate, it's an alternative to RestTemplate specific for tests
    // to use this template a webEnvironment is mandatory
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void index() {
        // we test that our controller is not null
        assertThat(carrierBasicController).isNotNull();
    }

    @Test
    public void queryCarrierBasicFailAsNotAuthRequestTest() {
        ResponseEntity<RestResponsePage<CarrierBasicListDTO>> response = restTemplate.exchange("http://localhost:" + port + "/carriers?page=0&size=10", HttpMethod.GET, null,
                new ParameterizedTypeReference<RestResponsePage<CarrierBasicListDTO>>() {
                });
        assertTrue(response.getStatusCode().is4xxClientError());
    }

    @Test
    public void queryCarrierBasicSuccessTest() {
        ResponseEntity<RestResponsePage<CarrierBasicListDTO>> response = restTemplate.withBasicAuth("spring", "secret").exchange("http://localhost:" + port + "/carriers?page=0&size=10", HttpMethod.GET, null,
                new ParameterizedTypeReference<RestResponsePage<CarrierBasicListDTO>>() {
                });
        assertTrue(response.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void createCarrierBasicTest() {
        CarrierBasicCreateDTO requestBody = new CarrierBasicCreateDTO();
        requestBody.setName("Cat");
        ResponseEntity<CarrierBasicViewDTO> response = restTemplate.withBasicAuth("spring", "secret").exchange("http://localhost:" + port + "/carriers", HttpMethod.POST, new HttpEntity(requestBody), CarrierBasicViewDTO.class);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(requestBody.getName(), response.getBody().getName());
    }
}
