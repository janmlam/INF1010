//genersik grensesnittet  som extender iterable
interface AbstraktTabell<T> extends Iterable<T> {

    public boolean settInn(T obj, int index);
    public T finn(int index);

    
}
