package solidEx.logger.model.appenders;

import solidEx.logger.api.File;
import solidEx.logger.api.Layout;
import solidEx.logger.model.files.LogFile;

public class FileAppender extends BaseAppender {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.setFile(new LogFile());
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void append(String message) {
        this.file.write(message);
    }

    @Override
    public String toString() {
        return String.format("%s, File size: %d", super.toString(), this.file.getSize()) ;
    }
}
