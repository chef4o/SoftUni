package solidEx.logger.model.layouts;

import solidEx.logger.api.Layout;

public class SimpleLayout implements Layout {
    @Override
    public String getLayout() {
        return "%s - %s - %s";
    }
}
