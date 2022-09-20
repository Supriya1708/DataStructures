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
		head = null;
		tail = null;
		size = 0;
	}
	//Display all elements in double linked list
	public void display() {
		DoubleNode currentNode = head;
		try {
			for( int i = 1 ; i < size ; i++ ) {
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
		if( head == null ) {
			head = newNode ;
			tail = newNode ;
			newNode.next = null ;
			size++ ;
			return ;
		}
		newNode.next = head;
		head = newNode;
		size++ ;
		return ;
	}
	//Insert element at the end of linked list
	private void insertAtLast( int element ) {
		DoubleNode newNode = new DoubleNode();
		newNode.data = element ;
		newNode.next = null ;
		if( head == null ) {
			head = newNode ;
			tail = newNode ;
			newNode.prev = null ;
			size++ ;
			return ;
		}
		tail.next = newNode ;
		newNode.prev = tail ;
		tail = newNode ;
		size++ ;
		return ;
	}
	//Insert at specific  position in linked list.
	private void insertAtPosition( int element , int location ) {
		DoubleNode currentNode = head ;
		DoubleNode newNode = new DoubleNode();
		newNode.data = element ;
		for( int i = 1 ; i < location-1 ; i++ ) {
			currentNode = currentNode.next ;
		}
		newNode.prev = currentNode ;
		newNode.next = currentNode.next ;
		currentNode.next.prev = newNode ;
		currentNode.next = newNode;
		size++;
		return ;
	}
	//Method for inserting element in linked list.
	public void insert ( int element , int location ) {
		if( location == 1 ) {
			insertAtBeginning( element );
		}else if ( location > size ) {
			insertAtLast( element );
		}else {
			insertAtPosition ( element , location );
		}
	}
	//Method to search for an element in double linked list.
	public boolean search ( int element ) {
		DoubleNode currentNode = head ;
		if(head == null ) {
			System.out.println("Linked list does not exist!!");
			return false ;
		}
		for ( int i = 1 ; i <= size ; i++) {
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
		DoubleNode currentNode = head ;
		DoubleNode prevNode = null ;
		if(head == null ) {
			System.out.println("Linked List does not exist !!!");
			return ;
		}
		for( int i = 1 ; i <= size  ; i++) {
			if (currentNode.data == element) {
				if(size == 1) {
					head = null ;
					size-- ;
					return ;
				}
				if( prevNode == null ) {
					currentNode.next.prev = prevNode ;
					head = currentNode.next ;
					size-- ;
					System.out.println( element + " is deleted from linked list !! ");
					return ;
				}else if ( currentNode.next == null ) {
					prevNode.next = null ;
					size-- ;
					System.out.println( element + " is deleted from linked list !!");
					return ;
				}
				currentNode.next.prev = prevNode ;
				prevNode.next = currentNode.next ;
				size-- ;
				System.out.println( element + " is deleted from linked list !!");
				return ;
			}prevNode = currentNode ;
			currentNode = currentNode.next;
		}
	}
}
