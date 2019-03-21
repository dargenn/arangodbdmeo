package com.acaisoft.arangodbdmeo.domain.organizationChildOf;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationChildOfRelationService {
    private final OrganizationChildOfRelationRepository organizationChildOfRelationRepository;

    public Iterable<OrganizationChildOfRelation> saveAll(Iterable<OrganizationChildOfRelation> relations) {
        return organizationChildOfRelationRepository.saveAll(relations);
    }
}
