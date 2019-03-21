package com.acaisoft.arangodbdmeo.domain.organizationChildOf;

import com.arangodb.springframework.repository.ArangoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationChildOfRelationRepository extends ArangoRepository<OrganizationChildOfRelation, String> {
}
