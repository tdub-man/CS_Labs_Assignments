package recursiveLists;

/**
 * Created by Ben on 9/16/2015.
 */
public class Cons extends RecList {
    private Object first;
    private RecList rest;

    public Cons(Object first, RecList rest) {
        this.first = first;
        this.rest = rest;
    }

    @Override
    public Object getFirst() {
        return first;
    }

    @Override
    public RecList getRest() {
        return rest;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        else if(obj instanceof Cons ) {
            Cons c = (Cons)obj;
            return c.getFirst().equals(getFirst()) && c.getRest().equals(getRest());
        } else
            return false;
    }

    @Override
    public int hashCode() {
        return -12345*first.hashCode() + rest.hashCode();
    }
}
