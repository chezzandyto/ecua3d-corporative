package com.ecua3d.corporative.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColorDTO {
    @NotBlank(message = "Nombre de area no puede ser vacío")
    @Size(message = "Nombre de area maximo de 64 caracteres y minimo 3",min= 3,max = 64)
    private String nameColor;
}
