package solidEx.logger.model.layouts;

import solidEx.logger.api.Layout;

public class XmlLayout implements Layout {
    @Override
    public String getLayout() {
        StringBuilder output = new StringBuilder();
        output.append("<log>").append(System.lineSeparator())
                .append("<date>%s</date>").append(System.lineSeparator())
                .append("<level>%s</level>").append(System.lineSeparator())
                .append("<message>%s</message>").append(System.lineSeparator())
                .append("</log>");

        return output.toString();
    }
}
