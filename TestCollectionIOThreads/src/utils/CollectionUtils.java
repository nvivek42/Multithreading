package utils;

import static com.app.core.Subject.DBT;
import static com.app.core.Subject.JAVA;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.app.core.Student;
import static com.app.core.Subject.*;

public interface CollectionUtils {
	// add a static method to return populated map of students
	static HashMap<String, Student> populateMap() {
		HashMap<String, Student> map = new HashMap<>();
		map.put("dac-001", new Student("dac-001", "Riya", LocalDate.parse("1995-03-17"), JAVA, 7.59));
		map.put("dac-008", new Student("dac-008", "Anish", LocalDate.parse("1998-01-29"), ANGULAR, 7.9));
		map.put("dac-003", new Student("dac-003", "Rama", LocalDate.parse("1995-12-09"), DBT, 7.81));
		map.put("dac-004", new Student("dac-004", "Priya", LocalDate.parse("1997-01-01"), JAVA, 8.12));
		map.put("dac-002", new Student("dac-002", "Mihir", LocalDate.parse("1996-10-21"), JAVA, 7.47));
		map.put("dac-007", new Student("dac-007", "Rahul", LocalDate.parse("1997-07-22"), REACT, 8.51));
		map.put("dac-005", new Student("dac-005", "Shreya", LocalDate.parse("1999-08-13"), WT, 8.3));
		map.put("dac-009", new Student("dac-009", "Ritesh", LocalDate.parse("1995-03-12"), JAVA, 7.5));
		map.put("dac-011", new Student("dac-011", "Rutu", LocalDate.parse("1997-08-29"), ANGULAR, 8.33));
		map.put("dac-006", new Student("dac-006", "Sahil", LocalDate.parse("1999-12-09"), DBT, 8.56));
		map.put("dac-010", new Student("dac-010", "Meeta", LocalDate.parse("1998-01-01"), JAVA, 7.19));
		map.put("dac-020", new Student("dac-020", "Kirti", LocalDate.parse("1996-11-21"), JAVA, 9.08));
		map.put("dac-014", new Student("dac-014", "Raj", LocalDate.parse("1997-06-20"), REACT, 8.55));
		map.put("dac-015", new Student("dac-015", "Pallavi", LocalDate.parse("1999-08-23"), WT, 8.39));
		return map;
	}
	//add a static method to sort hashmap of students as per gpa n ret it in a list
	static List<Student> sortStudentsAsGPA(HashMap<String, Student>students)
	{
		return students.values() //Collection<Student>
				.stream() //Stream<Student> : unsorted
				.sorted(Comparator.comparing(Student::getGpa)) //Stream<Student> : sorted by gpa
				.collect(Collectors.toList());
				
	}
	//add a static method to sort hashmap of students as per dob n ret it in a list
	static List<Student> sortStudentsAsDoB(HashMap<String, Student>students)
	{
		return students.values() //Collection<Student>
				.stream() //Stream<Student> : unsorted
				.sorted(Comparator.comparing(Student::getDob)) //Stream<Student> : sorted by dob
				.collect(Collectors.toList());
				
	}
	
	
	
	
}
