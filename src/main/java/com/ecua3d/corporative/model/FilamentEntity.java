package com.ecua3d.corporative.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Entity
@NoArgsConstructor
@Table(name = "corpt_filament", schema = "corporative")
public class FilamentEntity extends AuditingFields{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generador")
    @SequenceGenerator(name = "generador", schema = "corporative", sequenceName = "corporative.corps_filament", allocationSize = 1)
    @Column(name = "filament_id")
    private Integer id;

    @Column(name = "color_id", insertable = false, updatable = false)
    private Integer colorId;

    @Column(name = "material_id", insertable = false, updatable = false)
    private Integer materialId;

    private String brand;

    private Integer weight;
    private double diameter;
    private double temperature;
    private BigDecimal cost;

    @Column(name = "vendor_id")
    private String vendorId;
    private Integer remaining;

    @ManyToOne
    @JoinColumn(name = "color_id", nullable = false)
    private ColorEntity colorEntity;

    @ManyToOne
    @JoinColumn(name = "material_id", nullable = false)
    private MaterialEntity materialEntity;

}
