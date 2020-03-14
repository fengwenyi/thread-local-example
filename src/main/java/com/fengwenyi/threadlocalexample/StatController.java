package com.fengwenyi.threadlocalexample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Erwin Feng
 * @since 19:29
 */
@RestController
@RequestMapping("/stat")
public class StatController {

    private static Set<Val<Integer>> set = new HashSet<>();

    static synchronized void addSet(Val<Integer> val) {
        set.add(val);
    }

    private static ThreadLocal<Val<Integer>> x = new ThreadLocal<Val<Integer>>() {
        @Override
        protected Val<Integer> initialValue() {
            Val<Integer> val = new Val<>();
            val.set(0);
            addSet(val);
            return val;
        }
    };

    @RequestMapping("/add")
    public Integer add() {
        Val<Integer> val = x.get();
        Integer c = val.get() + 1;
        val.set(c);
        return 1;
    }

    @RequestMapping("/get")
    public Integer get() {
        return set.stream().map(Val::get).reduce(Integer::sum).get();
    }

}
