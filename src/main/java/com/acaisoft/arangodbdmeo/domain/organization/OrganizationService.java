package com.acaisoft.arangodbdmeo.domain.organization;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    public Iterable<Organization> findAll() {
        return organizationRepository.findAll();
    }

    public Organization save(Organization organization) {
        return organizationRepository.save(organization);
    }

    public void deleteAll() {
        organizationRepository.deleteAll();
    }

    public Organization findById(String id) {
        return organizationRepository.findById(id).orElse(new Organization());
    }

    public double getAverageCapacityByOrganizationId(String organizationId) {
        return organizationRepository.getAverageCapacityByOrganizationId(organizationId);
    }
}
