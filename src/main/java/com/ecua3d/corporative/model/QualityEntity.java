package com.ecua3d.corporative.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "corpt_quality", schema = "corporative")
public class QualityEntity extends AuditingFields{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generador")
    @SequenceGenerator(name = "generador", schema = "corporative", sequenceName = "corporative.corps_quality", allocationSize = 1)
    @Column(name = "quality_id")
    private Integer qualityId;
    @Column(name = "name")
    private String nameQuality;

}
