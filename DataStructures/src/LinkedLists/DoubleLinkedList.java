package LinkedLists;
import java.util.*;
public class DoubleLinkedList {
	public static void main(String[] args) {
		Scanner sc= new Scanner ( System.in ) ;
		DLL doubleLinkedList = new DLL();
		int opt ;
		do {
			System.out.println(" Enter 1.Insert 2.Delete 3.Search 4.Traversal 5.exit : ");
			opt = sc.nextInt();
			int ele , pos ;
			switch( opt ) {
			case 1:
				System.out.println("Enter element you want to insert and position : ");
				ele = sc.nextInt();
				pos = sc.nextInt();
				doubleLinkedList.insert( ele , pos );
				break;
			case 2:
				System.out.println("Enter element you want to delete : ");
				ele = sc.nextInt();
				doubleLinkedList.delete(ele);
				break;
			case 3:
				System.out.println("Enter element you want to search  : ");
				ele = sc.nextInt();
				doubleLinkedList.search(ele) ;
				break ;
			case 4:
				doubleLinkedList.display();
				break;
			default:
				System.out.println("Enter correct option !!!!");
			}
		}while( opt != 5 );
	}
}
class DLL{
	public DoubleNode head,tail;
	int size;
	//Constructor
	DLL(){
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	//Display all elements in double linked list
	public void display() {
		DoubleNode currentNode = this.head;
		try {
			while( currentNode.next != null ) {
				System.out.print(currentNode.data + " -> ");
				currentNode = currentNode.next;
			}System.out.print(currentNode.data);
			System.out.println();
		}catch(NullPointerException e) {
			System.out.println("Linked List does not exist!!!");
		}
	}
	//Insert element at the beginning.
	private void insertAtBeginning( int element ) {
		DoubleNode newNode = new DoubleNode();
		newNode.data = element;
		newNode.prev = null;
		if( this.head == null ) {
			this.head = newNode ;
			this.tail = newNode ;
			newNode.next = null ;
			this.size++ ;
			return ;
		}
		newNode.next = this.head;
		this.head = newNode;
		this.size++ ;
		return ;
	}
	//Insert element at the end of linked list
	private void insertAtLast( int element ) {
		DoubleNode newNode = new DoubleNode();
		newNode.data = element ;
		newNode.next = null ;
		if( this.head == null ) {
			this.head = newNode ;
			this.tail = newNode ;
			newNode.prev = null ;
			this.size++ ;
			return ;
		}
		this.tail.next = newNode ;
		newNode.prev = this.tail ;
		this.tail = newNode ;
		this.size++ ;
		return ;
	}
	//Insert at specific  position in linked list.
	private void insertAtPosition( int element , int location ) {
		DoubleNode currentNode = this.head ;
		DoubleNode newNode = new DoubleNode();
		newNode.data = element ;
		for( int i = 1 ; i < location-1 ; i++ ) {
			currentNode = currentNode.next ;
		}
		newNode.prev = currentNode ;
		newNode.next = currentNode.next ;
		currentNode.next.prev = newNode ;
		currentNode.next = newNode;
		this.size++;
		return ;
	}
	//Method for inserting element in linked list.
	public void insert ( int element , int location ) {
		if( location == 1 ) {
			insertAtBeginning( element );
		}else if ( location > this.size ) {
			insertAtLast( element );
		}else {
			insertAtPosition ( element , location );
		}
	}
	//Method to search for an element in double linked list.
	public boolean search ( int element ) {
		DoubleNode currentNode = this.head ;
		if(this.head == null ) {
			System.out.println("Linked list does not exist!!");
			return false ;
		}
		for ( int i = 1 ; i <= this.size ; i++) {
			if ( currentNode.data == element ) {
				System.out.println(element + " found at location " + i);
				return true ;
			}currentNode = currentNode.next ;
		}
		System.out.println( element + " not found in linked list!!! ");
		return false ;
	}
	//Method to delete an element from linked list.
	public void delete( int element ) {
		DoubleNode currentNode = this.head ;
		DoubleNode prevNode = null ;
		if(this.head == null ) {
			System.out.println("Linked List does not exist !!!");
			return ;
		}
		for( int i = 1 ; i <= this.size  ; i++) {
			if (currentNode.data == element) {
				if(this.size == 1) {
					this.head = null ;
					this.size-- ;
					return ;
				}
				if( prevNode == null ) {
					currentNode.next.prev = prevNode ;
					this.head = currentNode.next ;
					this.size-- ;
					System.out.println( element + " is deleted from linked list !! ");
					return ;
				}else if ( currentNode.next == null ) {
					prevNode.next = null ;
					this.tail = prevNode ;
					this.size-- ;
					System.out.println( element + " is deleted from linked list !!");
					return ;
				}
				currentNode.next.prev = prevNode ;
				prevNode.next = currentNode.next ;
				this.size-- ;
				System.out.println( element + " is deleted from linked list !!");
				return ;
			}prevNode = currentNode ;
			currentNode = currentNode.next;
		}
	}
}
