package expdemo.stream.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListObjects {

	static List<User> users = Arrays.asList(
			new User("C", 30),
			new User("D", 34),
			new User("A", 32),
			new User("B", 28),
			new User("E", 45),
			new User("F", 46));
	
	
	public static void main(String[] args) {
		
		//Sort by age
		List<User> listByAge = users.stream()
				.sorted(Comparator.comparingInt(User::getAge))
				.collect(Collectors.toList());
		listByAge.forEach(System.out::println);
		
		//Sort by age reverse
		List<User> listByAgeRe = users.stream()
				.sorted(Comparator.comparingInt(User::getAge).reversed())
				.collect(Collectors.toList());
		listByAgeRe.forEach(System.out::println);
		
		//sort by name
		List<User> listByName = users.stream()
				.sorted(Comparator.comparing(User::getName))
				.collect(Collectors.toList());
		listByName.forEach(System.out::println);
	}
	
	
	static class User {
		
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
		
	}
}
