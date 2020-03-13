package com.fengwenyi.threadlocalexample;

/**
 * @author Erwin Feng
 * @since 2020/3/12 19:31
 */
public class Val<T> {

    T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

}
