package com.fengwenyi.threadlocalexample;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Val<?> val = (Val<?>) o;
        return Objects.equals(t, val.t);
    }

    @Override
    public int hashCode() {

        return Objects.hash(t);
    }
}
