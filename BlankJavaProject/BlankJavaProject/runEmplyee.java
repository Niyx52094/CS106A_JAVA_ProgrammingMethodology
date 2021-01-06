
/*
* File: EmployeeExample.java
* --------------------------
* This file contains a sample program using the Employee class. It reads in
* employee information until we read in the empty string, randomly promotes
* one of the employees entered, and then prints out all employees.
*/
import java.util.*;
import acm.program.*;
import acm.util.*;
public class runEmplyee extends ConsoleProgram {
public void run() {
ArrayList<S7_Employee> employees = readInEmployees();
// Randomly promote a single employee
int randomEmployeeNum = rgen.nextInt(employees.size());
S7_Employee employeeToPromote = employees.get(randomEmployeeNum);
employeeToPromote.promote();
println(employeeToPromote.getName() + " was promoted!\n\n");
printEmployees(employees);
}
/*
¨C 5 ¨C
* Reads in a list of employees until the empty string is entered.
* Returns an ArrayList of all Employees entered.
*/
private ArrayList<S7_Employee> readInEmployees() {
ArrayList<S7_Employee> employees = new ArrayList<S7_Employee>();
while (true) {
String name = readLine("---\nName: ");
if (name.equals("")) {
break;
}
String title = readLine("Title: ");
int salary = readInt("Salary ($): ");
S7_Employee newEmployee = new S7_Employee(name, title);
newEmployee.setSalary(salary);
employees.add(newEmployee);
}
return employees;
}
/* Prints the name, title and salary for each of the given employees. */
private void printEmployees(ArrayList<S7_Employee> employees) {
for (int i = 0; i < employees.size(); i++) {
S7_Employee currentEmployee = employees.get(i);
println("--- " + currentEmployee.getName() + " (" +
currentEmployee.getTitle() + ") ---");
println("Salary: $" + currentEmployee.getSalary());
}
}
private RandomGenerator rgen = RandomGenerator.getInstance();
}