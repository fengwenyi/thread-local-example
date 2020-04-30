package com.fengwenyi.threadlocalexample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Erwin Feng
 * @since 19:29
 */
@RestController
@RequestMapping("/stat")
public class StatController {

    private static Set<Val<Integer>> set = new HashSet<>();

    private static synchronized void addSet(Val<Integer> val) {
        set.add(val);
    }

    private static ThreadLocal<Val<Integer>> localSet = ThreadLocal.withInitial(() -> {
        Val<Integer> val = new Val<>();
        val.set(0);
        addSet(val);
        return val;
    });

    @RequestMapping("/add")
    public Integer add() {
        Val<Integer> val = localSet.get();
        Integer c = val.get() + 1;
        val.set(c);
        return 1;
    }

    @RequestMapping("/get")
    public Integer get() {
        if(set.size()<1){
            return -1;
        }
        return set.stream().map(Val::get).reduce(Integer::sum).get();
    }

}
