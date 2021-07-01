package interfacesAndAbstractions.borderControl;

public class Subject {

    private String identifier;
    private String id;

    public Subject(String identifier, String id) {
        this.identifier = identifier;
        this.id = id;
    }

    protected String getIdentifier() {
        return this.identifier;
    }

    protected String getId() {
        return this.id;
    }
}