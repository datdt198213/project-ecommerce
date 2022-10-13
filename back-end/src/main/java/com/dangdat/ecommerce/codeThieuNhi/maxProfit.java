package com.dangdat.ecommerce.codeThieuNhi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

public class maxProfit {

    public static int maxProfit(int[] prices) {
        int result = 0;

        int max = -9999;
        for(int i = 0; i < prices.length - 1; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                int i1 = prices[j] - prices[i];
                if(max < i1) max = i1;
            }
        }

        if(max <= 0) result = 0;
        else result = max;

        return result;
    }

    public static void main(String[] args) {
        int [] prices = {7,6,4,3,1};

        System.out.println("Ket qua: " + maxProfit(prices));
    }
}
