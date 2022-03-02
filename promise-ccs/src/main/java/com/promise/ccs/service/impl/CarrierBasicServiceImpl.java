package com.promise.ccs.service.impl;

import com.promise.ccs.common.ApplicationMapperCollection;
import com.promise.ccs.common.RestResponsePage;
import com.promise.ccs.data.dto.internal.CarrierBasicCreateDTO;
import com.promise.ccs.data.dto.internal.CarrierBasicListDTO;
import com.promise.ccs.data.dto.internal.CarrierBasicViewDTO;
import com.promise.ccs.data.entity.CarrierBasic;
import com.promise.ccs.repository.CarrierBasicRepository;
import com.promise.ccs.service.CarrierBasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarrierBasicServiceImpl implements CarrierBasicService {
    private static final Logger logger = LoggerFactory.getLogger(CarrierBasicServiceImpl.class);

    @Autowired
    CarrierBasicRepository carrierBasicRepository;

    @Override
    public CarrierBasicViewDTO createCarrierBasic(CarrierBasicCreateDTO carrierBasicCreateDTO) {
        CarrierBasic carrierBasic = ApplicationMapperCollection.CARRIER_BASIC_MAPPER.carrierBasicCreateDTOToCarrierBasic(carrierBasicCreateDTO);
        carrierBasic = carrierBasicRepository.save(carrierBasic);
        return ApplicationMapperCollection.CARRIER_BASIC_MAPPER.carrierBasicToCarrierBasicViewDTO(carrierBasic);
    }

    @Override
    public RestResponsePage<CarrierBasicListDTO> queryCarrierBasic(Pageable pageable) {
        Page<CarrierBasic> carrierBasics = carrierBasicRepository.findAll(pageable);

        List<CarrierBasic> carrierBasicList = carrierBasics.getContent();
        List<CarrierBasicListDTO> dtoList = new ArrayList<>();
        if (carrierBasicList != null && !carrierBasicList.isEmpty()) {
            dtoList = ApplicationMapperCollection.CARRIER_BASIC_MAPPER.carrierBasicListToCarrierBasicListDTOList(carrierBasicList);
        }

        return new RestResponsePage(dtoList, pageable, carrierBasics.getTotalElements());
    }
}
