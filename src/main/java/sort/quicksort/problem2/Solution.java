package sort.quicksort.problem2;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSortHelper(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private void quickSortHelper(int[] nums, int start, int end) {
        if (end - start <= 0) {
            return;
        }

        int pivot = nums[end];
        int pivotPosition = start;

        for (int i = start; i <= end - 1; i++) {
            if (pivot > nums[i]) {
                int temp = nums[pivotPosition];
                nums[pivotPosition] = nums[i];
                nums[i] = temp;
                pivotPosition++;
            }
        }

        nums[end] = nums[pivotPosition];
        nums[pivotPosition] = pivot;

        quickSortHelper(nums, start, pivotPosition - 1);
        quickSortHelper(nums, pivotPosition + 1, end);
    }
}
