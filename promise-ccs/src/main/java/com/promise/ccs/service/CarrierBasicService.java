package com.promise.ccs.service;

import com.promise.ccs.common.RestResponsePage;
import com.promise.ccs.data.dto.internal.CarrierBasicCreateDTO;
import com.promise.ccs.data.dto.internal.CarrierBasicListDTO;
import com.promise.ccs.data.dto.internal.CarrierBasicViewDTO;
import org.springframework.data.domain.Pageable;

public interface CarrierBasicService {
    CarrierBasicViewDTO createCarrierBasic(CarrierBasicCreateDTO carrierBasicCreateDTO);

    RestResponsePage<CarrierBasicListDTO> queryCarrierBasic(Pageable pageable);
}
