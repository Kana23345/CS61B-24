import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;

public class BSTMap<K extends Comparable<K>,V> implements Map61B<K,V>{

    private Node list;
    private int size;

    public BSTMap(){
        this.list=null;
        this.size=0;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map already contains the specified key, replaces the key's mapping
     * with the value specified.
     *
     * @param key
     * @param value
     */
    @Override
    public void put(K key, V value) {
       //TODO
        if (isNull()){
            list=new Node(key,value, list);
            size+=1;
            return;
        }
        Node t=list.get(key);
        if (t==null){
            list=new Node(key,value,list);
            size+=1;
            return;
        }
        t.val=value;
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     *
     * @param key
     */
    @Override
    public V get(K key) {
        //TODO
        if (isNull())return null;
        Node t=list.get(key);
        if (t==null)return null;
        return t.val;
    }
    private boolean isNull(){
        return list==null;
    }

    /**
     * Returns whether this map contains a mapping for the specified key.
     *
     * @param key
     */
    @Override
    public boolean containsKey(K key) {
        //TODO
        if (isNull())return false;
        return list.get(key) != null;
    }

    /**
     * Returns the number of key-value mappings in this map.
     */
    @Override
    public int size() {
        //TODO
        return size;
    }

    /**
     * Removes every mapping from this map.
     */
    @Override
    public void clear() {
     //TODO
        size=0;
        list=null;
    }

    //用于按 键 (Key) 的升序打印 BSTMap 的内容
    public void printInOrder(){
        //TODO
    }

    /**
     * Returns a Set view of the keys contained in this map. Not required for Lab 7.
     * If you don't implement this, throw an UnsupportedOperationException.
     */
    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    /**
     * Removes the mapping for the specified key from this map if present,
     * or null if there is no such mapping.
     * Not required for Lab 7. If you don't implement this, throw an
     * UnsupportedOperationException.
     *
     * @param key
     */
    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }


    private class Node{
        private K key;
        private V val;
        private Node next;

        public Node(K k,V v ,Node next){
            this.key=k;
            this.val=v;
            this.next=next;
        }

        private Node get(K k){
            if (k!=null && k.equals(key)){
                return this;
            }
            if (list==null ||next==null)return null;
            return next.get(k);
        }
    }

}
