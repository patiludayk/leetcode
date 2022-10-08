package com.uday.practise.ps;

import static com.uday.practise.util.ColourConstant.RED;
import static com.uday.practise.util.ColourConstant.RESET;
import static com.uday.practise.util.ColourConstant.YELLOW_BACKGROUND;

/*Given a sequence of integers as an array, determine whether it is possible to obtain a strictly increasing sequence by removing no more than one element from the array.

Note: sequence a0, a1, ..., an is considered to be a strictly increasing if a0 < a1 < ... < an. Sequence containing only one element is also considered to be strictly increasing.

Example

For sequence = [1, 3, 2, 1], the output should be
solution(sequence) = false.

There is no one element in this array that can be removed in order to get a strictly increasing sequence.

For sequence = [1, 3, 2], the output should be
solution(sequence) = true.

You can remove 3 from the array to get the strictly increasing sequence [1, 2]. Alternately, you can remove 2 to get the strictly increasing sequence [1, 3].

Input/Output

[execution time limit] 3 seconds (java)

[input] array.integer sequence

Guaranteed constraints:
2 ≤ sequence.length ≤ 105,
-105 ≤ sequence[i] ≤ 105.

[output] boolean

Return true if it is possible to remove one element from the array in order to get a strictly increasing sequence, otherwise return false.*/
public class AlmostIncreasingSequence {


    boolean solution(int[] sequence) {
        int nearByRemoval = 0;
        int pre_next2Next_removal = 0;
        //1. first loop to check nearby element for comparison.
        for (int i = 0; i < sequence.length - 1; i++) {
            if (sequence[i] >= sequence[i + 1])
                ++nearByRemoval;
        }
        //2. second loop is to check pre and next to next element for comparison
        for (int i = 0; i < sequence.length - 2; i++) {
            if (sequence[i] >= sequence[i + 2])
                ++pre_next2Next_removal;
        }

        //3. condition to check if both above has increased value ie we found both cases in input which is invalid ie false output.
        return (nearByRemoval <=1) && (pre_next2Next_removal <= 1);
    }

    public static void main(String[] args) {
        AlmostIncreasingSequence increasingSequence = new AlmostIncreasingSequence();
        //1. [1, 3, 2, 1] >> false
        //2. [1, 3, 2] >> true
        //3. [1, 2, 1, 2] >> false
        //4. [3, 6, 5, 8, 10, 20, 15] >> false
        //5. [1, 1, 2, 3, 4, 4] >> false
        //6. [1, 4, 10, 4, 2] >> false
        //7. [10, 1, 2, 3, 4, 5] >> true
        //8. [1, 1, 1, 2, 3] >> false
        //9. [0, -2, 5, 6] >> true
        //10. [1, 2, 3, 4, 5, 3, 5, 6] >> false
        //11. [3, 5, 67, 98, 3] >> true
        //12. [1, 2, 3, 4, 99, 5, 6] >> true
        //13. 3, 6, 5, 8, 10, 20, 15 >> false
//        final boolean output = increasingSequence.solution(new int[]{1, 3, 2, 1});
//        final boolean output = increasingSequence.solution(new int[]{10, 1, 2, 3, 4, 5});
//        final boolean output = increasingSequence.solution(new int[]{3, 6, 5, 8, 10, 20, 15});
        final boolean output = increasingSequence.solution(new int[]{1, 2, 1, 2});
        System.out.print(YELLOW_BACKGROUND);
        System.out.println(RED + output + RESET);
    }

}
