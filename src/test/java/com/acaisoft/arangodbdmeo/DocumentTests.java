package com.acaisoft.arangodbdmeo;

import com.acaisoft.arangodbdmeo.domain.asset.Asset;
import com.acaisoft.arangodbdmeo.domain.asset.AssetService;
import com.acaisoft.arangodbdmeo.domain.organization.Organization;
import com.acaisoft.arangodbdmeo.domain.organization.OrganizationService;
import com.acaisoft.arangodbdmeo.domain.organizationHasAsset.OrganizationHasAssetRelation;
import com.acaisoft.arangodbdmeo.domain.organizationHasAsset.OrganizationHasAssetRelationService;
import org.assertj.core.util.Sets;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentTests {
    @Autowired private OrganizationService organizationService;
    @Autowired private AssetService assetService;
    @Autowired private OrganizationHasAssetRelationService organizationHasAssetRelationService;

    private static final String BIALYSTOK_ID = "374";

    @Test
    @Ignore
    public void save() {
        Organization organization = new Organization();
        organization.setName("bialystok");
        organization = organizationService.save(organization);

        Set<Asset> assets = Sets.newHashSet();
        for(int i = 0; i < 100000; i++) {
            Asset asset = new Asset();
            assets.add(asset);
        }
        assets = (Set<Asset>) assetService.saveAll(assets);

        Organization finalOrganization = organization;
        Set<OrganizationHasAssetRelation> relations = assets.stream().map(asset -> new OrganizationHasAssetRelation(finalOrganization, asset)).collect(Collectors.toSet());
        organizationHasAssetRelationService.saveAll(relations);
    }

    @Test
//    @Ignore
    public void calculateAverageFromDocument() {
        double average = organizationHasAssetRelationService.getAverageCapacityByOrganizationId(BIALYSTOK_ID);
        System.out.println("AVERAGE: " + average);
        assert average > 50;
    }

    @Test
//    @Ignore
    public void calculateSumFromDocument() {
        int sum = organizationHasAssetRelationService.getSumCapacityByOrganizationId(BIALYSTOK_ID);
        System.out.println("SUM: " + sum);
        assert sum > 50;
    }

    @Test
//    @Ignore
    public void calculateAverageFromGraph() {
        double average = organizationHasAssetRelationService.getAverageCapacityByOrganizationIdFromGraph(BIALYSTOK_ID);
        System.out.println("AVERAGE: " + average);
        assert average > 50;
    }

    @Test
//    @Ignore
    public void calculateSumFromGraph() {
        int sum = organizationHasAssetRelationService.getSumCapacityByOrganizationIdFromGraph(BIALYSTOK_ID);
        System.out.println("Sum: " + sum);
        assert sum > 50;
    }

    @Test
    @Ignore
    public void deleteAll() {
        organizationService.deleteAll();
        assetService.deleteAll();
        organizationHasAssetRelationService.deleteAll();
    }
}

