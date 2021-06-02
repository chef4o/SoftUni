package DefiningClassesEx.Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> peopleDatabase = new LinkedHashMap<>();

        String input;
        while (!(input = scanner.nextLine()).equals("End")) {

            String[] inputData = input.split("\\s+");
            String currentName = inputData[0];
            String currentAsset = inputData[1];

            Person currentPerson = new Person(currentName);
            if (!peopleDatabase.containsKey(currentName)) {
                peopleDatabase.put(currentName, currentPerson);
            }

            switch (currentAsset) {
                case "car":
                    String currentCarModel = inputData[2];
                    int currentCarSpeed = Integer.parseInt(inputData[3]);
                    peopleDatabase.get(currentName)
                                  .car = new Car(currentCarModel,currentCarSpeed);
                    break;
                case "children":
                    String currentChildName = inputData[2];
                    String currentChildBirthday = inputData[3];
                    Children currentChild = new Children(currentChildName, currentChildBirthday);
                    peopleDatabase.get(currentName)
                                  .children
                                  .allChildren
                                  .add(currentChild);
                    break;
                case "company":
                    String currentCompanyName = inputData[2];
                    String currentDepartment = inputData[3];
                    double currentSalary = Double.parseDouble(inputData[4]);
                    peopleDatabase.get(currentName)
                                  .company = new Company(currentCompanyName, currentDepartment, currentSalary);
                    break;
                case "parents":
                    String currentParentName = inputData[2];
                    String currentParentBirthday = inputData[3];
                    Parents currentParent = new Parents(currentParentName, currentParentBirthday);
                    peopleDatabase.get(currentName)
                                  .parents
                                  .family
                                  .add(currentParent);
                    break;
                case "pokemon":
                    String currentPokemonName = inputData[2];
                    String currentPokemonType = inputData[3];
                    Pokemon currentPokemon = new Pokemon(currentPokemonName, currentPokemonType);
                    peopleDatabase.get(currentName)
                                  .pokemon
                                  .pokemonsDatabase
                                  .add(currentPokemon);
                    break;
            }
        }

        input = scanner.nextLine();
        System.out.println(peopleDatabase.get(input).toString());
    }
}
