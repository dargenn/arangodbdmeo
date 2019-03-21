package com.acaisoft.arangodbdmeo;

import com.acaisoft.arangodbdmeo.graph.GraphConnector;
import com.arangodb.ArangoGraph;
import com.arangodb.entity.EdgeDefinition;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GraphTests {
    @Autowired GraphConnector graphConnector;

    @Test
    @Ignore
    public void check() {
        ArangoGraph graph = graphConnector.getGraph("organization-asset");

        EdgeDefinition edgeDefinition = new EdgeDefinition();
        edgeDefinition.collection("organizationHasAssetRelation");
        edgeDefinition.from("organizations");
        edgeDefinition.to("assets");

        graph.addEdgeDefinition(edgeDefinition);
        graph.db().create();
    }

    @Test
    public void query() {
        ArangoGraph graph = graphConnector.getGraph("organization-asset");

    }
}
