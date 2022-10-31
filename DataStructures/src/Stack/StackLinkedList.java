package Stack;
import java.util.* ;
public class StackLinkedList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		int opt ;
		StackLL stack = new StackLL();
		do {
			System.out.println(" Enter 1.push 2.pop 3.peek 4.traversal 5.isEmpty 6.size 7.deleteStack 8.exit :");
			opt = sc.nextInt();
			switch( opt) {
			case 1:
				System.out.println("Enter element you want to push :");
				int ele = sc.nextInt();
				stack.push(ele);
				break ;
			case 2:
				stack.pop();
				break ;
			case 3:
				stack.peek();
				break ;
			case 4:
				stack.display() ;
				break ;
			case 5:
				boolean isEmpty = stack.isEmpty() ;
				System.out.println(isEmpty);
				break ;
			case 6:
				int size = stack.size();
				System.out.println("The size of the stack is : " + size);
				break;
			case 7:
				stack.deleteStack();
				break;
			default:
					System.out.println("Enter correct option !!!");
			}
		}while( opt != 8);
	}
}
class Node{
	int data ;
	Node next ;
}
class StackLL{
	public Node head , tail ;
	public int size ;
	StackLL(){
		this.head = null ; 
		this.tail = null ;
		this.size = 0;
	}
	//push an element into stack
	public void push(int Element) {
		Node newNode = new Node();
		newNode.data = Element ;
		if( this.head == null ) {
			this.head = newNode ;
			this.tail = newNode ;
			newNode.next = null ;
			this.size++ ;
			return ;
		}
		newNode.next = this.head ;
		this.head = newNode ;
		this.size++ ;
		return ;
	}
	//pop an element from stack
	public void pop() {
		if(this.isEmpty()) {
			System.out.println("Stack doesnt exist!!!");
			return  ;
		}
		int ele = this.head.data ;
		this.head = this.head.next ;
		this.size-- ;
		System.out.println("popped element is : " + ele );
	}
	//peek stack
	public void peek() {
		if(this.isEmpty()) {
			System.out.println("Stack does not exist .");
			return  ;
		}
		System.out.println("The top most element is " + this.head.data); 
	}
	//display elements in stack.
	public void display() {
		Node currentNode = this.head ;
		if( this.head == null ) {
			System.out.println("Stack does not exist");
			return ;
		}
		while(currentNode != null) {
			System.out.println(currentNode.data + "  ");
			currentNode = currentNode.next ;
		}
		System.out.println();
	}
	//to check if the stack is empty.
	public boolean isEmpty() {
		if( this.head == null ) 
			return true ;
		return false ;
	}
	//to get current size of the stack.
	public int size() {
		if(this.head == null)
			return -1 ;
		return this.size ;
	}
	// delete stack
	public void deleteStack() {
		this.head = null ;
		System.out.println("Entire stack deleted!!!");
	}
}
