//creating a generic class
class Mengde<E> {

	//creating a private class within the main class(Mengde<E>)
	//the Node class has a next and E variables
	private class Node {
		Node next;
		E data;

		Node (E e) {
			data = e;
		}
	}

	//creating private Node variables, first and last
	private Node first, last = null;

	//making isEmpty defualt as true
	//the method tom() returns isEmpty, and takes no parameter
	private boolean isEmpty = true;
	public boolean tom() {
		if(first == null && last == null) { 
			isEmpty = true;
		}
		else if(first != null){
			isEmpty = false;
		}
		return isEmpty;
	}

	//the method adds a new Node if it wasn't in Mengde already
	//it takes E as parameter, and adds the Node to last
	//returns true if success, false if object was already in Mengde
	boolean success;
	public boolean leggTil(E e) {	
		boolean check = inneholder(e);
		Node insert = new Node(e);
		if(check == false) {
			if(first == null && last == null) {
				first = insert;
				last = insert;
				insert.next = null;
				success = true;
			}
			else if(first == last && first != null) {
				first.next = insert;
				last = insert;
				insert.next = null;
				success = true;
			}
			else {
				last.next = insert;
				last = insert;
				insert.next = null;
				success = true;	
			}
		}
		else {
			success = false;
		}
		return success;
	}


	//method which removes the oldest object FIFO
	public E fjernEldste() {
		Node out = null;
		E asd;
		if(first == null){
			return null;
		}
		else if(first == last && first != null) {
			out = first;
			first = null;
			last = null;
			asd = out.data;
			return asd;
		}
		else {
			Node keeper = first.next;
			out = first;
			first = keeper;
			asd = out.data;
			return asd;
		}
	}

	//method to remove the newest object, LIFO
	public E fjernNyeste() {
		Node out = null;
		E asd;
		if(first == null){
			return null;
		}
		else if(first == last && first != null) {
			out = first;
			first = null;
			last = null;
			asd = out.data;
			return asd;
		}
		else {
			Node keeper = first;
			while(keeper.next != last) {
				keeper = keeper.next;
			}
			out = keeper.next;
			last = keeper;
			last.next = null;
			asd = out.data;
			return asd;
		}
	} 

	//a method to check whether the object is in Mengde or not
	boolean inMengde;
	public boolean inneholder(E e) {
		if(first == null && last == null) {
			inMengde = false;
		}
		else if(first == last && first != null) {
			if (first.data == e) {
				inMengde = true;
			}
		}
		else {
			Node current = first;
			while(current.next != null) {
				if(current.data == e) {
					inMengde = true;
				}
				current = current.next;
			}	
		}
		return inMengde;
	}
}