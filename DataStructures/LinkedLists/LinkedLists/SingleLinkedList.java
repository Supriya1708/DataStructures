package LinkedLists;
import java.util.*;
public class SingleLinkedList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SLL singleLinkedList = new SLL();
		int op;
		do {
			System.out.println("Enter 1.insert 2.delete 3.search 4.display 5.exit : ");
			op = sc.nextInt();
			switch(op) {
			case 1:
				System.out.println("Enter element and inserting position : ");
				int ele = sc.nextInt();
				int pos = sc.nextInt();
				singleLinkedList.insert(ele , pos);
				break;
			case 2:
				System.out.println("Enter element you want to delete : ");
				ele = sc.nextInt();
				singleLinkedList.delete(ele);
				break;
			case 3:
				System.out.println("Enter element you want to search : ");
				ele = sc.nextInt();
				singleLinkedList.searchForElement(ele);
				break;
			case 4:
				singleLinkedList.display();
				break;
			default:
				System.out.println("Enter correct option!!");
			}
		}while(op != 5);
		
	}
}
class SLL{
	public SingleNode head,tail;
	int size;
	//constructor
	SLL(){
		head = null;
		tail = null;
		size = 0;
	}
	//Display elements of Linked List
	public void display() {
		SingleNode currentNode = head;
		try {
			while(currentNode.next != null) {
				System.out.print(currentNode.data + " -> ");
				currentNode = currentNode.next;
			}
			System.out.print(currentNode.data);
			System.out.println();
		}catch(NullPointerException e) {
			System.out.println("Linked List does not exist!!!");
		}
	}
	//insert at beginning method
	private void insertAtBeginning(int element) {
		SingleNode newNode = new SingleNode();
		newNode.data = element ;
		if( head == null) {
			head = newNode;
			tail = newNode;
			newNode.next = null;
			size++;
			return;
		}
		newNode.next = head;
		head = newNode;
		size++;
	}
	//method to insert at End 
	private void insertAtLast(int element) {
		SingleNode newNode = new SingleNode();
		newNode.data = element;
		newNode.next = null;
		if(head == null) {
			head = newNode;
			tail = newNode;
			size++;
			return;
		}tail.next = newNode;
		tail = newNode;
		size++;
	}
	//method to insert at specific location
	private void insertAtLocation(int element , int location) {
		SingleNode newNode = new SingleNode();
		newNode.data = element;
		SingleNode currentNode = head;
		for ( int i = 1 ; i < location - 1 ; i++) {
			currentNode = currentNode.next;
		}
		newNode.next = currentNode.next;
		currentNode.next = newNode;
		size++;
	}
	//General Insert Method.
	public void insert(int element , int location) {
		if(location == 1) {
			insertAtBeginning(element);
		}else if (location > size ) {
			insertAtLast(element);
		}else {
			insertAtLocation( element , location );
		}
	}
	//Search for element in linked list.
	public boolean searchForElement( int element) {
		SingleNode currentNode = head;
		if(head == null) {
			System.out.println("Linked List does not exist!!");
			return false;
		}
		for ( int i=1 ; i <= size ; i++) {
			if( currentNode.data == element ) {
				System.out.println(element + " found at location "+i);
				return true;
			}
			currentNode = currentNode.next;
		}System.out.println(element  + " is not found in linked list!!");
		return false;
	}
	//Method for deleting an element
	public void delete(int element) {
		SingleNode currentNode = head;
		SingleNode previousNode = null;
		if(head == null) {
			System.out.println("Linked List does not exist!!!");
			return ;
		}
		while(currentNode != null) {
			if(currentNode.data == element) {
				if(previousNode == null) {
					head = currentNode.next;
					System.out.println(element + " successfully deleted!");
					size--;
					return ;
				}else {
					previousNode.next = currentNode.next;
					System.out.println(element + " successfully deleted!");
					size--;
					return;
				}
			}
			previousNode = currentNode;
			currentNode = currentNode.next;
		}System.out.println(element  + " does not exist in linked list!!");
		
	}
	
	
	
}
