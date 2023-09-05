package com.ecua3d.corporative.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "corpt_material", schema = "corporative")
public class MaterialEntity extends AuditingFields{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generador")
    @SequenceGenerator(name = "generador", schema = "corporative", sequenceName = "corporative.corps_material", allocationSize = 1)
    @Column(name = "material_id")
    private Integer materialId;
    @Column(name = "name")
    private String nameMaterial;

}
