package Queue;
import java.util.*;
public class QueueUsingLinkedList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		QueueLL queue = new QueueLL() ;
		int opt ;
		do {
			System.out.println("Enter 1.Enqueue 2.Dequeue 3.peek 4.exit : ");
			opt = sc.nextInt();
			switch(opt) {
			case 1:
				System.out.println("Enter element you want to enqueue : ");
				int ele = sc.nextInt();
				queue.enqueue(ele);
				break;
			case 2:
				queue.dequeue();
				break ; 
			case 3:
				queue.peek();
				break ;
				default:
					System.out.println("Enter valid option !!!");
			}
		}while(opt != 4);
	}
}
class NodeLL{
	int data ;
	NodeLL next ;
}
class QueueLL{
	public NodeLL head , tail ;
	int size ;
	QueueLL(){
		this.head = null ;
		this.tail = null ;
		this.size = 0 ;
	}
	//Enqueue an element in queue
	public void enqueue(int ele ) {
		NodeLL newNode = new NodeLL();
		newNode.data = ele ;
		newNode.next = null ;
		if( this.head == null ) {
			this.head = newNode ;
			this.tail = newNode ; 
			this.size++ ;
			return ;
		}
		this.tail.next = newNode ;
		this.tail = newNode ;
		this.size++ ;
	}
	//Dequeue an element in queue
	public void dequeue() {
		if(this.head == null ) {
			System.out.println("Queue is Empty ");
			return ;
		}
		int ele = this.head.data ;
		this.head = this.head.next ;
		this.size-- ;
		System.out.println("The Dequeued element is : " + ele);
	}
	//Peek in queue
	public void peek() {
		if(this.head == null ) {
			System.out.println("Queue is Empty!!");
			return ;
		}
		System.out.println("The top most element is :" + this.head.data);
	}
	
}
