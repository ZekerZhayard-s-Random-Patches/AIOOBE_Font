package io.github.zekerzhayard.aioobe_font;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.IntCollection;
import it.unimi.dsi.fastutil.ints.IntIterator;
import it.unimi.dsi.fastutil.ints.IntSet;
import it.unimi.dsi.fastutil.objects.ObjectCollection;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import org.apache.commons.lang3.ArrayUtils;

public class Int2ObjectConcurrentHashMap<V> implements Int2ObjectMap<V> {
    public static <V> Int2ObjectMap<V> create() {return new Int2ObjectConcurrentHashMap<>();}
    private final ConcurrentHashMap<Integer, V> map = new ConcurrentHashMap<>();
    private V defaultReturnValue;
    @Override public int size() {return map.size();}
    @Override public void clear() {map.clear();}
    @Override public void defaultReturnValue(V rv) {defaultReturnValue = rv;}
    @Override public V defaultReturnValue() {return defaultReturnValue;}
    @Override public ObjectSet<Int2ObjectMap.Entry<V>> int2ObjectEntrySet() {
        return new ObjectSet<Int2ObjectMap.Entry<V>>() {
            private final Set<Map.Entry<Integer, V>> set = map.entrySet();
            @Override public ObjectIterator<Int2ObjectMap.Entry<V>> iterator() {
                return new ObjectIterator<Int2ObjectMap.Entry<V>>() {
                    private final Iterator<Map.Entry<Integer, V>> iterator = set.iterator();
                    @Override public boolean hasNext() {return iterator.hasNext();}
                    @Override public Int2ObjectMap.Entry<V> next() {
                        return new Int2ObjectMap.Entry<V>() {
                            private final Map.Entry<Integer, V> entry = iterator.next();
                            @Override public Integer getKey() {return entry.getKey();}
                            @Override public V getValue() {return entry.getValue();}
                            @Override public V setValue(V value) {return entry.setValue(value);}
                            @Override public int getIntKey() {return entry.getKey();}
                            @Override public int hashCode() {return entry.hashCode();}
                            @Override public boolean equals(Object obj) {return entry.equals(obj);}
                            @Override public String toString() {return entry.toString();}
                        };
                    }
                    @Override public int hashCode() {return iterator.hashCode();}
                    @Override public boolean equals(Object obj) {return iterator.equals(obj);}
                    @Override public String toString() {return iterator.toString();}

                };
            }
            @Override public int size() {return set.size();}
            @Override public boolean isEmpty() {return set.isEmpty();}
            @Override public boolean contains(Object o) {return set.contains(o);}
            @Override public Object[] toArray() {return set.toArray();}
            @Override public <T> T[] toArray(T [] a) {return set.toArray(a);}
            @Override public boolean add(Int2ObjectMap.Entry<V> vEntry) {return set.add(vEntry);}
            @Override public boolean remove(Object o) {return set.remove(o);}
            @Override public boolean containsAll(Collection<?> c) {return set.containsAll(c);}
            @Override public boolean addAll(Collection<? extends Entry<V>> c) {return set.addAll(c);}
            @Override public boolean removeAll(Collection<?> c) {return set.removeAll(c);}
            @Override public boolean retainAll(Collection<?> c) {return set.retainAll(c);}
            @Override public void clear() {set.clear();}
            @Override public int hashCode() {return set.hashCode();}
            @Override public boolean equals(Object obj) {return set.equals(obj);}
            @Override public String toString() {return set.toString();}
        };
    }
    @Override public IntSet keySet() {
        return new IntSet() {
            private final Set<Integer> set = map.keySet();
            @Override public IntIterator iterator() {
                return new IntIterator() {
                    private final Iterator<Integer> iterator = set.iterator();
                    @Override public int nextInt() {return iterator.next();}
                    @Override public boolean hasNext() {return iterator.hasNext();}
                    @Override public int hashCode() {return iterator.hashCode();}
                    @Override public boolean equals(Object obj) {return iterator.equals(obj);}
                    @Override public String toString() {return iterator.toString();}
                };
            }
            @Override public boolean remove(int k) {return set.remove(k);}
            @Override public boolean add(int key) {return set.add(key);}
            @Override public boolean contains(int key) {return set.contains(key);}
            @Override public int[] toIntArray() {return ArrayUtils.toPrimitive(set.toArray(new Integer[0]));}
            @Override public int[] toIntArray(int[] a) {return ArrayUtils.toPrimitive(set.toArray(ArrayUtils.toObject(a)));}
            @Override public int[] toArray(int[] a) {return ArrayUtils.toPrimitive(set.toArray(ArrayUtils.toObject(a)));}
            @Override public boolean addAll(IntCollection c) {return set.addAll(c);}
            @Override public boolean containsAll(IntCollection c) {return set.containsAll(c);}
            @Override public boolean removeAll(IntCollection c) {return set.removeAll(c);}
            @Override public boolean retainAll(IntCollection c) {return set.retainAll(c);}
            @Override public int size() {return set.size();}
            @Override public boolean isEmpty() {return set.isEmpty();}
            @Override public Object[] toArray() {return set.toArray();}
            @Override public <T> T[] toArray(T [] a) {return set.toArray(a);}
            @Override public boolean containsAll(Collection<?> c) {return set.containsAll(c);}
            @Override public boolean addAll(Collection<? extends Integer> c) {return set.addAll(c);}
            @Override public boolean removeAll(Collection<?> c) {return set.removeAll(c);}
            @Override public boolean retainAll(Collection<?> c) {return set.retainAll(c);}
            @Override public void clear() {set.clear();}
            @Override public int hashCode() {return set.hashCode();}
            @Override public boolean equals(Object obj) {return set.equals(obj);}
            @Override public String toString() {return set.toString();}
        };
    }
    @Override public ObjectCollection<V> values() {
        return new ObjectCollection<V>() {
            private final Collection<V> collection = map.values();
            @Override public ObjectIterator<V> iterator() {
                return new ObjectIterator<V>() {
                    private final Iterator<V> iterator = collection.iterator();
                    @Override public boolean hasNext() {return iterator.hasNext();}
                    @Override public V next() {return iterator.next();}
                    @Override public int hashCode() {return iterator.hashCode();}
                    @Override public boolean equals(Object obj) {return iterator.equals(obj);}
                    @Override public String toString() {return iterator.toString();}
                };
            }
            @Override public int size() {return collection.size();}
            @Override public boolean isEmpty() {return collection.isEmpty();}
            @Override public boolean contains(Object o) {return collection.contains(o);}
            @Override public Object[] toArray() {return collection.toArray();}
            @Override public <T> T[] toArray(T [] a) {return collection.toArray(a);}
            @Override public boolean add(V v) {return collection.add(v);}
            @Override public boolean remove(Object o) {return collection.remove(o);}
            @Override public boolean containsAll(Collection<?> c) {return collection.containsAll(c);}
            @Override public boolean addAll(Collection<? extends V> c) {return collection.addAll(c);}
            @Override public boolean removeAll(Collection<?> c) {return collection.removeAll(c);}
            @Override public boolean retainAll(Collection<?> c) {return collection.retainAll(c);}
            @Override public void clear() {collection.clear();}
            @Override public int hashCode() {return collection.hashCode();}
            @Override public boolean equals(Object obj) {return collection.equals(obj);}
            @Override public String toString() {return collection.toString();}
        };
    }
    @Override public boolean containsKey(int key) {return map.containsKey(key);}
    @Override public V put(int key, V value) {return map.put(key, value);}
    @Override public V get(int key) {return map.get(key);}
    @Override public V remove(int key) {return map.remove(key);}
    @Override public boolean isEmpty() {return map.isEmpty();}
    @Override public boolean containsValue(Object value) {return map.containsValue(value);}
    @Override public void putAll(Map<? extends Integer, ? extends V> m) {map.putAll(m);}
    @Override public int hashCode() {return map.hashCode();}
    @Override public boolean equals(Object obj) {return map.equals(obj);}
    @Override public String toString() {return map.toString();}
}
