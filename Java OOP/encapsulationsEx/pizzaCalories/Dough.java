package encapsulationsEx.pizzaCalories;

public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        PizzaValidate.doughCharacteristics(flourType);
        this.flourType= flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        PizzaValidate.doughCharacteristics(bakingTechnique);
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        PizzaValidate.doughWeight(weight);
        this.weight = weight;
    }

    public double calculateCalories() {
        return (2 * weight)
                * DoughConstants.valueOf(flourType.toUpperCase()).modifier
                * DoughConstants.valueOf(bakingTechnique.toUpperCase()).modifier;
    }
}
