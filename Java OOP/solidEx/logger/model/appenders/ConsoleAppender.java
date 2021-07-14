package solidEx.logger.model.appenders;

import solidEx.logger.api.Appender;
import solidEx.logger.api.Layout;

public class ConsoleAppender extends BaseAppender {
    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String message) {
        System.out.println(message);
    }
}
