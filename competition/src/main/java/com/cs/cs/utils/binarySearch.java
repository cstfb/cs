package com.cs.cs.utils;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by fengbo on 16/7/30.
 */
public class binarySearch {

    public static void main(String[] args) {
        long[] ar = new long[]{5,7,8,18,23,57,59,61,73,92};
//        Random r = new Random();
//        for (int i = 0; i < 10; i++) {
//            System.out.debuginfo(r.nextInt(100));
//        }
        Arrays.sort(ar);
        for (int i = 0; i < 10; i++) {
            System.out.print(ar[i] + ",");
        }
        System.out.println();
        System.out.println(findLeft(59 , ar , 0 , 10));
        System.out.println(findLeft(5 , ar , 0 , 10));
        System.out.println(findLeft(8 , ar , 2 , 2));
        System.out.println(findLeft(8 , ar , 2 , 10));
        System.out.println(findLeft(8 , ar , 0 , 10));
        System.out.println();
        System.out.println(findRight(59, ar, 0, 10));
        System.out.println(findRight(5, ar, 0, 10));
        System.out.println(findRight(8, ar, 2, 2));
        System.out.println(findRight(8, ar, 2, 10));
        System.out.println(findRight(9, ar, 0, 10));
    }

    /**
     * left bound ,$end param exclude
     */
    private static long findLeft(long val , long[] array , long start , long end){
        int _start  = (int)start, _end = (int)end ;
        long _val = val ;
        long[] _array = array ;

        if(_end < _start || _start < 0 || _end < 0 ) return -1 ;

        int _from = _start , _to = _end ;
        int _mid ;

        while(_to - _from  > 1){
            _mid = (_to + _from)/2;
            if(_array[_mid] >= _val ) _to  = _mid ;
            else _from = _mid ;
        }
        if(_from - 1 >= _start && _array[_from - 1] == _val) return _from - 1 ;
        if(_array[_from] == _val ) return _from ;
        if(_to - 1 >= _start && _array[_to - 1] == _val) return _to - 1;
        if(_to < _end && _array[_to] == _val) return _to ;
        return -1 ;
    }

    /**
     * right bound , $end param exclude
     */
    private static long findRight(long val , long[] array ,long start , long end){
        int _start  = (int)start, _end = (int)end ;
        long _val = val ;
        long[] _array = array ;

        if(_end < _start || _start < 0 || _end < 0 ) return -1 ;

        int _from = _start , _to = _end ;
        int _mid ;

        while(_to - _from  > 1){
            _mid = (_to + _from)/2;
            if(_array[_mid] > _val ) _to  = _mid ;
            else _from = _mid ;
        }
        if(_to < _end && _array[_to] == _val) return _to ;
        if(_to - 1 >= _start && _array[_to - 1] == _val) return _to - 1;
        if(_array[_from] == _val ) return _from ;
        if(_from - 1 >= _start && _array[_from - 1] == _val) return _from - 1 ;
        return -1 ;
    }
}
