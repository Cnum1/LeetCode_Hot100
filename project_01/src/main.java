/**
 *给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 解释：
 * 在 strs 中没有字符串可以通过重新排列来形成 "bat"。
 * 字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
 * 字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * 提示：
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
import java.util.*;

class solution_49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // 创建一个哈希表来存储字母异位词组
        Map<String, List<String>> anagramGroups = new HashMap<>();

        // 遍历每个字符串
        for (String str : strs) {
            // 将字符串转换为字符数组并排序
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            // 将排序后的字符数组转换回字符串
            String sortedStr = new String(charArray);

            // 如果哈希表中没有这个排序后的字符串作为键，则创建一个新的列表
            if (!anagramGroups.containsKey(sortedStr)) {
                anagramGroups.put(sortedStr, new ArrayList<>());
            }
            // 将原始字符串添加到对应的列表中
            anagramGroups.get(sortedStr).add(str);
        }

        // 返回哈希表中的所有值，即字母异位词组列表
        return new ArrayList<>(anagramGroups.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result); // 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

        String[] strs2 = {""};
        List<List<String>> result2 = groupAnagrams(strs2);
        System.out.println(result2); // 输出: [[""]]

        String[] strs3 = {"a"};
        List<List<String>> result3 = groupAnagrams(strs3);
        System.out.println(result3); // 输出: [["a"]]
    }
}

/**给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 O(n) 的算法解决此问题。



示例 1：

输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
示例 2：

输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9
示例 3：

输入：nums = [1,0,1,2]
输出：3


提示：

0 <= nums.length <= 105
-109 <= nums[i] <= 109*/
class Solution_128 {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int count=1;
        int max=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
                if(nums[i]+1!=nums[i+1]){
                    count=1;
                }else{
                    max=Math.max(max,++count);
                }
            }
        }
        return max;
    }
}