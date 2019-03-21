package com.acaisoft.arangodbdmeo.domain.asset;

import com.acaisoft.arangodbdmeo.domain.organization.Organization;
import com.acaisoft.arangodbdmeo.domain.organizationHasAsset.OrganizationHasAssetRelation;
import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Relations;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@Document("assets")
public class Asset {
    @Id
    private String id;

    private String name = RandomStringUtils.randomAlphabetic(10);

    private Integer capacity = RandomUtils.nextInt(20, 100);

    @Relations(edges = OrganizationHasAssetRelation.class)
    private Organization organization;
}
