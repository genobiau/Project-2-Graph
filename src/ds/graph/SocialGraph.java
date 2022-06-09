package ds.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Person.Person;
import ds.graph.BreadthFirstSearch.Node;
import Edge.Edge;



//undirected graph
public class SocialGraph {
	private ArrayList<Person> vertex;
	private boolean isDirected;
	private boolean isInfected;
	
	Person person = new Person(null, 0, 0);
	
	public SocialGraph() {
		this.vertex = new ArrayList<Person>();
		boolean inputIsDirected = false;
		this.isDirected = inputIsDirected;
		boolean inputIsInfected = false;
		this.isInfected = inputIsInfected;
		
	}
	
	public boolean isDirected() {
		return this.isDirected;
	}
	
	public boolean isInfected() {
		return this.isInfected;
	}
	
	public ArrayList<Person> getVertex(){
		return this.vertex;
	}
	
	public Person getPersonValue(String value) {
		for(Person persons: this.vertex) {
			if(persons.getName()== value) {
				return persons;
			}
		}
		return null;
	}
	/**
	 * Add the given person to the graph. The person needs to be added to the list of vertices.
	 * 
	 * @param p
	 * @return person
	 * @throws Exception 
	 * @throws PersonAlreadyExists If the person is already present in the graph, 
	 *  		this method should throw a PersonAlreadyPresent exception. 
	 */
	public Person addVertex(Person p) throws Exception {
		Person person = new Person(null, 0, 0);
		if (this.vertex.contains(p)) {
			throw new Exception("Person already exists.");
		}
		this.vertex.add(person);
		return person;
	}
	
	
	/**
	 * Remove the given Person from the graph. Any edges to this person should also be removed. 
	 * 
	 * @throws Exception
	 * @throws PersonDoesNotExist If the given person is not found inside the graph. 
	 * @param p
	 * @return p
	 */
	public Person removeVertex(Person p) throws Exception{
		if (!this.vertex.contains(p)) {
			throw new Exception("Person does not exist.");
		}
		this.vertex.remove(p);
		removeEdge(p, p);
		return p;
	}
	
	/**
	 * Add an edge between the two people (vertices) in the graph. The graph is undirected, so 
	 * both People will need to list the other, in their list of contacts. 
	 * 
	 * If the edge already exists, this method should return true. 
	 *
	 * @param person1
	 * @param person2
	 * @throws Exception 
	 * 
	 * @throws PersonDoesNotExist	If the person is not found within the graph. 
	 */
	public void addEdge(Person person1, Person person2) throws Exception {
		person1.addEdge(person2, 0);
		if(!this.vertex.contains(person1)) {
			throw new Exception("Person does not exist.");}
		
		person2.addEdge(person1, 0);
		if(!this.vertex.contains(person2)) {
			throw new Exception("Person does not exist.");
		}
	}
	
	/**
	 * Remove the edge between the given People from the graph. 
	 * If no edge existed between these people, this method should throw an EdgeDoesNotExist exception. 
	 * 
	 * @throws Exception
	 * @throws EdgeDoesNotExist
	 * @param person1
	 * @param person2
	 */
	public void removeEdge(Person person1, Person person2) throws Exception {
		
		person1.removeEdge(person2);
		person2.removeEdge(person1);
		
		if(!this.isDirected) {
			person2.removeEdge(person1);
		}
		if(!this.vertex.contains(person1)) {
			throw new Exception("Edge does not exist.");
		}
		if(!this.vertex.contains(person2)) {
			throw new Exception("Edge does not exist.");
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
	public ArrayList<Person> searchBFS(Person start, Queue<Person> target) throws Exception {
		ArrayList<Person> visitedVertices = new ArrayList<Person>();
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
	
	/**
	 * Implement a breadth-first search, from Person start to target.
	 * The weights associated with each edge should determine the order that the BFS operates. 
	 * Higher weights are preferred over lower weights. The weight is found by calling getInfectiveness() on the Person. 
	 * 
	 * @throws PersonDoesNotExist if either start or target are not in the graph. 
	 * @param start
	 * @param target
	 * @return A list of nodes that must be traversed to get to target, from start. 
	 */
	public ArrayList<Person> searchWeightedBFS(Person start, ArrayList<Person> target) {
		return null;
	}
	
		
	/**
	 * Implement a depth-first search, from Person start to target.  
	 * This method should consider the graph unweighted: the order that the Persons are stored inside the contacts list will
	 * determine the order that the DFS operates. 
 	 * @throws PersonDoesNotExist if either start or target are not in the graph. 	
	 * @param start
	 * @param target
	 * @return A list of nodes that must be traversed to get to target, from start. 
	 * @throws Exception 
	 */
	@SuppressWarnings("unlikely-arg-type")
	public ArrayList<Person> searchDFS(Person start, ArrayList<Person> target) throws Exception {
		if(!this.vertex.contains(start)) {
			throw new Exception("Edge does not exist.");
		}
		if(!this.vertex.contains(target)) {
			throw new Exception("Edge does not exist.");
		}
		for (Edge e: start.getEdges()) {
			Person adjacent = e.getEnd();
			if (!target.add(adjacent));
			this.searchDFS(adjacent, target);
		}

		return target;
	}
	
	/**
	 * Implement a depth-first search, from Person start to target.  
	 * The weights associated with each edge should determine the order that the DFS operates. 
	 * Higher weights are preferred over lower weights. The weight is found by calling getInfectiveness() on the Person. 
	 * 
 	 * @throws PersonDoesNotExist if either start or target are not in the graph. 	
	 * @param start
	 * @param target
	 * @return A list of nodes that must be traversed to get to target, from start. 
	 */
	public ArrayList<Person> searchWeightedDFS(Person start, Person target) {
		return null;
	}
	
	/**
	 * This method should return an int value showing the total number of contacts-of-contacts of the start person. 
	 * This is the equivalent to doing a BFS around the start person, and 
	 * counting the vertices 2 steps away from the start node.  
	 * 
	 * @throws PersonDoesNotExist if either start or target are not in the graph. 	
	 * @param start
	 * @return
	 * @throws Exception 
	 */
	public int countContacts(Person start) throws Exception {
		int count = Collections.frequency(vertex, start);
		if(!this.vertex.contains(start)) {
			throw new Exception("Person does not exist.");
	}
		return count;
	}
}