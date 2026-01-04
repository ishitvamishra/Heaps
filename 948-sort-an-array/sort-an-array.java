class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> p = new PriorityQueue<>();

        for(int i =0;i<nums.length;i++){
            p.add(nums[i]);
        }

        for(int i =0;i<nums.length;i++){
            nums[i] = p.remove();
        }

        return nums;
    }
}