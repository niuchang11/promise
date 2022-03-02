package com.promise.ccs.data.dto.internal;

import javax.validation.constraints.NotBlank;

public class CarrierBasicCreateDTO {
    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
