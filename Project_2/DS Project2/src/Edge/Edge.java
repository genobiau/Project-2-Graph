package Edge;


import java.util.ArrayList;

import Person.Person;

public class Edge {

	private Person start;
	private Person end;
	private float infectiveness;

	public Edge(Person startP, Person endP) {
		Person person = new Person(null, 0, 0);
		this.start = startP;
		this.end = endP;
		this.infectiveness = person.getSocialHygiene() ;
	}

	public Person getStart() {
		return this.start;
	}
	
	public Person getEnd() {
		return this.end;
	}
	
	//setter method for infectiveness:weight
	public float setInfectiveness(float infection) {
		Person person = new Person(null, 0,0);
		infection = (person.getAge()/100)-(person.getAge() * person.getSocialHygiene());
		if (infection <0 || infection >1){
			throw new ArrayIndexOutOfBoundsException("Out of range: Infectiveness should be between 0 and 1.");	
		}
		return infection;
	}
	
	//getter for infectiveness:weight
	public float getInfectiveness() {
		return  this.infectiveness;
	}

}
