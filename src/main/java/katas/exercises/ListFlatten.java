package katas.exercises;

import java.util.ArrayList;
import java.util.List;

public class ListFlatten {

    /**
     * Flattens a nested list into a single list of integers.
     *
     * @param nestedList the input nested list
     * @return a flat list containing all integers from the nested structure
     */
    public static List<Integer> flattenList(List<Object> nestedList) {
        List<Integer> outputList = new ArrayList<>();
        int i = 0;
        while(nestedList.size() > i){
            if(nestedList.get(i) instanceof Integer) outputList.add((Integer) nestedList.get(i));
            else if(nestedList.get(i) instanceof List<?>){
                outputList.addAll(flattenList((List<Object>) nestedList.get(i)));
            }
            else{
                throw new IllegalArgumentException("invalid input type");
            }
            i++;
        }


        // hint: instanceof
        return outputList;
    }

    public static void main(String[] args) {
        List<Object> nestedList = new ArrayList<>();
        nestedList.add(1);
        nestedList.add(List.of(2, 3));
        nestedList.add(List.of(4, List.of(5, 6)));
        nestedList.add(7);



        List<Integer> flatList = flattenList(nestedList);

        System.out.println("Flattened list: " + flatList);
    }
}
