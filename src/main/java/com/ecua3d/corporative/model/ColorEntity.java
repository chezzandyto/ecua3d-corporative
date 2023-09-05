package com.ecua3d.corporative.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
@Table(name = "corpt_color", schema = "corporative")
public class ColorEntity extends AuditingFields{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generador")
    @SequenceGenerator(name = "generador", schema = "corporative", sequenceName = "corporative.corps_color", allocationSize = 1)
    @Column(name = "color_id")
    private Integer colorId;
    @Column(name = "name")
    private String nameColor;

}
