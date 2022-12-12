import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class Engine implements Runnable {
    @Override
    public void run() {
        try {
            runTaskById();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void runTaskById() throws IOException {
        System.out.println("Please enter a task ID:");
        String n = new BufferedReader(new InputStreamReader(in)).readLine();

        EntityManager em = Persistence
                            .createEntityManagerFactory("softuni")
                            .createEntityManager();

        switch (n)
        {
            case "2" -> task2(em);
            case "3" -> task3(em);
            case "4" -> task4(em);
            case "5" -> task5(em);
            case "6" -> task6(em);
            case "7" -> task7(em);
            case "8" -> task8(em);
            case "9" -> task9(em);
            case "10" -> task10(em);
            case "11" -> task11(em);
            case "12" -> task12(em);
            case "13" -> task13(em);
            default -> {
                System.out.println("Invalid task number, please re-enter task ID:");
                runTaskById();
            }
        }
        em.close();
    }

    public static void task2(EntityManager em) {
        Query q1 = em.createQuery("update Town t set t.name = upper(t.name) where length(t.name) <= 5");
        System.out.println(q1.executeUpdate());
    }

    public static void task3(EntityManager em) throws IOException {
        System.out.println("Please enter a full name to check for availability:");
        List<String> fullName = Arrays.stream(new BufferedReader(
                new InputStreamReader(in))
                .readLine()
                .split("\\s+"))
                .collect(Collectors.toList());
        String firstName = fullName.get(0);
        String lastName = fullName.get(1);
        Long result = em.createQuery("select count(e) from Employee e where " +
                        "e.firstName = :f_name and e.lastName = :l_name",
                Long.class)
                .setParameter("f_name", firstName)
                .setParameter("l_name", lastName)
                .getSingleResult();

        System.out.println(result != 0
                ? "Yes"
                : "No");
    }

    public static void task4(EntityManager em) {
        em.createQuery("select e from Employee e where e.salary > :min_salary",
                Employee.class)
                .setParameter("min_salary", BigDecimal.valueOf(50000L))
                .getResultStream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);
    }

    public static void task5(EntityManager em) throws IOException {
        System.out.println("Please enter a department name: ");
        String deptName = new BufferedReader(new InputStreamReader(System.in)).readLine();
        em.createQuery("select e from Employee e " +
                            "where e.department.name = :dept_name " +
                            "order by e.salary, e.id",
                Employee.class)
                .setParameter("dept_name", deptName)
                .getResultList()
                .forEach(e ->
                    System.out.printf("%s %s from %s - $%.2f\n",
                                        e.getFirstName(),
                                        e.getLastName(),
                                        e.getDepartment().getName(),
                                        e.getSalary())
                );
    }

    public static void task6(EntityManager em) throws IOException {
        System.out.println("Please enter an address: ");
        String addressName = new BufferedReader(new InputStreamReader(in)).readLine();
        Address address = new Address();
        address.setText(addressName);

        System.out.println("Please enter an employee last name: ");
        String employeeLastName = new BufferedReader(new InputStreamReader(in)).readLine();
        Employee employee = em.createQuery("select e from Employee e where e.lastName = :l_name",
                Employee.class)
                .setParameter("l_name", employeeLastName)
                .getSingleResult();

        em.getTransaction().begin();
        em.persist(address);
        employee.setAddress(address);
        em.getTransaction().commit();
    }

    public static void task7(EntityManager em) {
        em.createQuery("select a from Address a order by a.employees.size desc", Address.class)
                .getResultList()
                .stream().limit(10)
                .forEach(a -> System.out.printf("%s, %s - %d employees\n",
                        a.getText(),
                        a.getTown() == null
                                       ? "Unknown"
                                       : a.getTown().getName(),
                        a.getEmployees().size()));
    }

    public static void task8(EntityManager em) throws IOException {
        System.out.println("Please enter an employee id: ");
        long employeeId = Long.parseLong(new BufferedReader(new InputStreamReader(in)).readLine());
        Employee employee = em.find(Employee.class, employeeId);
        StringBuilder output = new StringBuilder();
        output.append(employee.getFirstName()).append(" ").append(employee.getLastName()).append(" - ").append(employee.getJobTitle())
                .append(System.lineSeparator());
        employee.getProjects()
                .stream()
                .map(Project::getName)
                .sorted()
                .forEach(e -> output.append("   ").append(e).append(System.lineSeparator()));
        System.out.println(output);
    }

    public static void task9(EntityManager em) {
        em.createQuery("select p from Project p order by p.startDate desc", Project.class)
                .setMaxResults(10)
                .getResultList()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> {
                    System.out.printf("Project name: %s\n" +
                            "   Project Description: %s ...\n" +
                            "   Project Start Date: %s\n" +
                            "   Project End Date: %s\n",
                            p.getName(),
                            p.getDescription().substring(0, 35),
                            p.getStartDate(),
                            p.getEndDate() != null ? p.getEndDate() : "null");
                });
    }

    public static void task10(EntityManager em) throws IOException {
        System.out.println("Please enter department IDs you want to update: ");
        Set<Long> ids = Arrays.stream(new BufferedReader(new InputStreamReader(in))
                .readLine()
                .split("\\D+"))
                .map(Long::parseLong)
                .collect(Collectors.toSet());

        em.getTransaction().begin();
        int affectedRows = em.createQuery("update Employee e " +
                                            " set e.salary = e.salary * (1 + 12/100) " +
                                            " where e.department.id in :id_list")
                .setParameter("id_list", ids)
                .executeUpdate();
        em.getTransaction().commit();

        System.out.printf("Updated rows: %d", affectedRows);
    }

    public static void task11(EntityManager em) throws IOException {
        System.out.println("Please enter a First name pattern: ");
        String pattern = new BufferedReader(new InputStreamReader(in)).readLine();
        pattern = pattern.concat("%");

        em.createQuery("select e from Employee e where e.firstName like :pattern", Employee.class)
                .setParameter("pattern", pattern)
                .getResultList()
                .forEach(e -> out.printf("%s %s - %s - ($%.2f)\n",
                        e.getFirstName(),
                        e.getLastName(),
                        e.getJobTitle(),
                        e.getSalary()));
    }

    @SuppressWarnings("unchecked")
    public static void task12(EntityManager em) {
        List<Object[]> result =
                em.createNativeQuery(
                        "select d.name, max(e.salary) as max_salary from employees e\n" +
                            "join departments d on d.department_id = e.department_id\n" +
                            "group by d.name\n" +
                            "having max_salary not between 30000 and 70000")
                .getResultList();

        for (Object[] objects : result) {
            String dept = (String)objects[0];
            BigDecimal salary = (BigDecimal)objects[1];
            out.printf("%s %.2f\n", dept, salary);
        }
    }

    public static void task13(EntityManager em) throws IOException {
        System.out.println("Please enter a town name: ");
        String townName = new BufferedReader(new InputStreamReader(in)).readLine();

        Town town = em.createQuery("select t from Town t where t.name = :t_name",
                Town.class)
                .setParameter("t_name", townName)
                .getSingleResult();

        List<Address> addresses = em.createQuery("select a from Address a where a.town.id = :t_id",
                Address.class)
                .setParameter("t_id", town.getId())
                .getResultList();

        em.getTransaction().begin();
        addresses.forEach(em::remove);
        em.getTransaction().commit();

        em.getTransaction().begin();
        em.remove(town);
        em.getTransaction().commit();

        out.printf("%d address in %s deleted", addresses.size(), townName);
    }
}
