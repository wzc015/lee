package Median_of_Two_Sorted_Array_4;



public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int size1 = nums1.length;
        int size2 = nums2.length;


        int[] result = merge(nums1, nums2);


        double fe = 0;


        int answer = 0;

        if ((size1 + size2) % 2 == 1) {
            answer = (size1 + size2) / 2;
            fe = result[answer];
            //System.out.println("tank");
        } else {
            answer = (size1 + size2) / 2;
            fe = (double) (result[answer] + result[answer - 1]) / 2;
        }
        System.out.println(fe + "rabbit");
        return fe;

    }

    public int[] merge(int[] nums1, int[] nums2) {

        int a_len = nums1.length;
        int b_len = nums2.length;
        int[] result = new int[a_len + b_len];
        // i:用于标示a数组 j：用来标示b数组 k：用来标示传入的数组
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a_len && j < b_len) {
            if (nums1[i] <= nums2[j])
                result[k++] = nums1[i++];
            else
                result[k++] = nums2[j++];
        }

        // 后面连个while循环是用来保证两个数组比较完之后剩下的一个数组里的元素能顺利传入
        while (i < a_len) {
            result[k++] = nums1[i++];
        }

        while (j < b_len) {
            result[k++] = nums2[j++];
        }

        //System.out.println(Arrays.toString(result));

        return result;
    }

}
