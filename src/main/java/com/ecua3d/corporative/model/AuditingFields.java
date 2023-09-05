package com.ecua3d.corporative.model;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public class AuditingFields {
    @Column(name = "created_by_user")
    private String createByUser;
    @Column(name = "created_date")
    private Date createdDate ;
    @Column(name = "last_modified_by_user")
    private String lastModifiedByUser;
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;
    @Column(name = "created_from_ip")
    private String createdFromIp;
    @Column(name = "updated_from_ip")
    private String updatedFromIp;
    @Column(name = "status")
    private String status;
}
