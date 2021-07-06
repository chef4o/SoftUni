package interfacesAndAbstractionsEx.militaryElite;

public class Mission {
    private String codeName;
    private State state;
    public Mission(String codeName, String state){
        this.setCodeName(codeName);
        this.setState(state);
    }

    public String getCodeName() {
        return this.codeName;
    }

    public State getState() {
        return this.state;
    }

    private void setCodeName(String codeName) {
        this.codeName = codeName;
    }


    private void setState(String state) {
        try {
            this.state = State.valueOf(state);
        }catch (Exception e){
            throw new IllegalArgumentException("Not a valid state");
        }
    }

    public void completeMission(){
        this.state = State.finished;
    }

    @Override
    public String toString() {
        return String.format("  Code Name: %s State: %s",codeName,state);
    }
}
