//a generic class with an implemented generic interface
class Hylle<E> implements GenHylle<E> {

	//create an array with type E
	private E[] container;
	//a command to supress unchecked while compiling
	@SuppressWarnings("unchecked")

	//method to create an array with the parameter
	public void setSpace(int number) {
		container = (E[]) new Object[number];
	}

	//a method to find out how many spaces there are in the array (total)
	public int howManySpaces() {
		return container.length;
	}

	//a method to place element in a given array spot
	//if the given array spot is not available, false will be returned
	private boolean success;
	public boolean placeObject(E element, int number) {
		if(number < (container.length)) {
			if(availableSpace(number) == true) {
				container[number] = element;
				success = true;
			}
			else {
				success = false;
			}
		}
		else {
			success = false;
		}
		return success;
	}

	//removing the object from the array, which spot is given in parameter
	public E removeObject(int number) {
		E keeper;
		if(container[number] != null) {
			keeper = container[number];
			container[number] = null;
			return keeper;
		}
		else {
			keeper = null;
			return keeper;
		}
	}

	//method to check if the given array[parameter] is empty or not
	public boolean availableSpace(int number) {
		if(container[number] == null) {
			return true;
		}
		else {
			return false;
		}
	}
}