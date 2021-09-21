# LeetCode Notes

## 二分搜索（Binary Search）
<a href="#lc33">`33. Search in Rotated Sorted Array`</a>

<a href="#lc34">`34. Find First and Last Position of Element in Sorted Array`</a>


## 动态规划（Dynamic Programming）
<a href="#lc32">`32. Longest Valid Parentheses`</a>

---































<a id="lc32">

#### [32. Longest Valid Parentheses](https://leetcode-cn.com/problems/longest-valid-parentheses/)

##### Approach1: 动态规划

用 $dp[i]$ 来记录 以 $i$ 为终点处最长的合法子串长度，初始化 $dp$ 所有值为0，遇到右括号 ')' ， 并且向前能匹配到对应的左括号，说明此处可能存在合法子串。则：

该处子串的长度 = 2（代表此处右括号和向前匹配到的左括号）；

​							+ 前一个合法子串长度（代表左右括号内的合法子串长度）；

​                            + 左括号前合法子串的长度。

所以有转移方程：
$$
dp[i] = 2+dp[i-1]+dp[pre-1]
$$
其中 $pre$ 表示所匹配到的左括号的下标，$pre=i-1-dp[i-1]$ 。

过程中需要检验：

1. $pre$ 是否存在、所指元素是否为 $'('$；   <--------能否匹配到左括号
2. $pre-1$ 是否存在。                                <---------匹配到的左括号前面有无合法子串

举例： s = (      (         )         (         )               )         )

dp:             0	0	2+0+0	0	2+0+2	2+4+0	0	

代码如下：

```java
public class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int maxLen = 0;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                int preLen = dp[i - 1];
                int pre = i - 1 - preLen;
                if (pre >= 0 && s.charAt(pre) == '(') {
                    dp[i] = preLen + 2;
                    if (pre - 1 >= 0) {
                        dp[i] += dp[pre - 1];
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }
```

时间复杂度：$O(n)$	顺序扫描

空间复杂度：$O(n)$	一维数组$dp[n]$



##### Approach2: 栈

用一个栈存储字符的**下标**，顺序扫描字符串

遇左括号进栈；

遇右括号：

1. 若栈为空，进栈；
2. 栈顶元素出栈（匹配的左括号），更新最大长度。

最大长度计算方法：当前扫描到的位置下标 - 出栈后栈顶元素

**为了避免出栈后空栈的情况，初始化栈后向栈内预置$-1$作为参照物。**

举例：s= )  (  )  (  )  )

| i    | s[i] | 操作                  | 栈内元素     | ans  |
| ---- | ---- | --------------------- | ------------ | ---- |
|      |      | 初始化                | -1           | 0    |
| 0    | )    | 入栈                  | -1    0      | 0    |
| 1    | (    | 入栈                  | -1    0    1 | 0    |
| 2    | )    | 栈顶元素出栈，更新ans | -1    0      | 1    |
| 3    | (    | 入栈                  | -1    0    3 | 1    |
| 4    | )    | 栈顶元素出栈，更新ans | -1    0      | 4    |
| 5    | )    | 入栈                  | -1    0    5 | 4    |

```java
public class Solution {
    public int longestValidParentheses(String s) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }
}
```

时间复杂度：$O(n)$	顺序扫描

空间复杂度：$O(n)$	栈




<a id="lc33">

#### [33. Search in Rotated Sorted Array](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)

##### Approach1: 比较左值

二分搜索，用$mid$划分数组为顺序和错序区域，再优先考虑$target$是否在顺序区域。

一、$nums[left] ≤ nums[mid]$ 说明数组$[left, mid]$ 是顺序的，$(mid,right]$存在错序：

​	1.如果$nums[left]≤target<nums[mid]$，缩小搜索范围为左半顺序区域；

​	2.如果$nums[mid]<target$，缩小搜索范围到右半错序区域 。

二、$nums[left] > nums[mid]$ 说明数组$[left, mid]$ 存在错序，$(mid,right]$是顺序的：

​	1.如果$nums[mid]<target≤nums[right]$，缩小搜索范围为右半顺序区域；

​	2.如果$target<nums[mid]$，缩小搜索范围到左半错序区域。

```java
public int search(int[] nums, int target) {
    int n = nums.length;
    int left = 0;
    int right = n - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] >= nums[left]) {  // [left, mid] is ordered, (mid, right] is unordered
            if (target < nums[mid] && target >= nums[left]) { // narrow range to 'ordered'
                right = mid - 1;
            } else {    // narrow range to 'unordered'
                left = mid + 1;
            }
        } else { // (mid, right] is ordered, [left, mid] is unordered
            if (target > nums[mid] && target <= nums[right]) { // narrow range to 'ordered'
                left = mid + 1;
            } else { // narrow range to 'unordered'
                right = mid - 1;
            }
        }
    }
    return -1;
}
```



##### Approach2: 两次搜索

第一次搜索旋转数组的最小值的下标 $minIndex$，将数组分为有序的两段，通过比较 $target$ 和 $nums[0]$ 判断接下来要搜索的部分，限定搜索范围，再进行常规二分搜索即可。

寻找旋转数组最小下标（[153. Find Minimum in Rotated Sorted Array](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)）：

```java
int lo = 0;
int hi = nums.length - 1;
while (lo < hi) {
    int mid = (lo + hi) / 2;
    if (nums[mid] > nums[hi]) {	//[mid, hi]错序，(mid, hi]存在pivot
        lo = mid + 1;	
    } else {	// [mid, hi]有序，则[lo, mid)顺序，[lo, mid]存在pivot
        hi = mid;
    }
}
```

最终 $minIndex = lo=hi$，下面重新限定搜索范围：

```java
int minIndex = lo;
if (minIndex == 0) {	// 避免minIndex-1<0
    lo = 0;
    hi = n - 1;
} else if (target >= nums[0]) {
    hi = minIndex - 1;
    lo = 0;
} else {
    lo = minIndex;
    hi = n - 1;
}
```

进行常规二分搜索：

```java
while (lo <= hi) {
    int mid = (lo + hi) / 2;
    if (nums[mid] == target) {
        return mid;
    } else if (nums[mid] < target) {
        lo = mid + 1;
    } else {
        hi = mid - 1;
    }
}
```






<a id="lc34"/>

#### [34. Find First and Last Position of Element in Sorted Array](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

##### Approach1: 两次搜索

寻找 $target$ 的右边界和仅次于 $target$ 的数的右边界，前者为结果的右值，后者-1为结果的左值。

```java
public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
        return new int[] {-1, -1};
    }
    int left = findRightBorder(nums, target - 1);   
    int right = findRightBorder(nums, target);
    // 若target和比它小的数的右边界一样，意味着找到的都是比target小的数的右边界，说明没找到target
    if (left == right) {    
        return new int[] {-1, -1};
    }
    return new int[] {left, right - 1};
}

```

寻找右边界的函数如下，一些细节：

1. $hi=nums.length$ 而不再$-1$是为了考虑当$nums[]$内只有一个值的情况，否则两次直接返回0导致left==right。
2. $hi=mid$ 由于$mid$本身可能就是右边界，而$hi$缩小后范围的右边界，因此不能向左越过 $mid$。
3. $lo=mid+1$ 是因为我们要尽可能让边界“向右缩”，因此 $lo$ 可以向右越过 $mid$。

```java
private int findRightBorder(int[] nums, int target) {
    int lo = 0;
    int hi = nums.length;
    while (lo < hi) {
        int mid = (lo + hi) / 2;
        if (nums[mid] > target) {
            hi = mid;
        } else {
            lo = mid + 1;
        }
    }
    return hi;
}
```





















#### 36. Valid Sudoku

有HashSet版本和Array版本，用Array更快因为Array查询时间严格为$O(1)$，而HashSet查询时间为均摊为$O(1)$

大多数的哈希表计数问题，都能转换为使用数组解决。

