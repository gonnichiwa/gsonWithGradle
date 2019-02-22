package jsonToJava;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Arrays;
import java.util.List;

public class JsonToJavaPrint {
	public static void main(String[] args){
		String json = "{\"brand\" : \"jeep\", \"doors\" : 3}";

		Gson gson = new Gson();
		Car car = gson.fromJson(json, Car.class);

		System.out.println("CarBrand:"+car.brand+"\nCarDoors:"+car.doors);

		/* **** json(list) To java***** */

		String jsonString =
				"[" +
						"{'id' : '39382', 'name':'Min','age':26,'address':'Seoul'}," +
						"{'id' : '39382', 'name':'greg','age':33,'address':'Busan'}," +
						"{'id' : '3933', 'name':'Jen','age':22, 'address':'Busan'}" +
				"]";
		// list (method 1)
		List<Member> list = gson.fromJson(jsonString, new TypeToken<List<Member>>(){}.getType());
		for(Member member : list){
			System.out.println("["+member.id+","+member.name+","+member.address+"]");
		}

		System.out.println("===============");

		// array (method 2)
		Member[] array = gson.fromJson(jsonString, Member[].class);
		List<Member> listArr = Arrays.asList(array);
		for(Member member : listArr){
			System.out.println("["+member.id+","+member.name+","+member.address+"]");
		}
	}
}
class Car {
	String brand;
	int doors;
}

class Member {
	String id;
	String name;
	int age;
	String address;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
