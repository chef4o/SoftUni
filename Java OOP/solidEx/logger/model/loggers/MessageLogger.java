package solidEx.logger.model.loggers;

import solidEx.logger.api.Appender;
import solidEx.logger.api.Logger;
import solidEx.logger.enums.ReportLevel;

public class MessageLogger implements Logger {
    private Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = new Appender[appenders.length];
        for (int i = 0; i < appenders.length; i++) {
            this.appenders[i] = appenders[i];
        }
    }

    @Override
    public void logInfo(String dateTime, String message) {
        this.generateLogMessage(dateTime, ReportLevel.INFO, message);
    }

    @Override
    public void logWarning(String dateTime, String message) {
        this.generateLogMessage(dateTime, ReportLevel.WARNING, message);
    }

    @Override
    public void logError(String dateTime, String message) {
        this.generateLogMessage(dateTime, ReportLevel.ERROR, message);
    }

    @Override
    public void logCritical(String dateTime, String message) {
        this.generateLogMessage(dateTime, ReportLevel.CRITICAL, message);
    }

    @Override
    public void logFatal(String dateTime, String message) {
        this.generateLogMessage(dateTime, ReportLevel.FATAL, message);
    }

    private void generateLogMessage(String dateTime, ReportLevel logType, String message) {
        for (Appender appender : this.appenders) {
            appender.appendMessage(dateTime, logType, message);
        }
    }

    @Override
    public String getLogInfo() {
        StringBuilder output = new StringBuilder();
        output.append("Logger info").append(System.lineSeparator());
        for (Appender appender : appenders) {
            output.append(appender).append(System.lineSeparator());
        }
        return output.toString().trim();
    }
}
