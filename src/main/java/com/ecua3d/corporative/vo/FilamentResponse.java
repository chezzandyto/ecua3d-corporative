package com.ecua3d.corporative.vo;

import com.ecua3d.corporative.model.ColorEntity;
import com.ecua3d.corporative.model.MaterialEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilamentResponse {

    private Integer id;
    private ColorResponse color;
    private MaterialResponse material;
    private String brand;
    private Integer weight;
    private double diameter;
    private double temperature;
    private BigDecimal cost;
    private String vendorId;
    private Integer remaining;

}
