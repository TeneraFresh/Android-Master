package com.android.tenera.Utils;

import com.android.tenera.model.ProductDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raghavendra on 09/07/16.
 */
public class Utils {

    private static ArrayList<List<ProductDTO>> menuItems;
    private static ArrayList<String> collecionTitles;
    private static ArrayList<String> collectionIds;


    public static ArrayList<String> getCollectionIds() {
        return collectionIds;
    }

    public static void setCollectionIds(ArrayList<String> collectionIds) {
        Utils.collectionIds = collectionIds;
    }

    public static ArrayList<String> getCollecionTitles() {
        return collecionTitles;
    }

    public static void setCollecionTitles(ArrayList<String> collecionTitles) {
        Utils.collecionTitles = collecionTitles;
    }


    public static ArrayList<List<ProductDTO>> getMenuItems() {
        if (menuItems == null) {
            menuItems = new ArrayList<>();
        }
        return menuItems;
    }

    public static String addRuppeSymbol(String value) {
        return "\u20B9 " + value;
    }

}
