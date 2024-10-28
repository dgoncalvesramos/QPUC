package org.qpuc;
import org.apache.jena.query.*;
import org.apache.jena.sparql.exec.http.QueryExecutionHTTP;

import java.util.ArrayList;
import java.util.List;

public class WikidataQuery {
    public static String executeSimpleQuery(String entityId, String propertyId) {
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

    public static List<String> excuteComplexQuery(String entityId, String propertyId, String labelName) {
        String sparqlEndpoint = "https://query.wikidata.org/sparql";
        String sparqlQuery = String.format(
                "PREFIX wd: <http://www.wikidata.org/entity/> " +
                        "PREFIX wdt: <http://www.wikidata.org/prop/direct/> " +
                        "PREFIX wikibase: <http://wikiba.se/ontology#> " +
                        "PREFIX bd: <http://www.bigdata.com/rdf#> " +
                        "SELECT ?%sLabel WHERE { " +
                        "  wd:%s wdt:%s ?%s. " +
                        "  SERVICE wikibase:label { bd:serviceParam wikibase:language \"[AUTO_LANGUAGE],en\". } " +
                        "}", labelName, entityId, propertyId, labelName);

        Query query = QueryFactory.create(sparqlQuery);
        List<String> resultsList = new ArrayList<>();

        try (QueryExecutionHTTP qExec = QueryExecutionHTTP.service(sparqlEndpoint).query(query).build()) {
            ResultSet results = qExec.execSelect();
            while (results.hasNext()) {
                QuerySolution solution = results.next();
                resultsList.add(solution.get(labelName+"Label").toString());
            }
        }
        return resultsList;
    }
}

