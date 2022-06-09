package ds.graph;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


import Edge.Edge;
import Person.Person;

public class BreadthFirstSearch {

	private ArrayList<Node> queue;
	static ArrayList<Person> node = new ArrayList<Person>();
	
	static class Node{
		Person data;
		boolean visited;
		List<Node>adjacent;
		
		Node(Person data){
			this.data=data;
			this.adjacent = new ArrayList<>();
		}
		public void addAdjacent(Node adjNode) {
			this.adjacent.add(adjNode);
		}
		public List<Node> getAdjacent(){
			return adjacent;
		}
		public void setAdjacent(List<Node> adjacent) {
			this.adjacent = adjacent;
		}}
	
	public BreadthFirstSearch() {
		queue = new ArrayList<Node>();
	}
	public void bfs(Node start) {
		queue.add(start);
		start.visited = true;
		
		while(!queue.isEmpty()) {
			Node element = queue.remove(0);
			System.out.print(element.data);
			List<Node> adjacent = element.getAdjacent();
			for(int i = 0; i < adjacent.size();i++) {
				Node n = adjacent.get(i);
				if(n!=null && !n.visited)
				{ queue.add(n);
				n.visited = true;
				}
			}
			
		}
	}
	public static void main(String arg[]) {
		Person c1 = new Person("Calissa", 36, .78f);
		Person c2 = new Person("Cassy", 37, .78f);
		Person c3 = new Person("Chanai", 42, .78f);
		Person c4 = new Person("Colleen", 45, .78f);
		Person c5 = new Person("Caylee", 21, .78f);
		Person c6 = new Person("Charvik", 16, .78f);
		Person c7 = new Person("Calab", 63, .78f);
		Person c8 = new Person("Cornell", 92, .78f);
		Person c9 = new Person("Chadwick", 27, .78f);
		Person c10 = new Person("Charlie", 23, .78f);
		
		
		Node node10 = new Node(c1);
		Node node20 = new Node(c2);
		Node node30 = new Node(c3);
		Node node40 = new Node(c4);
		Node node50 = new Node(c5);
		Node node60 = new Node(c6);
		Node node70 = new Node(c7);
		Node node80 = new Node(c8);
		Node node90 = new Node(c9);
		Node node100 = new Node(c10);
		
		node10.addAdjacent(node10);
		node20.addAdjacent(node20);
		node30.addAdjacent(node30);
		node40.addAdjacent(node40);
		node50.addAdjacent(node50);
		node60.addAdjacent(node60);
		node70.addAdjacent(node70);
		node80.addAdjacent(node80);
		node90.addAdjacent(node90);
		node100.addAdjacent(node100);
		
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		bfs.bfs(node10);
		bfs.bfs(node20);
		bfs.bfs(node30);
		bfs.bfs(node40);
		bfs.bfs(node50);
		bfs.bfs(node60);
		bfs.bfs(node70);
		bfs.bfs(node80);
		bfs.bfs(node90);
		bfs.bfs(node100);
	}
}
