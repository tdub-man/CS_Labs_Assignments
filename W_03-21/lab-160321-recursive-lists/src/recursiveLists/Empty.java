package recursiveLists;

/**
 * Created by Ben on 9/16/2015.
 */
public class Empty extends RecList{
    @Override
    public Object getFirst() {
        throw new IllegalStateException("head of empty list");
    }
    @Override
    public RecList getRest() {
        throw new IllegalStateException("tail of an empty list");
    }
    @Override
    public boolean isEmpty() {
        return true;
    }
    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof Empty;
    }
    @Override
    public int hashCode() {
        return -123456789;
    }
}
