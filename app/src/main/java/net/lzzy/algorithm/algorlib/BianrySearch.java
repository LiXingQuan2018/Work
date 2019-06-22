package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/22.
 * Description:
 */
public class BianrySearch<T extends Comparable<? super T>> extends BaseSearch<T> {
    BianrySearch(T[] items) {
        super(items);
    }

    @Override
    int search(T key) {
        return -1;
    }
}
