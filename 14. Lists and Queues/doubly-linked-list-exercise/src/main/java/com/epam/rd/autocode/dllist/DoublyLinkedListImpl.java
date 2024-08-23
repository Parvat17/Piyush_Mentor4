package com.epam.rd.autocode.dllist;

import java.util.Optional;

public class DoublyLinkedListImpl implements DoublyLinkedList {

	private Node head;
	private Node tail;

	private static class Node {
		Object element;
		Node next;
		Node prev;

		Node(Object element, Node prev, Node next) {
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
	}

	@Override
	public boolean addFirst(Object element) {
		if (element == null) {
			return false;
		}

		if (head == null) {
			head = new Node(element, null, null);
			tail = head;
		} else {
			Node newElement = new Node(element, null, head);
			head.prev = newElement;
			head = newElement;
		}
		return true;
	}

	@Override
	public boolean addLast(Object element) {
		if (element == null) {
			return false;
		}

		if (tail == null) {
			tail = new Node(element, null, null);
			head = tail;
		} else {
			Node newElement = new Node(element, tail, null);
			tail.next = newElement;
			tail = newElement;
		}
		return true;
	}

	@Override
	public void delete(int index) {
		if (index < 0) throw new IndexOutOfBoundsException();

		Node current = head;
		int currentIndex = 0;

		while (current != null && currentIndex < index) {
			current = current.next;
			currentIndex++;
		}

		if (current == null) {
			throw new IndexOutOfBoundsException();
		}

		if (current.prev != null) {
			current.prev.next = current.next;
		} else {
			head = current.next;
		}

		if (current.next != null) {
			current.next.prev = current.prev;
		} else {
			tail = current.prev;
		}
	}

	@Override
	public Optional<Object> remove(Object element) {
		if (element == null) throw new NullPointerException();

		Node current = head;

		while (current != null) {
			if (current.element.equals(element)) {
				if (current.prev != null) {
					current.prev.next = current.next;
				} else {
					head = current.next;
				}

				if (current.next != null) {
					current.next.prev = current.prev;
				} else {
					tail = current.prev;
				}
				return Optional.of(current.element);
			}
			current = current.next;
		}
		return Optional.empty();
	}

	@Override
	public boolean set(int index, Object element) throws IndexOutOfBoundsException {
		if (element == null) {
			return false;
		}
		if (index < 0) throw new IndexOutOfBoundsException();

		Node current = head;
		int currentIndex = 0;

		while (current != null && currentIndex < index) {
			current = current.next;
			currentIndex++;
		}

		if (current == null) {
			throw new IndexOutOfBoundsException();
		}

		current.element = element;
		return true;
	}

	@Override
	public int size() {
		int count = 0;
		Node current = head;

		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	@Override
	public Object[] toArray() {
		int size = size();
		Object[] array = new Object[size];
		Node current = head;

		for (int i = 0; i < size; i++) {
			array[i] = current.element;
			current = current.next;
		}
		return array;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node current = head;

		while (current != null) {
			sb.append(current.element.toString());
			if (current.next != null) {
				sb.append(" ");
			}
			current = current.next;
		}
		return sb.toString();
	}
}
