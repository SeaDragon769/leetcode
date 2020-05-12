package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    int[] num=nums;
    List<List<Integer>> result=new ArrayList<>();

    int i = 0;
    while (i <= num.length - 3 && num[i] <= 0) {
      if (i == 0 || num[i] != num[i - 1]) {
        int keyValue = num[i];
        int left = i + 1;
        int right = num.length - 1;
        while (left < right) {
          int sum = keyValue + num[left] + num[right];
          if (sum == 0) {
            List<Integer> triple=new ArrayList<>();
            triple.add(num[i]);
            triple.add(num[left]);
            triple.add(num[right]);
            result.add(triple);
            while (left < right && num[left + 1] == num[left]) {
              left += 1;
            }
            while (right > left && num[right - 1] == num[right]) {
              right -= 1;
            }
            left+=1;
            right-=1;
          } else if (sum > 0) {
            right -= 1;
          } else {
            left += 1;
          }
        }
      }
      i += 1;
    }
    return result;
  }


}
