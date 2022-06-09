package Person;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import Edge.Edge;
import ds.graph.BusinessGraph;
import ds.graph.Business;


public class Person {
	
	private String name;
	private int age;
	private float socialHygiene;
	private ArrayList<Edge> contacts;
	private boolean visited;
	private List<Person> adjacent = new LinkedList<>();
	private ArrayList<Business> edges;
	private float infectiveness;
	private Business start;
	private Person end;
	private Business dest;

	Edge edge = new Edge(null, null);
	Business business = new Business();
	
	public Person(String name, int age, float socialHygiene) {
		this.name = name;
		this.age = age;
		this.socialHygiene = edge.getInfectiveness();
		this.infectiveness = business.getInfectiveness();
		this.contacts = new ArrayList<Edge>();
		this.edges = new ArrayList<Business>();
		}


	public String getName() {
		return name;}
	
	public int getAge() {
		return age;
	}
	public float getSocialHygiene() {
		return socialHygiene;
	}
	
	public void setSocialHygiene(float socialHygiene) {
		this.socialHygiene = socialHygiene;
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
	
	public ArrayList<Business> getPersonEdges(){
		return this.edges;
	}
	
	public float getInfectiveness() {
		return infectiveness;
	}
	
	

	public Person(Business business1, Person route) {
		Business business = new Business();
		this.start = start;
		this.end = end;
		this.infectiveness = edge.getInfectiveness();
	}

	public Business getStart() {
		return this.start;
	}
	
	public Person getEnd() {
		return this.end;
	}

	public void addEdges(Business dest, Person route) {
		this.edges.add(new Business());
	}
	

	public Business getBusiness() {
		return this.dest;
	}
	
	public void setBusiness(String businessName){
		businessName = business.getBusinessName();
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void removeEdges(Business dest) {
		this.edges.removeIf(person-> this.getEnd().equals(dest));
	}
	//@Override
	//public String toString() {
	//	return "Person: " + this.name + this.age + this.contacts;
	//}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", socialHygiene=" + socialHygiene + ", contacts=" + contacts
				+ ", visited=" + visited + ", adjacent=" + adjacent + ", edges=" + edges + "]";
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
	

			

	
	

