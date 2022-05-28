# Project-2-Graph
echo "# Project-2-Graph" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/genobiau/Project-2-Graph.git
git push -u origin main


package Person;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import Edge.Edge;

public class Person {
	
	private String name;
	private int age;
	private float socialHygiene;
	private ArrayList<Edge> contacts;

	public Person(String name, int age, float socialHygiene) {
		this.name = name;
		this.age = age;
		this.socialHygiene =socialHygiene;
		this.contacts = new ArrayList<Edge>();
		}
	
	public String getName() {
		return name;}
	
	public int getAge() {
		return age;
	}
	public float getSocialHygiene() {
		return socialHygiene;
	}
	
	public void addEdge(Person endVertex, float weight) {
		this.contacts.add(new Edge(this, endVertex));
	}
	
	public void removeEdge(Person endVertex) {
		this.contacts.removeIf(edge-> edge.getEnd().equals(endVertex));

	}
	
	public ArrayList<Edge> getEdges(){
		return this.contacts;
	}
	
	@Override
	public String toString() {
		return "Person: " + this.name + this.age + this.contacts;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(age, contacts,name, socialHygiene);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(contacts, other.contacts)
				&& Objects.equals(name, other.name)
				&& Float.floatToIntBits(socialHygiene) == Float.floatToIntBits(other.socialHygiene);
	}
}
	
