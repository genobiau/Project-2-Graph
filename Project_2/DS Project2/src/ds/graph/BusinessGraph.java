package ds.graph;
import java.util.ArrayList;
//undirected graph
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import Edge.Edge;
import Person.Person;
import ds.graph.Business;

//undirected
public class BusinessGraph {
	
	private float infectiveness;
	private ArrayList<Business> businessVertices;
	private ArrayList<Person> edges;
	private boolean isDirected;
	
	
	Person person = new Person(null, 0, 0);
	Edge edge = new Edge(person, person);
	Business business = new Business();
	
	public BusinessGraph(float socialHygienes) {
		socialHygienes = person.getSocialHygiene(); 
	}
	
	public boolean isDirected() {
		return this.isDirected;
	}
	
	public Business addPerson(Business b) throws Exception {
		Business business = new Business();
		if (this.businessVertices.contains(b)) {
			throw new Exception("Business already exists.");
		}
		this.businessVertices.add(business);
		return business;
	}
	
	public Business removePerson(Business b) throws Exception{
		if (!this.businessVertices.contains(b)) {
			throw new Exception("Business does not exist.");
		}
		this.businessVertices.remove(b);
		removeEdges(b);
		return b;
	}

	
	/**
	 * Add an edge (person) between the two businesses (vertices) in the graph. The graph is undirected, so 
	 * both People will need to list the other, in their list of contacts. 
	 * 
	 * If the edge already exists, this method should return true. 
	 *
	 * @param Business dest
	 * @param Person route
	 *set the max or highest weighted edge as the edge to be used 
	 */
	
	@SuppressWarnings("unlikely-arg-type")
	public void addEdges(Business dest, Person route){
		dest.addEdges(dest, route);
		if(business.getEdges().contains(dest)) {
			business.setInfectiveness(Math.max(infectiveness, infectiveness));
		}
		route.addEdges(dest, route);
		if(business.getEdges().contains(route)) {
			business.setInfectiveness(Math.max(infectiveness, infectiveness));}
	}	
	
	/**
	 * Remove the edge (Person) between the given Business from the graph. 
	 * If no edge existed between this business, this method should throw an EdgeDoesNotExist exception. 
	 * 
	 * @throws Exception
	 * @throws EdgeDoesNotExist
	 * @param Business dest
	 */
	
	
	public void removeEdges(Business dest) throws Exception {
		
		businessVertices.remove(dest);
		
		if(!this.businessVertices.contains(dest)) {
			throw new Exception("Business does not exist.");
		}
	}
	
	/**
	 * Implement a breadth-first search, from Person start to target. 
	 * This method should consider the graph unweighted: the order that the Persons are stored inside the contacts list will
	 * determine the order that the BFS operates. 
	 * 
	 * @throws PersonDoesNotExist if either start or target are not in the graph. 
	 * @param start
	 * @param target
	 * @return A list of nodes that must be traversed to get to target, from start. 
	 * @throws Exception 
	 */
	
	@SuppressWarnings("unlikely-arg-type")
	public ArrayList<Business> searchBFS(Person start, Queue<Person> target) throws Exception {
		ArrayList<Business> visitedVertices = new ArrayList<Person>();
		visitedVertices.add(start);
		
		Queue<Person> visitedQueue = new LinkedList<>();
		visitedQueue.add(start);
		
		if(!this.vertex.contains(start)) {
			throw new Exception("Edge does not exist.");
		}
		if(!this.vertex.contains(target)) {
			throw new Exception("Edge does not exist.");
		}
		while(!visitedQueue.isEmpty()) {
			Object current = visitedQueue.remove();
			System.out.println((((Person) (current)).getName()));
		for(Edge e: ((Person) current).getEdges()) {
			Person adjacent = e.getEnd();
			if(!visitedVertices.contains(adjacent)) {
				visitedVertices.add(adjacent);
				visitedQueue.add(adjacent);
			}
		}
	}
		//list of nodes matching the first path between nodes
		return  visitedVertices;
	}
	
	
}

