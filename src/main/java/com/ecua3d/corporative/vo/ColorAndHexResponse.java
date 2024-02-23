package com.ecua3d.corporative.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColorAndHexResponse {
    private Integer colorId;
    private byte hexadecimal;
}
