package interfacesAndAbstractionsEx.personMultiInterfacesExtend;

public class Robot implements Identifiable {

    private String id;
    private String model;

    public Robot(String id, String model) {
        this.setId(id);
        this.setModel(model);
    }

    public String getModel() {
        return model;
    }

    @Override
    public String getId() {
        return this.id;
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setModel(String model) {
        this.model = model;
    }
}
