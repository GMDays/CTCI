package StacksAndQueues;

import java.time.Instant;
import java.util.EmptyStackException;
import java.util.LinkedList;

public class AnimalShelter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnimalShelter shelter = new AnimalShelter();
		//shelter.enqueue();
		Animal cat1 = new Animal("cat");
		System.out.println(cat1.time);
		Animal cat2 = new Animal("cat");
		Animal cat3 = new Animal("cat");
		Animal cat4 = new Animal("cat");
		Animal dog1 = new Animal("dog");
		Animal dog2 = new Animal("dog");
		Animal dog3 = new Animal("dog");
		Animal dog4 = new Animal("dog");
		shelter.enqueue(cat1);
		shelter.enqueue(cat2);
		shelter.enqueue(cat3);
		shelter.enqueue(cat4);
		shelter.enqueue(dog1);
		shelter.enqueue(dog2);
		shelter.enqueue(dog3);
		Animal returnAny = shelter.dequeueAny();
		System.out.println(returnAny.type);
		System.out.println(returnAny.time);
		
	}
	
	private LinkedList<Animal> catList;
	private LinkedList<Animal> dogList;
	
	public AnimalShelter() {
		this.catList = new LinkedList<Animal>();
		this.dogList = new LinkedList<Animal>();
	}
	
	public static class Animal {
		public String type;	
		public Instant time;
		public Animal(String type) {
			this.type = type;
			this.time = Instant.now();
		}
	}
	
	public void enqueue(Animal ani) {
		if(ani.type.toLowerCase().equals("cat")) {
			catList.add(ani);
		}
		
		if(ani.type.toLowerCase().equals("dog")) {
			dogList.add(ani);
		}
	}
	
	public Animal dequeueAny() {
		return dogList.peek().time.compareTo(catList.peek().time) < 0 ? dogList.pop() : catList.pop();
	}

	public Animal dequeueDog() {
		return dogList.pop();
	}
	
	public Animal dequeueCat() {
		return catList.pop();
	}
}
