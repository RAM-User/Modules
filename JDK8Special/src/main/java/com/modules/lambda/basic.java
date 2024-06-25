package com.modules.lambda;

import com.modules.pojo.Sale;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class basic {

    private static final List<Sale> SALE_LIST = Arrays.asList(
            new Sale("1", 1307),
            new Sale("1", 14270),
            new Sale("2", 17995),
            new Sale("3", 18688),
            new Sale("4", 40334),
            new Sale("4", 51374),
            new Sale("5", 76418),
            new Sale("3", 100007),
            new Sale("2", 70484),
            new Sale("11", 104063),
            new Sale("10", 66060),
            new Sale("7", 11868)
    );
    @Test
    public void bestSale() {

            int[] nums = new int[]{3, 2, 2, 3};
            int i = removeElement(nums, 3);
        System.out.println(i);

    }

    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int num : nums) {
            if (num != val) {
                nums[slow++] = num;
            }
        }
        return slow;
    }

    @Test
    public void test() {
        String a = "a";
        System.out.println(a.intern());
    }
}
