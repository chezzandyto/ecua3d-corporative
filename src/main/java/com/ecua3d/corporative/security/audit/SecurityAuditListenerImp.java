package com.ecua3d.corporative.security.audit;

import com.ecua3d.corporative.model.AuditingFields;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
public class SecurityAuditListenerImp {
    private final AuditorAware<String> auditorAware;

    @PrePersist
    public void loadInsertAuditFields(AuditingFields audit) {
        Optional<String> auditUser = auditorAware.getCurrentAuditor();
        if(auditUser.isEmpty()) throw new RuntimeException("User who is Creating was not found", new Exception());
        audit.setCreateByUser(auditUser.get());
        audit.setCreatedFromIp(getIp());
        audit.setCreatedDate(LocalDateTime.now());
    }

    @PreUpdate
    public void loadUpdateAuditFields(AuditingFields audit) {
        Optional<String> auditUser = auditorAware.getCurrentAuditor();
        if(auditUser.isEmpty()) throw new RuntimeException("User who is Updating was not found", new Exception());
        audit.setLastModifiedByUser(auditUser.get());
        audit.setUpdatedFromIp(getIp());
        audit.setLastModifiedDate(LocalDateTime.now());
    }

    private String getIp() {
        String ipAddress;
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                    .getRequest();
            ipAddress = request.getHeader("x-original-forwarded-for");
            if (StringUtils.isBlank(ipAddress)) {
                ipAddress = request.getHeader("X-FORWARDED-FOR");
            }
            if (StringUtils.isBlank(ipAddress)) {
                ipAddress = request.getRemoteAddr();
            } else {
                ipAddress = ipAddress.split(",")[0];
            }
        } catch (Exception e) {
            ipAddress = "ND";
        }
        return StringUtils.isBlank(ipAddress) ? "ND" : ipAddress;
    }
}