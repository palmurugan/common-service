package com.loki.common.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @author palmurugan
 */
public class AuditAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Administrator");
    }
}
