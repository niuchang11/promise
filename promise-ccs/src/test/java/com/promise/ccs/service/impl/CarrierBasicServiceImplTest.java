package com.promise.ccs.service.impl;

import com.promise.ccs.common.RestResponsePage;
import com.promise.ccs.data.dto.internal.CarrierBasicListDTO;
import com.promise.ccs.data.entity.CarrierBasic;
import com.promise.ccs.repository.CarrierBasicRepository;
import com.promise.ccs.service.CarrierBasicService;
import com.promise.ccs.service.impl.CarrierBasicServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CarrierBasicServiceImplTest {

    private static final Long PRODUCT_ID = 1L;

    @InjectMocks
    CarrierBasicService carrierBasicService;

    @Mock
    CarrierBasicRepository carrierBasicRepository;

    public CarrierBasicServiceImplTest() {
        this.carrierBasicService = new CarrierBasicServiceImpl();
    }

    @Test
    public void queryCarrierBasicTest1() {
        List<CarrierBasic> resultList = new ArrayList<>();
        CarrierBasic carrierBasic = new CarrierBasic();
        carrierBasic.setName("Cat");
        resultList.add(carrierBasic);
        Mockito.when(carrierBasicRepository.findAll(Mockito.any(Pageable.class))).thenReturn(new PageImpl<>(resultList));
        RestResponsePage<CarrierBasicListDTO> result = carrierBasicService.queryCarrierBasic(Pageable.ofSize(5));
        assertEquals(1L, result.getTotalElements());
    }
}
