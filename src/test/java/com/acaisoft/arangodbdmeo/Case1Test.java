package com.acaisoft.arangodbdmeo;

import com.acaisoft.arangodbdmeo.domain.asset.Asset;
import com.acaisoft.arangodbdmeo.domain.asset.AssetService;
import com.acaisoft.arangodbdmeo.domain.organization.Organization;
import com.acaisoft.arangodbdmeo.domain.organization.OrganizationService;
import com.acaisoft.arangodbdmeo.domain.organizationChildOf.OrganizationChildOfRelation;
import com.acaisoft.arangodbdmeo.domain.organizationChildOf.OrganizationChildOfRelationService;
import com.acaisoft.arangodbdmeo.domain.organizationHasAsset.OrganizationHasAssetRelation;
import com.acaisoft.arangodbdmeo.domain.organizationHasAsset.OrganizationHasAssetRelationService;
import org.assertj.core.util.Sets;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Case1Test {
    @Autowired private OrganizationService organizationService;
    @Autowired private AssetService assetService;
    @Autowired private OrganizationHasAssetRelationService organizationHasAssetRelationService;
    @Autowired private OrganizationChildOfRelationService organizationChildOfRelationService;

    private static final String BIALYSTOK_CASE_1_ID = "539455";
    private static final String BIALYSTOK_CASE_2_ID = "752037";
    private static final String BIALYSTOK_CASE_3_ID = "947905";
    private static final String BIALYSTOK_CASE_4_ID = "1143012";

    @Test
    @Rollback(false)
    @Ignore
    public void save() {
        Organization mainOrganization = new Organization();
        mainOrganization.setName("bialystok case 1");
        mainOrganization = organizationService.save(mainOrganization);

        Set<Organization> children = Sets.newHashSet();
        for(int i = 0; i < 10000; i++) {
            Organization child = new Organization();
            child.setName("Organization" + i);
            child = organizationService.save(child);
            children.add(child);

            Set<Asset> assets = Sets.newHashSet();
            for (int j = 0; j < 8; j++) {
                Asset asset = new Asset();
                assets.add(asset);
            }
            assets = (Set<Asset>) assetService.saveAll(assets);

            Organization finalChild = child;
            organizationHasAssetRelationService.saveAll(assets.stream().map(asset -> new OrganizationHasAssetRelation(finalChild, asset)).collect(Collectors.toList()));
        }

        Organization finalMainOrganization = mainOrganization;
        organizationChildOfRelationService.saveAll(children.stream().map(child -> new OrganizationChildOfRelation(finalMainOrganization, child)).collect(Collectors.toList()));
    }

    @Test
    @Rollback(false)
    @Ignore
    public void save2() {
        Organization mainOrganization = new Organization();
        mainOrganization.setName("bialystok case 2");
        mainOrganization = organizationService.save(mainOrganization);
        System.out.println("BSTOK 2 ID: " + mainOrganization.getId());

        Set<Organization> children = Sets.newHashSet();
        for(int i = 0; i < 100; i++) {
            Organization child = new Organization();
            child.setName("Organizationi" + i);
            child = organizationService.save(child);
            children.add(child);

            Set<Organization> children2 = Sets.newHashSet();
            for(int j = 0; j < 10; j++) {
                Organization child2 = new Organization();
                child2.setName("Organizationj" + i);
                child2 = organizationService.save(child2);
                children2.add(child2);

                Set<Organization> children3 = Sets.newHashSet();
                for(int k = 0; k < 10; k++) {
                    Organization child3 = new Organization();
                    child3.setName("Organizationk" + i);
                    child3 = organizationService.save(child2);
                    children3.add(child3);

                    Set<Asset> assets = Sets.newHashSet();
                    for (int o = 0; o < 8; o++) {
                        Asset asset = new Asset();
                        assets.add(asset);
                    }
                    assets = (Set<Asset>) assetService.saveAll(assets);

                    Organization finalChild3 = child3;
                    organizationHasAssetRelationService.saveAll(assets.stream().map(asset -> new OrganizationHasAssetRelation(finalChild3, asset)).collect(Collectors.toList()));
                }
                Organization finalChild2 = child2;
                organizationChildOfRelationService.saveAll(children3.stream().map(c -> new OrganizationChildOfRelation(finalChild2, c )).collect(Collectors.toList()));
            }
            Organization finalChild = child;
            organizationChildOfRelationService.saveAll(children2.stream().map(c -> new OrganizationChildOfRelation(finalChild, c)).collect(Collectors.toList()));
        }

        Organization finalMainOrganization = mainOrganization;
        organizationChildOfRelationService.saveAll(children.stream().map(child -> new OrganizationChildOfRelation(finalMainOrganization, child)).collect(Collectors.toList()));
    }

    @Test
    @Rollback(false)
    @Ignore
    public void save3() {
        Organization mainOrganization = new Organization();
        mainOrganization.setName("bialystok case 3");
        mainOrganization = organizationService.save(mainOrganization);
        System.out.println("BSTOK 3 ID: " + mainOrganization.getId());

        Set<Organization> children = Sets.newHashSet();
        for(int i = 0; i < 10; i++) {
            Organization child = new Organization();
            child.setName("Organizationi" + i);
            child = organizationService.save(child);
            children.add(child);

            Set<Organization> children2 = Sets.newHashSet();
            for(int j = 0; j < 10; j++) {
                Organization child2 = new Organization();
                child2.setName("Organizationj" + j);
                child2 = organizationService.save(child2);
                children2.add(child2);

                Set<Organization> children3 = Sets.newHashSet();
                for(int k = 0; k < 10; k++) {
                    Organization child3 = new Organization();
                    child3.setName("Organizationk" + k);
                    child3 = organizationService.save(child2);
                    children3.add(child3);

                    Set<Organization> children4 = Sets.newHashSet();
                    for(int l = 0; l < 10; l++) {
                        Organization child4 = new Organization();
                        child4.setName("Organizationl" + l);
                        child4 = organizationService.save(child3);
                        children4.add(child4);

                        Set<Asset> assets = Sets.newHashSet();
                        for (int o = 0; o < 8; o++) {
                            Asset asset = new Asset();
                            assets.add(asset);
                        }
                        assets = (Set<Asset>) assetService.saveAll(assets);

                        Organization finalChild4 = child4;
                        organizationHasAssetRelationService.saveAll(assets.stream().map(asset -> new OrganizationHasAssetRelation(finalChild4, asset)).collect(Collectors.toList()));
                    }

                    Organization finalChild3 = child3;
                    organizationChildOfRelationService.saveAll(children4.stream().map(c -> new OrganizationChildOfRelation(finalChild3, c)).collect(Collectors.toList()));
                }
                Organization finalChild2 = child2;
                organizationChildOfRelationService.saveAll(children3.stream().map(c -> new OrganizationChildOfRelation(finalChild2, c )).collect(Collectors.toList()));
            }
            Organization finalChild = child;
            organizationChildOfRelationService.saveAll(children2.stream().map(c -> new OrganizationChildOfRelation(finalChild, c)).collect(Collectors.toList()));
        }

        Organization finalMainOrganization = mainOrganization;
        organizationChildOfRelationService.saveAll(children.stream().map(child -> new OrganizationChildOfRelation(finalMainOrganization, child)).collect(Collectors.toList()));
    }

    @Test
    @Rollback(false)
//    @Ignore
    public void save4() {
        Organization mainOrganization = new Organization();
        mainOrganization.setName("bialystok case 4");
        mainOrganization = organizationService.save(mainOrganization);
        System.out.println("BSTOK 4 ID: " + mainOrganization.getId());

        Set<Organization> children = Sets.newHashSet();
        for (int i = 0; i < 10; i++) {
            Organization child = new Organization();
            child.setName("Organization4i" + i);
            child = organizationService.save(child);
            children.add(child);


            Set<Organization> children3 = Sets.newHashSet();
            for (int k = 0; k < 8; k++) {
                Organization child3 = new Organization();
                child3.setName("Organizationk" + i);
                child3 = organizationService.save(child);
                children3.add(child3);

                Set<Asset> assets = Sets.newHashSet();
                for (int o = 0; o < 1000; o++) {
                    Asset asset = new Asset();
                    assets.add(asset);
                }
                assets = (Set<Asset>) assetService.saveAll(assets);

                Organization finalChild3 = child3;
                organizationHasAssetRelationService.saveAll(assets.stream().map(asset -> new OrganizationHasAssetRelation(finalChild3, asset)).collect(Collectors.toList()));
            }
            Organization finalChild = child;
            organizationChildOfRelationService.saveAll(children.stream().map(c -> new OrganizationChildOfRelation(finalChild, c)).collect(Collectors.toList()));
        }

        Organization finalMainOrganization = mainOrganization;
        organizationChildOfRelationService.saveAll(children.stream().map(child -> new OrganizationChildOfRelation(finalMainOrganization, child)).collect(Collectors.toList()));
    }

    @Test
//    @Ignore
    public void calculateAverageFromDocument() {
        double average = organizationHasAssetRelationService.getAverageCapacityByOrganizationId(BIALYSTOK_CASE_1_ID);
        System.out.println("AVERAGE: " + average);
        assert average > 50;
    }

    @Test
//    @Ignore
    public void calculateSumFromDocument() {
        int sum = organizationHasAssetRelationService.getSumCapacityByOrganizationId(BIALYSTOK_CASE_1_ID);
        System.out.println("SUM: " + sum);
        assert sum > 50;
    }

    @Test
//    @Ignore
    public void calculateAverageFromGraph() {
        double average = organizationHasAssetRelationService.getAverageCapacityByOrganizationIdFromGraph(BIALYSTOK_CASE_1_ID);
        System.out.println("AVERAGE: " + average);
        assert average > 50;
    }

    @Test
//    @Ignore
    public void calculateSumFromGraph() {
        int sum = organizationHasAssetRelationService.getSumCapacityByOrganizationIdFromGraph(BIALYSTOK_CASE_1_ID);
        System.out.println("SUM: " + sum);
        assert sum > 50;
    }
}
