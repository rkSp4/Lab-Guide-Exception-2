package Management_Exc;

import java.util.List;
import java.util.NoSuchElementException;

public class Main {

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param manager the manager to give the salary
     * @param employee the employee to receive the raise
     * @param salary the salary increase to be given
     * @throws ClassCastException when manager or employee is not a manager or employee
     * @throws IllegalArgumentException when salary is invalid
     * @throws NoSuchElementException when given manager or employee does not exist in the list of persons
     */
    public static void giveRaise(List<Person> persons, String manager, String employee, double salary)  {
        Manager managerP = null;
        Employee employeeP = null;

        for (Person p : persons) {
            if (p.getName().equals(manager)) {
                if (p instanceof Manager){
                    managerP = (Manager) p;
                } else {
                    throw new ClassCastException(p.getName()+" is not a manager");
                }
            } else if (p.getName().equals(employee)){
                if (p instanceof Employee){
                    employeeP = (Employee) p;
                } else {
                    throw new ClassCastException(p.getName()+" is not an employee");
                }
            }
        }

        if (salary<0)
            throw new IllegalArgumentException("salary is negative");

        if (managerP==null){
            throw new NoSuchElementException(manager+" does not exist");
        }
        if (employeeP==null){
            throw new NoSuchElementException(employee+" does not exist");
        }

        managerP.giveRaise(employeeP, salary);
    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param developer the developer to be assigned
     * @param manager the manager assigned to the dev
     * @throws ClassCastException when manager or developer is not a manager or employee
     * @throws NoSuchElementException when given manager or developer does not exist in the list of persons
     * @throws IllegalStateException when developer already has a manager
     */
    public static void assignPM(List<Person> persons, String developer, String manager) {
        Manager managerP = null;
        Developer developerP = null;

        for (Person p : persons) {
            if (p.getName().equals(manager)) {
                if (p instanceof Manager) {
                    managerP = (Manager) p;
                } else {
                    throw new ClassCastException(p.getName()+" is not a manager");
                }
            } else if (p.getName().equals(developer)) {
                if (p instanceof Developer) {
                    developerP = (Developer) p;
                } else {
                    throw new ClassCastException(p.getName()+" is not a developer");
                }
            }
        }

        if (managerP==null){
            throw new NoSuchElementException(manager+" does not exist");
        }

        if (developerP==null){
            throw new NoSuchElementException(developer+" does not exist");
        }

        if (developerP.getProjectManager() == null){
            developerP.setProjectManager(managerP);
        } else {
            throw new IllegalStateException(developerP.getName()+" already has a manager: "+developerP.getProjectManager().getName());
        }
    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param customer the customer to speak to the employee
     * @param employee the employee to be spoken to
     * @return the dialogue of the customer to the employee
     * @throws ClassCastException when given customer or employee is not what they are
     * @throws NoSuchElementException when given customer or employee is not in the list of persons
     */
    public static String customerSpeak(List<Person> persons, String customer, String employee) {
        Employee employeeP = null;
        Customer customerP = null;

        for (Person p : persons) {
            if (p.getName().equals(employee)) {
                if (p instanceof Employee) {
                    employeeP = (Employee) p;
                } else {
                    throw new ClassCastException(p.getName()+" is not an employee");
                }
            } else if (p.getName().equals(customer)) {
                if (p instanceof Customer) {
                    customerP = (Customer) p;
                } else {
                    throw new ClassCastException(p.getName()+" is not a customer");
                }
            }
        }

        if (employeeP==null){
            throw new NoSuchElementException(employee+" does not exist");
        }

        if (customerP==null){
            throw new NoSuchElementException(customer+" does not exist");
        }

        return customerP.speak(employeeP);
    }
}
