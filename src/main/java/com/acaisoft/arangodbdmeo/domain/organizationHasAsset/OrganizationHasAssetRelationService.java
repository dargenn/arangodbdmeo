package com.acaisoft.arangodbdmeo.domain.organizationHasAsset;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationHasAssetRelationService {
    private final OrganizationHasAssetRelationRepository organizationHasAssetRelationRepository;

    public Iterable<OrganizationHasAssetRelation> saveAll(Iterable<OrganizationHasAssetRelation> relations) {
        return organizationHasAssetRelationRepository.saveAll(relations);
    }

    public void deleteAll() {
        organizationHasAssetRelationRepository.deleteAll();
    }

    public Iterable<OrganizationHasAssetRelation> findAll() {
        return organizationHasAssetRelationRepository.findAll();
    }

    public double getAverageCapacityByOrganizationId(String organizationId) {
        organizationId = "organizations/" + organizationId;
        return organizationHasAssetRelationRepository.getAverageCapacityByOrganizationId(organizationId);
    }

    public double getAverageCapacityByOrganizationIdFromGraph(String organizationId) {
        organizationId = "organizations/" + organizationId;
        return organizationHasAssetRelationRepository.getAverageCapacityByOrganizationIdFromGraph(organizationId);
    }

    public int getSumCapacityByOrganizationId(String organizationId) {
        organizationId = "organizations/" + organizationId;
        return organizationHasAssetRelationRepository.getSumCapacityByOrganizationId(organizationId);
    }

    public int getSumCapacityByOrganizationIdFromGraph(String organizationId) {
        organizationId = "organizations/" + organizationId;
        return organizationHasAssetRelationRepository.getSumCapacityByOrganizationIdFromGraph(organizationId);
    }
}
