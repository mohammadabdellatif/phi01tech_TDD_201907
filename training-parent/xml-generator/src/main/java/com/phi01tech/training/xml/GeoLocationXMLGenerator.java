package com.phi01tech.training.xml;

import java.util.Collection;

public class GeoLocationXMLGenerator {

    public String toXml(Collection<GeoLocation> locations) {
        XMLGenerationContext generationContext = new XMLGenerationContext();

        generationContext.appendRoot();
        for (GeoLocation location : locations) {
            generationContext.appendLocation(location);
        }
        generationContext.appendRootEnd();
        return generationContext.xml();
    }

    private class XMLGenerationContext {

        StringBuilder sb = new StringBuilder();

        void appendRoot() {
            sb.append("<locations>");
        }

        void appendRootEnd() {
            sb.append("</locations>");
        }

        void appendLocation(GeoLocation location) {
            sb.append("<location>");
            sb.append("<lat>").append(location.latitude()).append("</lat>");
            sb.append("<lon>").append(location.longitude()).append("</lon>");
            sb.append("</location>");
        }

        String xml() {
            return sb.toString();
        }

    }
}
