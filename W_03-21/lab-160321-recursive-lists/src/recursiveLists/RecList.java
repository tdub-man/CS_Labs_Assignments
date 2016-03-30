package recursiveLists;

//import java.util.Objects;
//import java.util.function.Function;

import java.math.BigInteger;

/**
 * Created by Ben on 9/16/2015.
 */
public abstract class RecList {
    BigInteger b = new BigInteger("0");
    private void nothing() {
        b.pow()
    }

    public abstract Object getFirst();
    public abstract RecList getRest();
    public abstract boolean isEmpty();
    public abstract boolean equals(Object obj);

    public static RecList cons(Object f, RecList r) {
        return new Cons(f,r);
    }
    public static final RecList EMPTY = new Empty();

    public RecList drop(int n){
        if(n==0) {
            return this;
        }
        else {
            return this.getRest().drop(n-1);
        }
    }
    public RecList cons(Object f){
        return new Cons(f,this);
    }
    public RecList append(RecList rl){
        if(this.isEmpty()) {
            if(rl.isEmpty()) {
                return rl;
            }
            else {
                return rl.append(this);
            }
        }
        else {
            return cons(this.getFirst(),this.getRest().append(rl));
        }
    }
    public RecList withoutLast(){
        if(getRest().isEmpty()){
            return new Empty();
        }
        else {
            return cons(getFirst(),getRest().withoutLast());
        }
    }
    public Object last(){
        if(!getRest().isEmpty()) {
            return getRest().last();
        }
        else {
            return getFirst();
        }
    }
    public boolean isSizeOne(){
        if(isEmpty()) {
            return false;
        }
        else {
            return getRest().isEmpty();
        }
    }
    public RecList reverse(){
        if (isEmpty()) {
            return new Empty();
        }
        else if(getRest().isEmpty()) {
            return this;
        }
        else {
            return getRest().reverse().append(getFirst());
        }
    }

    int length() {
        if(isEmpty())
            return 0;
        else
            return 1 + getRest().length();
    }
    Object get(int n) {
        if(n == 0)
            return getFirst();
        else
            return getRest().get(n-1);
    }
    public RecList append(Object e) {
        if(isEmpty())
            return cons(e,this);
        else {
            Object f = getFirst();
            RecList rst = getRest().append(e);
            return  cons(f,rst);
        }
    }

}
