package reflections;

import java.io.Serializable;
import java.lang.reflect.Constructor;

public class Employee implements Serializable {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Employee() {
        name = "I am your default name";
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void play() {

        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Amit");

        // I could even do this:
        // Class employeeClass = Class.forName(reflections.Employee);
        Class employeeClass = Employee.class;
        playInterfaces(employeeClass);
        playSuperClass(employeeClass);
        playClassCreation(employeeClass);
    }

    private static void playClassCreation(Class cls) {
        System.out.printf("Creating an object of %s\n", cls.getSimpleName());
        Employee employee = (Employee) getObject(cls);
        System.out.printf("The default value of the dynamic object is %s", employee.getName());
    }

    private static Object getObject(Class cls) {
        try {
            Constructor<?> constructor = cls.getConstructor();
            return constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static void playSuperClass(Class cls) {
        System.out.printf("Super class of %s\n", cls.getSimpleName());
        System.out.println(cls.getSuperclass());
        System.out.println("==============================");
    }

    private static void playInterfaces(Class cls) {

        System.out.printf("Interfaces implemented by %s\n", cls.getSimpleName());

        Class<?>[] interfaces = cls.getInterfaces();
        for (Class iFace :
                interfaces) {
            System.out.println(iFace.getSimpleName());

        }
        System.out.println("==============================");

    }
}
