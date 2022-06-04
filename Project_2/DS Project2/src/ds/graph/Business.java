package ds.graph;

import java.util.ArrayList;

import Edge.Edge;
import Person.Person;

public class Business {

	private String businessName;
	private ArrayList<Person> edges;
	private float infectiveness;
	
	Person person = new Person (null, 0, 0);
	
	public Business() {
		this.edges = new ArrayList<Person>();
	}
	
	public String getBusinessName() {
		return businessName;}
	
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	
	public float getInfectiveness() {
		return infectiveness;
	}
	
	public void setInfectiveness(float infectiveness) {
		this.infectiveness = infectiveness;
	}
	
	public ArrayList<Person> getEdges(){
		return this.edges;
	}
	
	public void setEdges(ArrayList<Person> edges){
		this.edges = edges;
	}
	
	public void addEdges(Business dest, Person route) {
		this.edges.add(new Person(this, route));
	}
	
	public void removeEdges(Business dest) {
		this.edges.removeIf(person-> person.getEnd().equals(dest));
	}
}