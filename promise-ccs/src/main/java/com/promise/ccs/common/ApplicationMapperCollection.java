package com.promise.ccs.common;

import com.promise.ccs.data.mapper.internal.CarrierBasicMapper;
import org.mapstruct.factory.Mappers;

public class ApplicationMapperCollection {
    public static final CarrierBasicMapper CARRIER_BASIC_MAPPER = Mappers.getMapper(CarrierBasicMapper.class);
}
