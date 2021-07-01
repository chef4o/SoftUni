package interfacesAndAbstractions.borderControl;

public class Robot extends Subject implements Identifiable {

    public Robot(String model, String id) {
        super(model, id);
    }

    @Override
    public String getId() {
        return super.getId();
    }

    public String getModel() {
        return super.getIdentifier();
    }
}
