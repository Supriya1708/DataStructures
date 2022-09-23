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
				ele = stack.pop();
				System.out.println("The popped element is : " + ele );
				break ;
			case 3:
				ele = stack.peek();
				System.out.println("The topmost element in stack is : " + ele );
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
		stack =  new int[ size ] ;
		topOfStack = -1 ;
	}
	//To push an element in the stack.
	public void push ( int element ) {
		if ( topOfStack == stack.length ) {
			System.out.println( "Stack is Full ") ;
			return ;
		}
		topOfStack++ ;
		stack[topOfStack] = element ;
		return ;
	}
	//To pop an element from the stack
	public int pop() {
		if( topOfStack == -1 ) {
			System.out.println( " Stack is Empty ");
			return -1;
		}
		int ele = stack[topOfStack] ;
		topOfStack-- ;
		return ele ;
	}
	//to peek the stack
	public int peek() {
		return stack[topOfStack] ;
	}
	//Traversal of stack.
	public void traversal() {
		if( topOfStack == -1 ) {
			System.out.println(" Stack is Empty ");
			return ;
		}
		for( int i = 0 ; i <= topOfStack ; i++) {
			System.out.print( stack[i] + " ");
		}
		System.out.println();
	}
	//Search for an element in the stack 
	public boolean search ( int element ) {
		if( topOfStack == -1 ) {
			System.out.println(" Stack is empty ");
			return false ;
		}
		for( int i = 0 ; i <= topOfStack ; i++) {
			if( stack[i] == element ) {
				System.out.println( element + " found at index " + i);
				return true ;
			}
		}
		System.out.println( element + " is not found in stack ");
		return false ;
	}
}
