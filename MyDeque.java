import java.util.NoSuchElementException;

public class MyDeque {

    // Use the main method to test and debug your methods

    Node head = null;
    Node tail = null;

    public boolean addEven(int num){
        if (num % 2 == 1) {
			return false;
		}

		Node newNode = new Node(num);

		newNode.prev = null;
		newNode.next = head;

		if (head != null) {
			head.prev = newNode;
		}
		else {
			tail = newNode;
		}
		head = newNode;

		return true;
    }


    public boolean addOdd(int num) {
        if (num % 2 == 0) {
			return false;
		}

		Node newNode = new Node(num);

		newNode.prev = tail;
		newNode.next = null;

		if (tail != null) {
			tail.next = newNode;
		}
		else {
			head = newNode;
		}
		tail = newNode;

		return true;
    }


    public int getFirst() {
        if (head == null) {
			throw new NoSuchElementException("Nothing in the list1");
		}

		return head.num;
    }


    public int getLast(){
        if (head == null) {
			throw new NoSuchElementException("Nothing in the list2");
		}

		return tail.num;
    }


    public int removeFirst(){
        if (head == null) {
			throw new NoSuchElementException("Nothing in the list3");
		}

        int firstVal = head.num;

		// if it was the only element
		if (head.next == null) {
			head = null;
			tail = null;
			return firstVal;
		}

		head = head.next;
		if (head != null) {
			head.prev = null;
			if (head.next == null) {
				head = tail;
			}
		}

		return firstVal;
    }


    public int removeLast(){
        if (tail == null) {
			throw new NoSuchElementException("Nothing in the list4" + toString() + "head: " + head + " tail: " + tail);
		}

		int lastVal = tail.num;

		// if it was the only element
		if (tail.prev == null) {
			head = null;
			tail = null;
			return lastVal;
		}

		tail = tail.prev;
		if (tail != null) {
			tail.next = null;
			if (tail.prev == null) {
				tail = head;
			}
		}

		return lastVal;
    }


    public boolean isEmpty(){
        if (head == null) {
			return true;
		}

		return false;
    }


    public int contains(int num){
        if (head == null) {
			//throw new NoSuchElementException("Nothing in the list");
			return -1;
		}

		int dist = 0;

        // if num is even, start from head
		if (num % 2 == 0) {
			Node current = head;

			while (current != null) {
				dist++;
				if (current.num == num) {
					return dist;
				}

				current = current.next;
			}
		}

        // if num is odd, start from tail
		if (num % 2 == 1) {
			Node current = tail;

			while (current != null) {
				dist++;
				if (current.num == num) {
					return dist;
				}

				current = current.prev;
			}
		}

		return -1;
    }


    public int remove(int num) {
	    if (head == null) {
			//throw new NoSuchElementException("Nothing in the list");
			return -1;
		}

		int dist = 0;

        // if num is even, start from head
		if (num % 2 == 0) {
			Node current = head;

			while (current != null) {
				dist++;
				if (current.num == num) {
					// // remove Node
					// null - O - null
					if (current.prev == null && current.next == null) {
						head = null;
						tail = null;
						return dist;
					}
					// O - O - O
					if (current.prev != null && current.next != null) {
						current.prev.next = current.next;
						current.next.prev = current.prev;
					}
					// null - O - O
					else if (current.prev == null && current.next != null) {
						current.next.prev = null;
						head = current.next;
					}
					// O - O - null
					else if (current.prev != null && current.next == null) {
						current.prev.next = null;
						tail = current.prev;
					}

					return dist;
				}

				current = current.next;
			}
		}

        // if num is odd, start from tail
		if (num % 2 == 1) {
			Node current = tail;

			while (current != null) {
				dist++;
				if (current.num == num) {
					// remove Node
					// null - O - null
					if (current.prev == null && current.next == null) {
						head = null;
						tail = null;
						return dist;
					}
					// O - O - O
					if (current.prev != null && current.next != null) {
						current.prev.next = current.next;
						current.next.prev = current.prev;
					}
					// null - O - O
					else if (current.prev == null && current.next != null) {
						current.next.prev = null;
						head = current.next;
					}
					// O - O - null
					else if (current.prev != null && current.next == null) {
						current.prev.next = null;
						tail = current.prev;
					}

					return dist;
				}

				current = current.prev;
			}
		}

		return -1;
    }


    public void merge(MyDeque other){
		if (head == null) {
			head = other.head;
			return;
		}
		else if (other == null || other.head == null) {
			return;
		}
		
		Node current = other.head;

		while (current != null) {
			addEven(current.num);
			addOdd(current.num);

			current = current.next;
		}
    }


    public String toString(){
    // if empty, return []
    if (head == null) {
        return "[]";
    }
    
    String text = "[" + head.num;

    Node current = head.next;
    while (current != null) {
        
        text += ", " + current.num;

        current = current.next;
    }

    text += "]";

    return text;
    }
}
    
class Node {

    int num;
    Node prev = null;
    Node next = null;

    public Node(int num) {
        this.num = num;
    }

    public String toString() {
        return "" + num;
    }
}
