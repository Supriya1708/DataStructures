import java.util.*;
public class QueueUsingArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		System.out.println("Enter size of queue : ");
		int size = sc.nextInt();
		Queue queue = new Queue(size) ;
		int opt;
		do {
			System.out.println("Enter 1.Enqueue 2.Dequeue 3.peek 4.isFull 5.isEmpty 6.exit : ");
			opt = sc.nextInt();
			switch(opt) {
			case 1:
				System.out.println("Enter element you want to enqueue: ");
				int ele = sc.nextInt();
				queue.enqueue(ele);
				break ;
			case 2:
				queue.dequeue();
				break ;
			case 3:
				queue.peek();
				break ;
			case 4:
				boolean isFull = queue.isFull();
				System.out.println(isFull);
				break ;
			case 5:
				boolean isEmpty = queue.isEmpty();
				System.out.println(isEmpty);
				break ;
			default:
				System.out.println("Enter correct option !!!");
			}
		}while(opt != 6);
	}
}
class Queue{
	int [] queue ;
	int front , rear ;
	//Creation of queue
	Queue( int size ){
		this.queue = new int[size] ;
		this.front = -1 ;
		this.rear = -1 ;
	}
	//To check whether a queue is full 
	public boolean isFull() {
		if(this.rear == this.queue.length-1) {
			return true ;
		}return false ;
	}
	//To check whether a queue is empty
	public boolean isEmpty() {
		if(this.front == this.rear)
			return true ;
		return false ;
	}
	//Enqueue an element
	public void enqueue(int ele) {
		if(!this.isFull()) {
				this.rear++ ;
				this.queue[rear] = ele ;
				return ;
		}
		System.out.println("Queue is Full");
	}
	//Dequeue an element from Queue
	public void dequeue() {
		if(!this.isEmpty()) {
			int ele = this.queue[++front] ;
			System.out.println("Dequeued element is : " + ele );
		}else {
			System.out.println("Queue is empty");
		}
	}
	//peek an element from queue
	public void peek() {
		if(!this.isEmpty())
			System.out.println("The top element is : " + this.queue[front + 1]);
		else
			System.out.println("Queue is empty");
	}
}