package com.acaisoft.arangodbdmeo.graph;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDatabase;
import com.arangodb.ArangoGraph;
import org.springframework.stereotype.Component;

@Component
public class GraphConnector {
    public ArangoGraph getGraph(String graphName) {
        ArangoDB arango = new ArangoDB.Builder().build();
        ArangoDatabase db = arango.db("spring-demo");
        return db.graph(graphName);
    }
}
