package com.crystallake.wanandroid;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        int[] cand = {2,3,6,7};
        int target = 7;
        combinationSum(cand,target);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length==0){
            return res;
        }
        Deque<Integer> tmp = new ArrayDeque<>();
        dfs(res,tmp,candidates,0,target);

        return res;
    }

    private void dfs(List<List<Integer>> res, Deque<Integer> tmp, int[] candidates, int begin, int target){
        if(target<0){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(tmp));
            return;
        }

        for(int i=begin;i<candidates.length;i++){
            System.out.println(begin);
            tmp.addLast(candidates[i]);
            dfs(res,tmp,candidates,i,target-candidates[i]);
            tmp.removeLast();
        }
    }
}