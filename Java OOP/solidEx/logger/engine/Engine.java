package solidEx.logger.engine;

import solidEx.logger.api.Appender;
import solidEx.logger.api.Layout;
import solidEx.logger.api.Logger;
import solidEx.logger.enums.ReportLevel;
import solidEx.logger.model.loggers.MessageLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Engine implements Runnable {
    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int numberOfAppenders = Integer.parseInt(reader.readLine());
            Appender[] appenders = new Appender[numberOfAppenders];

            for (int i = 0; i < numberOfAppenders; i++) {
                String[] details = reader.readLine().split("\\s+");
                String appenderType = details[0];
                String layoutType = details[1];
                ReportLevel reportLevel = details.length == 2
                        ? ReportLevel.INFO : ReportLevel.valueOf(details[2]);
                Layout layout = this.getLayout(layoutType);
                Appender appender = this.getAppender(appenderType, layout);
                appender.setReportLevel(reportLevel);
                appenders[i] = appender;
            }
            Logger logger = new MessageLogger(appenders);
            String command = reader.readLine();
            while (!(command = reader.readLine()).equals("END")) {
                String[] commandDetails = command.split("\\|");
                ReportLevel reportLevel = ReportLevel.valueOf(commandDetails[0]);
                String dateTime = commandDetails[1];
                String message = commandDetails[2];
                this.logMessage(logger, reportLevel, dateTime, message);
            }
            System.out.println(logger.getLogInfo());
        } catch (IOException | ClassNotFoundException | NoSuchMethodException
                | IllegalAccessException | InvocationTargetException | InstantiationException exception) {
            exception.printStackTrace();
        }
    }

    private void logMessage(Logger logger, ReportLevel reportLevel, String dateTime, String message) throws InvocationTargetException, IllegalAccessException {
        Class<?> loggerClass = logger.getClass();
        Method method = Arrays.stream(loggerClass.getMethods())
                .filter(m -> m.getName().equalsIgnoreCase("log" + reportLevel))
                .findFirst()
                .orElseThrow();
        method.invoke(logger, dateTime, message);
    }

    private Appender getAppender(String appenderType, Layout layout) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName("solidEx.logger.model.appenders." + appenderType);
        return (Appender) clazz.getConstructor(Layout.class).newInstance(layout);
    }

    private Layout getLayout(String layoutType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName("solidEx.logger.model.layouts." + layoutType);
        return (Layout) clazz.getConstructor().newInstance();
    }
}
