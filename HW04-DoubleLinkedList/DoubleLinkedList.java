import java.util.List;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.Collection;
import java.util.NoSuchElementException;

public class DoubleLinkedList extends AbstractSequentialList<E> {
		private Node<E> head = null;
		private Node<E> tail = null;
		private int size = 0;

	

	public void add(int index, E obj) {
		listIterator(index).add(obj);
	}

	public boolean hasNext() {
		if (this.)
	}

	public void addFirst(E obj) {
		Node adding = new Node(obj);
		if (head != null) {
			adding.next = head;
			head.prev = adding;
		}
		head = adding;

		size++;m
	}


	

	public void addLast(E obj) {
		Node adding = new Node(obj);
		if (tail != null) {
			adding.prev = tail;
			tail.next = adding;
		}
	}
	
}