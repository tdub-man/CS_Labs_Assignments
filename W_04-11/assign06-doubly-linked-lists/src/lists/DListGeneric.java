package lists;

import java.util.Iterator;

/**
 * Created by tanner on 4/21/16.
 */
public class DListGeneric<E> implements Iterable<NodeGeneric<E>> {
    private class Iter implements Iterator<NodeGeneric<E>> {
        private NodeGeneric<E> current;

        public Iter() {

        }

        public NodeGeneric<E> next() {
            return null;
        }
        public boolean hasNext() {
            return false;
        }
    }

    public Iterator<NodeGeneric<E>> iterator() {
        return null;
    }

    private NodeGeneric<E> base;
    private Iter iter;

    public DListGeneric() {

    }
}
