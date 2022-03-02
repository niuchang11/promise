package com.promise.ccs.repository;

import com.promise.ccs.data.entity.CarrierBasic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrierBasicRepository extends JpaRepository<CarrierBasic, Long> {
}
