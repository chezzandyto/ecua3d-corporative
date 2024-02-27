package com.ecua3d.corporative.vo;

import com.ecua3d.corporative.model.ColorEntity;
import com.ecua3d.corporative.model.MaterialEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilamentDTO {

    private Integer colorId;
    private Integer materialId;
    @NotBlank(message = "Marca de filamento no puede ser vacío")
    private String brand;
    @NotBlank(message = "Peso de filamento no puede ser vacío")
    private Integer weight;
    @NotBlank(message = "Diametro de filamento no puede ser vacío")
    private double diameter;
    @NotBlank(message = "Temperatura de filamento no puede ser vacío")
    private double temperature;
    @NotBlank(message = "Costo de filamento no puede ser vacío")
    private BigDecimal cost;
    private String vendorId;
    private Integer remaining;
}
