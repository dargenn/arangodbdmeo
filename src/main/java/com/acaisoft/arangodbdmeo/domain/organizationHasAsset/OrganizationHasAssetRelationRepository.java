package com.acaisoft.arangodbdmeo.domain.organizationHasAsset;

import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;
import org.springframework.data.repository.query.Param;

public interface OrganizationHasAssetRelationRepository extends ArangoRepository<OrganizationHasAssetRelation, String> {

    @Query("FOR a in assets FOR o IN organizationHasAssetRelation FILTER o._from == @organizationId AND o._to == a._id COLLECT AGGREGATE avg = AVERAGE(a.capacity) return avg")
    double getAverageCapacityByOrganizationId(@Param("organizationId") String organizationId);

    @Query("FOR a IN 1..1 OUTBOUND @organizationId organizationHasAssetRelation COLLECT AGGREGATE avg = AVERAGE(a.capacity) RETURN avg")
    double getAverageCapacityByOrganizationIdFromGraph(@Param("organizationId") String organizationId);

    @Query("FOR a in assets FOR o IN organizationHasAssetRelation FILTER o._from == @organizationId AND o._to == a._id COLLECT AGGREGATE avg = SUM(a.capacity) return avg")
    int getSumCapacityByOrganizationId(String organizationId);

    @Query("FOR a IN 1..1 OUTBOUND @organizationId organizationHasAssetRelation COLLECT AGGREGATE avg = SUM(a.capacity) RETURN avg")
    int getSumCapacityByOrganizationIdFromGraph(@Param("organizationId") String organizationId);
}
