package com.acaisoft.arangodbdmeo.domain.organization;

import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends ArangoRepository<Organization, String> {
    @Query("FOR o IN organizations FILTER o._key == @organizationId FOR a IN o.assets RETURN avg(a.capacity)")
    double getAverageCapacityByOrganizationId(@Param("organizationId") String organizationId);
}
