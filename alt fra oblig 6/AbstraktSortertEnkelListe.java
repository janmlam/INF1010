//generisk grensesnitt, der objektet T har lik og comparable egenskaper
interface AbstraktSortertEnkelListe<T extends Lik & Comparable<T>> {

    public void settInn(T obj);
    public T finn(String nokkel);;
    
}
