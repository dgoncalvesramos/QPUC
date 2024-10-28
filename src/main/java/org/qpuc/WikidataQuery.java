package org.qpuc;
import org.apache.jena.query.*;
import org.apache.jena.sparql.exec.http.QueryExecutionHTTP;

public class WikidataQuery {
    String entityId ;
    String propertyId ;

    public static String executeQuery(String entityId, String propertyId) {
        String sparqlEndpoint = "https://query.wikidata.org/sparql";
        String sparqlQuery = String.format(
                "PREFIX wd: <http://www.wikidata.org/entity/> " +
                        "PREFIX wdt: <http://www.wikidata.org/prop/direct/> " +
                        "SELECT ?value WHERE { wd:%s wdt:%s ?value. }",
                entityId, propertyId);

        Query query = QueryFactory.create(sparqlQuery);
        try (QueryExecutionHTTP qExec = QueryExecutionHTTP.service(sparqlEndpoint).query(query).build()) {
            ResultSet results = qExec.execSelect();
            if (results.hasNext()) {
                QuerySolution solution = results.next();
                return solution.get("value").toString();
            }
        }
        return null;
    }
}

