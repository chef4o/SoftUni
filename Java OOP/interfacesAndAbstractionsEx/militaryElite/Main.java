package interfacesAndAbstractionsEx.militaryElite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<PrivateImpl> allPrivates = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commands = command.split(" ");
            String soldierType = commands[0];
            int id = Integer.parseInt(commands[1]);
            String firstName = commands[2];
            String lastName = commands[3];
            double salary = Double.parseDouble(commands[4]);

            switch (soldierType) {
                case "Private":
                    PrivateImpl priv = new PrivateImpl(id, firstName, lastName, salary);
                    allPrivates.add(priv);
                    System.out.println(priv);
                    break;
                case "LeutenantGeneral":
                    LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);
                    addPrivates(lieutenantGeneral, allPrivates, commands);
                    System.out.println(lieutenantGeneral.toString());
                    break;
                case "Commando":
                    try {
                        String corp = commands[5];
                        CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary, corp);
                        addMissions(commands, commando);
                        System.out.println(commando);
                        printMission(commando);
                        break;
                    } catch (IllegalArgumentException ignored) {
                        command = scanner.nextLine();
                        continue;
                    }
                case "Engineer":
                    try {
                        String corp = commands[5];
                        EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, corp);
                        addRepairs(commands, engineer);
                        System.out.println(engineer);
                        printRepairs(engineer);
                    } catch (IllegalArgumentException ignored) {
                        command = scanner.nextLine();
                        continue;
                    }
                    break;
                case "Spy":
                    String codeName = commands[4];
                    SpyImpl spy = new SpyImpl(id, firstName, lastName, codeName);
                    System.out.println(spy.toString());
            }

            command = scanner.nextLine();
        }

    }

    private static void printRepairs(EngineerImpl engineer) {
        for (Repair repair : engineer.getRepairs()) {
            System.out.println(repair.toString());
        }
    }

    private static void addRepairs(String[] commands, EngineerImpl engineer) {
        for (int i = 6; i < commands.length; i += 2) {
            String repairName = commands[i];
            int hours = Integer.parseInt(commands[i + 1]);
            Repair repair = new Repair(repairName, hours);
            engineer.addRepair(repair);
        }
    }

    private static void printMission(CommandoImpl commando) {
        for (Mission mission : commando.getMissions()) {
            if (mission.getState().equals(State.inProgress)) {
                System.out.println(mission.toString());
            }
        }
    }

    private static void addMissions(String[] commands, CommandoImpl commando) {
        for (int i = 6; i < commands.length; i += 2) {
            String missionName = commands[i];
            String state = commands[i + 1];
            Mission mission = new Mission(missionName, state);
            commando.addMission(mission);
        }
    }

    private static void addPrivates(LieutenantGeneralImpl lieutenantGeneral,
                                    List<PrivateImpl> allPrivates,
                                    String[] commands) {

        for (int i = 5; i < commands.length; i++) {
            for (PrivateImpl p : allPrivates) {
                if (p.getId() == Integer.parseInt(commands[i])) {
                    lieutenantGeneral.addPrivate(p);
                    allPrivates.remove(p);
                    break;
                }
            }
        }
    }
}