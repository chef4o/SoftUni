package abstractionsEx.trafficLights;

public class TrafficLight {
    private LightColor lightColor;

    TrafficLight(LightColor lightColor) {
        this.lightColor = lightColor;
    }

    public void updateLightColor() {
        switch (lightColor) {
            case RED:
                this.lightColor = LightColor.GREEN;
                break;
            case GREEN:
                this.lightColor = LightColor.YELLOW;
                break;
            case YELLOW:
                this.lightColor = LightColor.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return this.lightColor.toString();
    }
}
