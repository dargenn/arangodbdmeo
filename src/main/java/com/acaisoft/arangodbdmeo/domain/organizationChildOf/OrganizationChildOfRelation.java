package com.acaisoft.arangodbdmeo.domain.organizationChildOf;

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
public class OrganizationChildOfRelation {
    @Id
    private String id;

    @From
    private Organization child;

    @To
    private Organization parent;

    public OrganizationChildOfRelation(Organization child, Organization parent) {
        this.child = child;
        this.parent = parent;
    }
}
