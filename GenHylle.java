//creating an generic interface
interface GenHylle<E> {

	//a method to set number as space in an array
	public void setSpace(int number);

	//a method to check how many spaces there are total in the array
	public int howManySpaces();

	//a method to place an object in a given array
	public boolean placeObject(E element, int number);

	//a method to remove an object in a given array
	public E removeObject(int number);

	//a method to check if the given array is empty or not
	public boolean availableSpace(int number);

}
