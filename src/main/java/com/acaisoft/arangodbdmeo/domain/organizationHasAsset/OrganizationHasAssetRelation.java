package com.acaisoft.arangodbdmeo.domain.organizationHasAsset;

import com.acaisoft.arangodbdmeo.domain.asset.Asset;
import com.acaisoft.arangodbdmeo.domain.organization.Organization;
import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Edge
@Data
@NoArgsConstructor
public class OrganizationHasAssetRelation {
    @Id
    private String id;

    @From
    private Organization organization;

    @To
    private Asset asset;

    public OrganizationHasAssetRelation(Organization organization, Asset asset) {
        this.organization = organization;
        this.asset = asset;
    }
}
