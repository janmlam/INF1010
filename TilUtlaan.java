/**
 *Classes which implements this interface will be able to set
 *string out for loan. An already loaned string can't be loaned out 
 *twice. It can also return the loaned items back.
 *
 *
 *@author Jan Ming Lam
 *version 10/02-15
 *
 */

interface TilUtlaan {
	/**
	 *method objectOut takes one parameter, this String is the name
	 *of the object which will be loaned out. It keeps this name until 
	 *it is returned back. An already kept name can't be loaned out again. 
	 *If the method successfully kept, and loaned out an
	 *object, it will return true, if not false will be returned
	 * 
	 *@param id String which will be kept, and loaned out
	 *@return True/false depends if the object is loaned out or not.
	 */
	public boolean objectOut(String out);

	/**
	 *method objectIn takes one parameter, this String is the name 
	 *of the object which will be returned again. If the parameter was not kept
	 *beforehand, it will return false. But if the object is successfully 
	 *returned, true will be returned.
	 *
	 *
	 *@param id String which will be returned
	 *@return Returns the kept string, if nothing was kept, null is returned
	 */
	public String objectIn(String in);
}

