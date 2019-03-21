package com.acaisoft.arangodbdmeo.domain.asset;

import com.arangodb.springframework.repository.ArangoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends ArangoRepository<Asset, String> {
}
