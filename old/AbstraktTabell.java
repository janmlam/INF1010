interface AbstraktTabell<T> {
	public boolean settIn(T obj, int index);
	public T finnObjekt(int index);
	public Iterator itererOver(T t);
}