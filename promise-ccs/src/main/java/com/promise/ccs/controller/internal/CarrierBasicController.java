package com.promise.ccs.controller.internal;

import com.promise.ccs.common.RestResponsePage;
import com.promise.ccs.data.dto.internal.CarrierBasicCreateDTO;
import com.promise.ccs.data.dto.internal.CarrierBasicListDTO;
import com.promise.ccs.data.dto.internal.CarrierBasicViewDTO;
import com.promise.ccs.service.CarrierBasicService;
import com.promise.ccs.service.impl.CarrierBasicServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Carrier Management")
@SecurityRequirement(name = "inuseapi")
@RestController
public class CarrierBasicController {
    private static final Logger logger = LoggerFactory.getLogger(CarrierBasicServiceImpl.class);

    @Autowired
    CarrierBasicService carrierBasicService;

    @Operation(summary = "Query carrier basic page")
    @GetMapping(value = "/carriers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponsePage<CarrierBasicListDTO>> queryCarrierBasicPage(Pageable pageable) {
        logger.info("Received query carrier basic request: {}", pageable);
        return ResponseEntity.ok(carrierBasicService.queryCarrierBasic(pageable));
    }

    @Operation(summary = "Create carrier basic")
    @PostMapping(value = "/carriers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarrierBasicViewDTO> createCarrierBasic(@RequestBody CarrierBasicCreateDTO carrierBasicCreateDTO) {
        logger.info("Received create carrier basic request: {}", carrierBasicCreateDTO);
        return ResponseEntity.ok(carrierBasicService.createCarrierBasic(carrierBasicCreateDTO));
    }
}
