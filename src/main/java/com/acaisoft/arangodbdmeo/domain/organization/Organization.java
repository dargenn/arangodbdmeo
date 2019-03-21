package com.acaisoft.arangodbdmeo.domain.organization;

import com.acaisoft.arangodbdmeo.domain.organizationChildOf.OrganizationChildOfRelation;
import com.acaisoft.arangodbdmeo.domain.organizationHasAsset.OrganizationHasAssetRelation;
import com.acaisoft.arangodbdmeo.domain.asset.Asset;
import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Relations;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@Document("organizations")
public class Organization {
    @Id
    private String id;

    private String name = UUID.randomUUID().toString();

    @Relations(edges = OrganizationChildOfRelation.class, lazy = true)
    private Set<Organization> children = new HashSet<>();

    @Relations(edges = OrganizationHasAssetRelation.class, lazy = true)
    private Set<Asset> assets = new HashSet<>();
}

