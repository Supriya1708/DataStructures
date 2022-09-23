import java.util.*;
public class StackArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner ( System.in ) ;
		int opt ;
		System.out.println("Enter size of stack : ");
		int size = sc.nextInt();
		Stack stack = new Stack(size) ;
		do {
			System.out.println(" Enter 1.push 2.pop 3.peek 4.traversal 5.search 6.exit :");
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
				stack.traversal() ;
				break ;
			case 5:
				System.out.println("Enter element you want to search : ");
				ele = sc.nextInt();
				stack.search(ele);
				break ;
			default:
					System.out.println("Enter correct option !!!");
			}
		}while( opt != 6);
	}
}
class Stack{
	int[] stack ;
	int topOfStack ;
	Stack ( int size ) {
		this.stack =  new int[ size ] ;
		this.topOfStack = -1 ;
	}
	//to check stack is empty
	private boolean isEmpty() {
		if( this.topOfStack == -1)
			return true ;
		return false ;
	}
	//to check whether stack is full
	private boolean isFull() {
		if(this.topOfStack == this.stack.length)
			return true ;
		return false ;
	}
	//To push an element in the stack.
	public void push ( int element ) {
		if ( this.isFull() ) {
			System.out.println( "Stack is Full ") ;
			return ;
		}
		if(this.topOfStack + 1 < this.stack.length) {
			this.topOfStack++ ;
			this.stack[this.topOfStack] = element ;
			return ;
		}else {
			System.out.println("Cannot insert element in stack");
		}
	}
	//To pop an element from the stack
	public void pop() {
		if( this.isEmpty() ) {
			System.out.println( " Stack is Empty ");
			return ;
		}
		int ele = this.stack[this.topOfStack] ;
		this.topOfStack-- ;
		System.out.println("The popped element is : " + ele );
	}
	//to peek the stack
	public void peek() {
		if(this.isEmpty()) {
			System.out.println("Stack is empty!!");
			return ;
		}
		System.out.println(this.stack[this.topOfStack] ); 
	}
	//Traversal of stack.
	public void traversal() {
		if( this.topOfStack == -1 ) {
			System.out.println(" Stack is Empty ");
			return ;
		}
		for( int i = 0 ; i <= this.topOfStack ; i++) {
			System.out.print( this.stack[i] + " ");
		}
		System.out.println();
	}
	//Search for an element in the stack 
	public boolean search ( int element ) {
		if( this.topOfStack == -1 ) {
			System.out.println(" Stack is empty ");
			return false ;
		}
		for( int i = 0 ; i <= this.topOfStack ; i++) {
			if( this.stack[i] == element ) {
				System.out.println( element + " found at index " + i);
				return true ;
			}
		}
		System.out.println( element + " is not found in stack ");
		return false ;
	}
}
