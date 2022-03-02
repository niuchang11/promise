package com.promise.ccs.data.mapper.internal;

import com.promise.ccs.data.dto.internal.CarrierBasicCreateDTO;
import com.promise.ccs.data.dto.internal.CarrierBasicListDTO;
import com.promise.ccs.data.dto.internal.CarrierBasicViewDTO;
import com.promise.ccs.data.entity.CarrierBasic;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CarrierBasicMapper {
    CarrierBasic carrierBasicCreateDTOToCarrierBasic(CarrierBasicCreateDTO carrierBasicCreateDTO);

    CarrierBasicViewDTO carrierBasicToCarrierBasicViewDTO(CarrierBasic carrierBasic);

    CarrierBasicListDTO carrierBasicToCarrierBasicListDTO(CarrierBasic carrierBasic);

    List<CarrierBasicListDTO> carrierBasicListToCarrierBasicListDTOList(List<CarrierBasic> carrierBasicList);

}
