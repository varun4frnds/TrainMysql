package web.com.ibm.bean;

public class Passenger implements Comparable<Passenger> {
String name;
int age;
char gender;

public Passenger(String name, int age, char gender) {
	super();
	this.name = name;
	this.age = age;
	this.gender = gender;
}
public Passenger() {
	
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
public char getGender() {
	return gender;
}
public void setGender(char gender) {
	this.gender = gender;
}
public String toString(Passenger p)
{
	return p.getName()+" "+p.getAge()+" "+p.getGender();
}
@Override
public int compareTo(Passenger other) {
	int res=name.compareTo(other.name);
	
	if(res!=0)
	{
    return res;
	}
	
	else
	{
		 Integer.compare(age, other.age);
	}
		return Integer.compare(gender, other.gender);
	}
}