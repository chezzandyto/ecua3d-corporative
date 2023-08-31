package com.ecua3d.corporative.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public class AuditingFields {
    @Column(name = "created_by_user")
    private Integer createByUser;
    @Column(name = "created_date")
    private Date createdDate ;
    @Column(name = "last_modified_by_user")
    private Integer lastModifiedByUser;
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;
    @Column(name = "created_from_ip")
    private String createdFromIp;
    @Column(name = "updated_from_ip")
    private String updatedFromIp;
    @Column(name = "status")
    private String status;
}
