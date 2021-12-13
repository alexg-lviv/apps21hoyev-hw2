package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableArrayList implements ImmutableList {
    private final Object[] elements;
    public ImmutableArrayList(Object[] elements) {
        this.elements = elements;
    }

    public ImmutableArrayList() {
        this.elements = new Object[]{};
    }

    @Override
    public ImmutableList add(Object e) {
        Object[] res = Arrays.copyOf(elements, elements.length+1);
        res[elements.length] = e;
        return new ImmutableArrayList(res);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] res = new Object[elements.length+1];
        int j = 0;
        for(int i=0; i < res.length; i++){
            if(i != index){
                res[i] = elements[j];
                j += 1;
            }
            else {
                res[i] = e;
            }
        }
        return new ImmutableArrayList(res);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        Object[] res = Arrays.copyOf(elements, elements.length+c.length);
        for(int i = 0; i < c.length; i++){
            res[i+ elements.length] = c[i];
        }
        return new ImmutableArrayList(res);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] res = new Object[elements.length+c.length];
        int j = 0;
        int z = 0;
        for(int i=0; i < res.length; i++){
            if(i != index){
                res[i+z] = elements[j];
                j += 1;
            }
            else {
                for(; z < c.length; z++){
                    res[i+z] = c[z];
                }
            }
        }
        return new ImmutableArrayList(res);
    }

    @Override
    public Object get(int index) {
        return elements[index];
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] res = new Object[elements.length-1];
        int j=0;
        for(int i=0; i < res.length; i++){
            if(i != index){
                res[j] = elements[i];
                j += 1;
            }
        }
        return new ImmutableArrayList(res);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] res = new Object[elements.length];
        for(int i=0; i < res.length; i++){
            if(i != index){
                res[i] = elements[i];
            }
            else{
                res[i] = e;
            }
        }
        return new ImmutableArrayList(res);
    }

    @Override
    public int indexOf(Object e) {
        for(int i=0; i < elements.length; i++){
            if(elements[i] == e){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        if(elements.length == 0){
            return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, elements.length);
    }
}
