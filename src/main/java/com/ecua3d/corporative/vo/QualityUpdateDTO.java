package com.ecua3d.corporative.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QualityUpdateDTO {
    @NotNull
    private Integer qualityId;
    @NotBlank(message = "Nombre de area no puede ser vacío")
    @Size(message = "Nombre de area maximo de 64 caracteres y minimo 3",min= 3,max = 64)
    private String nameQuality;

}
