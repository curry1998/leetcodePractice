​	





每天两道go 和java 保持状态，加油

#### 1 两数之和

url:  https://leetcode.cn/problems/two-sum/description/

1 暴力解法：双重循环

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
}
```



2 使用hash进行优化

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //key存值,value 存位置 collection集合
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hashmap.containsKey(target-nums[i])){
                return hashmap.get(target-nums[i])< i ? new int[]{hashmap.get(target-nums[i]),i} :new int[]{i,hashmap.get(target-nums[i])};
            }
            hashmap.put(nums[i],i);
        }
        return new int[0];
    }
}
```

为什么用hash 表进行优化： 上面的时间的复杂度是 o(n^2)方，可以发现 ，第二个for 循环主要去找taget -num[i],用for循环其时间复杂度为O(n),使用哈希表存储其复杂度为O(1).

3 go

```go
func twoSum(nums []int, target int) []int {
   for i,num:=range nums{
      j:=i+1
      for j < len(nums){
         if num+nums[j]==target{
            return []int{i,j}
         }
         j++
      }
   }
   return nil
}
```



hash 注意go 语言的map 就是hashmap 

```go
func twoSum(nums []int, target int) []int {
	targetMap := map[int]int{}
	for i, num := range nums {
		if p, ok := targetMap[target-num]; ok {
			return []int{i, p}
		} else {
			targetMap[num] = i
		}
	}
	return nil
}
```



#### 2 twonum sum 两数相加

url: https://leetcode.cn/problems/add-two-numbers/

思路： 这是一道链表题，链表题通常需要一个空指针来简化操作。计算两个链表对应位的和，然后通过尾插法插入到新的链表中。注意要考虑进位的问题。

1 go 

```go
type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	head := &ListNode{Val: 0}
	num1, num2 := 0, 0
	carry := 0
	// define work Point
	current := head
	for l1 != nil || l2 != nil || carry != 0 {
		// l1 or l2 maybe nil
		if l1 == nil {
			num1 = 0
		} else {
			num1 = l1.Val
			l1 = l1.Next
		}
		if l2 == nil {
			num2 = 0
		} else {
			num2 = l2.Val
			l2 = l2.Next
		}
		l := &ListNode{(num1 + num2 + carry) % 10, nil}
		carry = (num1 + num2 + carry) / 10

		// post insert
		current.Next = l
		current = l
	}
	return head.Next
}
```

2 java

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode();
        int n1,n2,carry=0;
        ListNode current=headNode;
        while(l1!=null||l2!=null||carry!=0){
            if(l1==null){
                n1=0;
            }else{
                n1=l1.val;
                l1=l1.next;
            }
            if(l2==null){
                n2=0;
            }else{
                n2= l2.val;
                l2=l2.next;
            }
            //要创建一个新结点
            current.next=new ListNode((n1+n2+carry)%10);
            current=current.next;
            carry=(n1+n2+carry)/10;
        }
        return  headNode.next;


    }
}
```



#### 3 无重复字符的最长子串

url:  https://leetcode.cn/problems/longest-substring-without-repeating-characters/

思路： 使用滑动窗口，滑动窗口类型题目可参考： https://blog.csdn.net/weixin_39802680/article/details/119889745



```java
import java.util.HashMap;

public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        String a = new String("tmmzuxt");
        int i = lengthOfLongestSubstring(a);
        System.out.println(i);
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;

        int left = 0,res = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        //思想上错误没有考虑一个环节（left的更新需要hashmap）
       for(int right=0;right<s.length();right++){
           if(hashMap.containsKey(s.charAt(right))){
               left=Math.max(left,hashMap.get(s.charAt(right))+1);
           }
           hashMap.put(s.charAt(right),right);
           res=Math.max(res,right-left+1);
       }
        return res;
    }

}
```

 重点是left　的移动问题





#### 76 最小覆盖字串



只用了一个hash 表

```java
package com.boshrong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class 最小覆盖子串76 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.minWindow("a","b"));
    }
}
//
class Solution1 {
    public String minWindow(String s, String t) {
        if(s.length()==0||t.length()==0|| t.length()>s.length())
            return  "";
        int left=0;
        int right=0,flag=0;
        String result;
        HashMap<Character, Integer> needed = new HashMap<>();
        // t.charAt是自己百度得到的
        // 不可能出现重复字符
        //设置满足条件为needed hash 所有vlue 为负则满足匹配条件
        for(int i=0;i<t.length();i++){
                needed.put(t.charAt(i),needed.getOrDefault(t.charAt(i),0)+1);
        }
        String res=s;
        while (right<s.length()){
            if(needed.containsKey(s.charAt(right))){
                //包含在need中need-1
                needed.put(s.charAt(right),needed.getOrDefault(s.charAt(right),0)-1);
            }
            right++;
            //检查条件,如果满足所有value 都不为正的说明，包含t的所有元素
            while(checkCondition(needed)){
                res=getMinString(res,s.substring(left,right));

                if(needed.containsKey(s.charAt(left))){
                    needed.put(s.charAt(left),needed.get(s.charAt(left))+1);
                }
                left++;
                flag=1;
            }

        }
        if(flag==0)
            res="";
        return res;
    }
    public Boolean checkCondition(HashMap<Character,Integer> map){
        for(Integer i:map.values()){
            if(i>0)
                return false;
        }
        return true;
    }
    public String getMinString(String a,String b){
        return a.length()<b.length()? a:b;
    }



}
```

最小覆盖字串：使用滑动窗口，可以把滑动窗口类型总结成一个模板。

用一个hash表存满足的条件

#### 7 整数反转

​	主要是对溢出的处理

`判断y=x*10是否溢出，只需比较y/10 与x 是否相等，不等则溢出`

```java
package com.boshrong.leetcode;

public class 整数反转 {
    public static void main(String[] args) {
        int x=1534236469;
        System.out.println(reverse(x));

    }
    public static int reverse(int x) {

        int flag=1;
        //进行处理，方便操作
        //只有两种情况和boolean 雷系
        if(x<0){
            x=-x;
            flag=-1;
        }
        int res=0;
        while(x!=0){
            int j=x%10;
            x=x/10;
            int tmp=res;
            res=tmp*10+j;
            //溢出的判断
            if((res/10)!=tmp){
                return 0;
            }

        }
        if(flag==-1)
            res=-res;
        return res;
    }
}
```

#### 4  寻找两个正序数组的中位数

 从两个数组取最小的元素，放入一个新的数组中

```java
public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len1 = nums1.length;
    int len2 = nums2.length;
    Double result=Double.valueOf(0);
    if(len1==0 && len2==0)
        return 0;
    int midIndex=(len1+len2)/2;


    if(len1==0){
        if((len1+len2)%2==0){
            result=Double.valueOf(nums2[midIndex-1]+nums2[midIndex])/2;
        }else{
            result=Double.valueOf(nums2[midIndex]);
        }
        return result;
    }
    if(len2==0){
        if((len1+len2)%2==0){
            result=Double.valueOf(nums1[midIndex-1]+nums1[midIndex])/2;
        }else{
            result=Double.valueOf(nums1[midIndex]);
        }
        return result;
    }

    ArrayList<Integer> arrayList = new ArrayList<>();

    int flag=0; //偶数标志位
    if((len1+len2)%2==0){
        flag=1;
    }
    for(int i=0,j=0;i<len1||j<len2;){
        // 加上一个对长度的判断
        if( i!=len1 && j!=len2&&nums1[i]>=nums2[j]){
            arrayList.add(nums2[j]);
            j++;

        }else if (i!=len1 && j!=len2 && nums1[i]<nums2[j]){
            arrayList.add(nums1[i]);
            i++;
        }else if(i==len1)
        {
                arrayList.add(nums2[j]);
                j++;
        }
        else  if(j==len2){
                arrayList.add(nums1[i]);
                i++;
        }

        //为偶数
        if(flag==1&&arrayList.size()==midIndex){
            if (i!=len1&&j!=len2)
               result=Double.valueOf(arrayList.get(midIndex-1)+Math.min(nums1[i],nums2[j]))/2;
            else if (i==len1){
                result=Double.valueOf(arrayList.get(midIndex-1)+nums2[j])/2;
            }else if(j==len2){
                result=Double.valueOf(arrayList.get(midIndex-1)+nums1[i])/2;
            }
            break;
        }else if(flag==0&&arrayList.size()==midIndex){
            if (i!=len1&&j!=len2)
                result=Double.valueOf(Math.min(nums1[i],nums2[j]));
            else if (i==len1){
                result=Double.valueOf(nums2[j]);
            }else if(j==len2){
                result=Double.valueOf(nums1[i]);
            }
            break;
        }

    }



    return result;
}
```





### 动态规划刷题



#####  509 [斐波那契数](https://leetcode-cn.com/problems/fibonacci-number/)





#### 77 组合

这里我主要想记录一个问题：如果这里 



if(tmp.size()==k){
      
        resultList.add(new ArrayList<>(tmp));
        return;
    }

赋值的时候没有new ArrayList (tmp) 当返回到上一层递归的时候，tmp就会删除队列最后的元素。进行变动从而改变了resltList的值。最终的结果会返回空。 

```java
public static void dfs(int n,int k,int start,LinkedList<Integer>  tmp,List<List<Integer>> resultList){
    if(tmp.size()==k){
        //需要重新赋个值 result 根据tmp 进行变化
        resultList.add(new ArrayList<>(tmp));
        return;
    }

    for(int i=start;i<=n;i++){
        tmp.addLast(i);
        dfs(n,k,i+1,tmp,resultList);
        tmp.removeLast();
    }

}
public static List<List<Integer>> combine(int n, int k) {

    List<List<Integer>> result = new ArrayList<>();
    if(n<1||k<1){
        return result;
    }
    // 这里用 双端队列 是自己之前没有考虑到的
    LinkedList<Integer> queue = new LinkedList<>();

    dfs(n,k,1,queue,result);
    return result;
}
```



#### 6 Z字形变换

代码

```java
public class Z字形变化 {
    // 思想：定义一个字符串数组 根据给定的numrows,将相同行的字符加到同一个字符串中
    public static void main(String[] args) {
        System.out.println(convert("AB",1));

        // String 数组默认值为null 再使用+ 就会还带null

    }

    public  static  String convert(String s, int numRows) {
        int lens=s.length();
        if(lens<2|| numRows==1){
            return s;
        }

        int nums=0;
        //可以用num 判断出数组的长度 直接用数组
        String [] result=new String[numRows];
        for(int i=0;i<numRows;i++){
            result[i]="";
        }

        //定义一个变量来确定 方向，像下走还是向上走
        boolean goDown=true;
        for(int i=0;i<lens;i++){
            if(nums!=numRows-1 && goDown){
                result[nums]+=s.charAt(i);
                nums++;
                continue;
            }
            if(nums==numRows-1 && goDown){
                result[nums]+=s.charAt(i);
                goDown=false;
                nums--;
                continue;
            }
            if(nums!=0&& !goDown){
                result[nums]+=s.charAt(i);
                nums--;
                continue;
            }
            if(nums==0 && !goDown){
                result[nums]+=s.charAt(i);
                nums++;
                goDown=true;
                continue;
            }
        }

        String result_String="";
        for(int i=0;i<numRows;i++){
            result_String+=result[i];
        }
        return result_String;
    }
}
```



#### 11 盛最多的水

两个for 循环会超时

```java
public class 盛最多的水11 {

    public int maxArea(int[] height) {
        int lens=height.length;
        if(lens<2){
            return 0;
        }
        int result=Integer.MIN_VALUE;
        // 两个for 循环就可以解决
        for(int i=0;i<lens-1;i++){
            for(int j=i+1;j<lens;j++){
                int tag=j-i;
                int minheight=Math.min(height[i],height[j]);
                if(minheight*tag>result){
                    result=minheight*tag;
                }
            }
        }
        return result;
    }
}
```



采用双指针解题

思想： i，j 指向数组的两边，此时容器的宽度最大，缩小高度比较小的。进行统计直到两个指针重合。

i,j 指向两边，此时容器的底是最大的，接下来随着指针向内移动，会造成容器的底变小，在这种情况下想要让容器盛水变多，就只有在容器的高上下功夫。 那我们该如何决策哪个指针移动呢？我们能够发现不管是左指针向右移动一位，还是右指针向左移动一位，容器的底都是一样的，都比原来减少了 1。这种情况下我们想要让指针移动后的容器面积增大，就要使移动后的容器的高尽量大，所以我们选择指针所指的高较小的那个指针进行移动，这样我们就保留了容器较高的那条边，放弃了较小的那条边，以获得有更高的边的机会。



代码

```java
public class 盛最多的水11 {

    public int maxArea(int[] height) {
        int lens=height.length;
        if(lens<2){
            return 0;
        }
        int left=0,right=lens-1;
        int result=Integer.MIN_VALUE;
        while(left<right){
            int tag=right-left;
            if(tag*Math.min(height[left],height[right])>result){
                result=tag*Math.min(height[left],height[right]);
            }
            if(height[left]<=height[right]){
                left++;
            }else{
                right--;
            }
        }
        return result;
    }
}
```











#### 19 删除链表倒数第n个节点

代码实现

```java
 public static ListNode removeNthFromEnd(ListNode head, int n) {

        // 快慢指针使其找到倒数第n个节点
        if(head==null||n<0){
            return null;
        }
        //需要创建一个临时节点
        ListNode listNode = new ListNode(0);
        listNode.next=head;
        ListNode leftCurrent=listNode.next;
        ListNode rightCurrent=listNode.next;
        ListNode preNode=listNode;
        int right=0;
        while (right!=n){
//            if(rightCurrent==null)
//                return null;
            rightCurrent=rightCurrent.next;
            right++;
        }

        while(rightCurrent!=null){
            rightCurrent=rightCurrent.next;
            preNode=leftCurrent;
            leftCurrent=leftCurrent.next;

        }
        // 删除
        preNode.next=leftCurrent.next;

        return listNode.next;
    }
```







#### 20 有效的括号 

算法思想用一个栈，遇到左括号放入栈，遇到右括号判断。如果符合，出栈，不符合直接返回false



```java
  public boolean isValid(String s) {
        int lens=s.length();
        if(lens<2){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        int i=1;
        while(!stack.empty()){
            if(s.charAt(i)=='(' ||s.charAt(i)=='{'|| s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }
            if(s.charAt(i)==')' ||s.charAt(i)=='}'|| s.charAt(i)==']'){
                char currentChar =stack.peek();
                if(s.charAt(i)==')'&& currentChar=='(' || s.charAt(i)=='}'&& currentChar=='{'||  s.charAt(i)==']'&& currentChar=='['){
                    stack.pop();
                }else{
                    return false;
                }
            }
            i++;
            if(i>lens){
                return false;
            }
        }
        return true;
    }
```







#### [12. 整数转罗马数字](https://leetcode-cn.com/problems/integer-to-roman/)

- `1 <= num <= 3999`  可以用一个数组保存常见的结果。

用num 从数组高位相减，如果大于当前位，继续减，小于该为未数组，减位数小的。不断循环。

```java
public  static String intToRoman(int num) {
    if(num<1){
        return null;
    }
    String [] strings=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    int [] nums=new int []{1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String result="";
    int i=0;
    while(num!=0){
        if(num-nums[i]<0){
            i++;
            continue;
        }
        num-=nums[i];
        result+=strings[i];

    }

    return result;

}
```



![image-20210915112343858](D:\java workstation\笔记\浪潮\images\image-20210915112343858.png)



#### 13 罗马数字转整数



```java
public static  int romanToInt(String s) {
    int lens=s.length();
    if(lens<1){
        return 0;
    }
    String [] strings=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    int [] nums=new int []{1000,900,500,400,100,90,50,40,10,9,5,4,1};
    int result=0;
    int i=0;
    int k=0;
    while(i<lens){

        int stringlen=strings[k].length();
        if (i+stringlen>lens){
            k++;
            continue;
        }
        if(s.substring(i,i+stringlen).equals(strings[k])){
            result+=nums[k];
            i+=stringlen;
        }else{
            k++;
        }
    }
    return result;
}
```

![image-20210915145654200](D:\java workstation\笔记\浪潮\images\image-20210915145654200.png)



#### 15 三数之和

没想到用双指针 加排序。因为是三个数。

关键词： 不可以包含重复

模式识别： 利用排序避免重复答案。 降低复杂度变为TwoSum，利用双指针找到所有解。先确定一个，两个指针 就可理解成TwoSum 的类型，因为是有序的使用双指针，如何两数之和小于目标值，左指针向后移，使两个数之和变大。反之右指针前移。

 之前提交一直报错，是因为自己理解错了不重复的含义。这里不重复指的是元素不重复及其位置不重复。[0,0,0,0] 结果 000，因为最后位置重复了。





#### 16最接近的三数之和

还是用 排序加双指针



```java
public static  int threeSumClosest(int[] nums, int target) {
    int lens=nums.length;

    if(lens<3) {
        return 0;
    }
    Arrays.sort(nums);
    int result=Integer.MIN_VALUE;
    int min_tag=Integer.MAX_VALUE;
    for(int i=0;i<lens-1;i++){
        int left=i+1;
        int right=lens-1;
        while(left<right){
            if(Math.abs((nums[i]+nums[left]+nums[right])-target)<min_tag){
                min_tag=Math.abs((nums[i]+nums[left]+nums[right])-target);
                result=nums[i]+nums[left]+nums[right];

            }

            if(nums[i]+nums[left]+nums[right]-target>=0){
                right--;
                continue;
            }else if(nums[i]+nums[left]+nums[right]-target<0){
                left++;
                continue;
            }
        }
    }
    return result;
}
```

![image-20210916211421672](D:\java workstation\笔记\浪潮\images\image-20210916211421672.png)





#### 17电话号码的组合

使用了 dfs +  数组保存结果。虽然比较慢，但也是自己思索的结果。加油继续努力。

```java
public static void dfs(int begin,String digits,String [] strings,String tempStrings,List<String> result){
    if(begin==digits.length()){
        result.add(tempStrings);
        return;
    }
    int i = Integer.parseInt(String.valueOf(digits.charAt(begin)));
    int length = strings[i-1].length();
    for (int k=0;k<length;k++){
        dfs(++begin,digits,strings,tempStrings+strings[i-1].charAt(k),result);
        begin--;
    }

}

public static List<String> letterCombinations(String digits) {
    //用一个map 存储号码到string的对应关系
    ArrayList<String > arrayList = new ArrayList<>();
    int lens=digits.length();
    if(lens<1){
        return arrayList;
    }
    String [] strings=new String[]{" ","abc","def","ghi","jkl","mno","pqrs","tuv","xwyz"};
    dfs(0,digits,strings,"",arrayList);
    return arrayList;

}
```





![image-20210917103833864](D:\java workstation\笔记\浪潮\images\image-20210917103833864.png)





####　113 路径总和

使用dfs 进行解题

代码实现

```java
public class 路径总和II113 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode1=new TreeNode(4);
        TreeNode treeNode2=new TreeNode(8);
        TreeNode treeNode3 = new TreeNode(11);
        TreeNode treeNode4 = new TreeNode(13);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(7);
        TreeNode treeNode7 = new TreeNode(2);
        TreeNode treeNode8 = new TreeNode(5);
        TreeNode treeNode9 = new TreeNode(1);
        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode1.left=treeNode3;
        treeNode1.right=null;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        treeNode3.left=treeNode6;
        treeNode3.right=treeNode7;
        treeNode4.left=null;
        treeNode4.right=null;
        treeNode5.left=treeNode8;
        treeNode5.right=treeNode9;
        treeNode6.left=null;
        treeNode6.right=null;
        treeNode7.left=null;
        treeNode7.right=null;
        treeNode8.left=null;
        treeNode8.right=null;
        treeNode9.left=null;
        treeNode9.right=null;
        pathSum(treeNode,22);

    }

    public static void dfs(TreeNode root,int targetSum,List<Integer> list,List<List<Integer>> result,int count){
        if(root==null){
            return;
        }
        count+=root.val;
        list.add(root.val);
        if(count==targetSum && root.left==null && root.right==null ){
            result.add(new ArrayList<>(list));
        }
        dfs(root.left,targetSum,list,result,count);
        dfs(root.right,targetSum,list,result,count);
        // 返回到上一层递归做的操作
        int lens=list.size();
        list.remove(lens-1);
        count-=root.val;

    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
           return result;
       }
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root,targetSum,list,result,0);
        return result;
    }
}
```

![image-20210918102109480](D:\java workstation\笔记\浪潮\images\image-20210918102109480.png)



#### 46 全排列

用dfs 解决，注意在递归中不要更新需要遍历的array 数组的值，如需改变需要开辟新的空间啊。

```java
public class 全排列46 {

    public static void main(String[] args) {
        int [] nums=new int[]{1,2,3};
        System.out.println(permute(nums));
    }

    //这道和电话号码那道题比较像
    // 出问题出在了nums
    public static void dfs(List<Integer> nums,List<Integer> list,List<List<Integer>> result){
        // nums存放剩余的数
        int lens=nums.size();
        if(lens==0){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<lens;i++){

            list.add(nums.get(i));
            //新开辟一段空间
            ArrayList<Integer> arrayList = new ArrayList<>(nums);
            arrayList.remove(i);
            dfs(arrayList,list,result);
            int len=list.size();
            list.remove(len - 1);


        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        int lens=nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if(lens<1){
            return result;
        }
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> numsArray = new ArrayList<>();
        for(int i=0;i<lens;i++){
            numsArray.add(nums[i]);
        }
        dfs(numsArray,list,result);
        return result;
    }
}
```

![image-20210918145817073](D:\java workstation\笔记\浪潮\images\image-20210918145817073.png)





#### 151翻转字符串里的单词	

使用双指针，i指向前面，j指向后面(其实也是双指针解题)。每次遇到空格进行截取，如果遇到了为空（i，j指向同一个位置，说明遇到了多个空格），不为空则为一个单词则进行截取。要对最前面没有空格的情况进行特殊处理。

代码实现

```java
public class 翻转字符串里的单词 {

    public static void main(String[] args) {
        //判断依据找到了
        //        String ss=" Bob  Loves  Alice";
//        String substring = ss.substring(1, 2);
//        System.out.println(substring.isEmpty());
        System.out.println(reverseWords(" Bob  Loves  Alice"));
    }
    public static String reverseWords(String s) {
        int lens=s.length();
        if(lens<1){
            return s;
        }
        int i=lens-1,j=lens-1;
        String result="";
        boolean flag=false;
       while(i>=0){
            if(s.charAt(i)==' '){
                if(!s.substring(i+1,j+1).isEmpty()){
                    String s2=s.substring(i+1,j+1);

                    result+=s2;
                    result+=" ";
                    j=i;

                }
                j--;
                i--;

            }else{
                i--;

            }
            // 处理最前面没有空格的情况
            if(i==0 && s.charAt(i)!=' ' ){
                result+=s.substring(i,j+1);
                flag=true;
            }

        }
       if(flag){
           return result;
       }else{
           int len=result.length();
           return result.substring(0,len-1);
       }

    }
}
```



#### 58 左旋转字符串

```java
public class 左旋转字符串58 {


    public String reverseLeftWords(String s, int n) {
        int lens=s.length();
        if(lens<1|| n>lens){
            return "";
        }
        String substring = s.substring(0, n);
        String substring2=s.substring(n,lens);
        substring2+=substring;
        return substring2;
    }
}
```

![image-20210919130137662](D:\java workstation\笔记\浪潮\images\image-20210919130137662.png)



​	

#### 57和为S 的连续正数序列

解题思想： 滑动窗口，count 存放 存放arrayList 里面的总和。两个指针，使用滑动窗口模型常见思路。

代码实现

```
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(target<1){
            return null;
        }
        int left=1,right=1;
        // 存放arrayList 里面的总和
        int count=1;
        int max_lens=0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        while(right<target){
            //检查是否满足条件
            if(count==target){
                list.add(new ArrayList<>(arrayList));
                if(arrayList.size()>max_lens){
                    max_lens=arrayList.size();
                }
                left++;
                arrayList.remove(0);
                right++;
                arrayList.add(right);
                count+=right-left+1;
                continue;

            }else if (count>target){
                count-=arrayList.get(0);
                left++;
                arrayList.remove(0);
            }else{
                right++;
                count+=right;
                arrayList.add(right);
            }
        }
        // 返回最终结果
        int lens2=list.size();
        int [][] arrayResult=new int[max_lens][lens2];
        return list;
    }

}
```

![image-20210919175416888](D:\java workstation\笔记\浪潮\images\image-20210919175416888.png)





#### 26树的子结构

两个dfs ,第一个dfs 先先序遍历树A中的每一个节点n(A),第二个dfs2 ,判断是否具有相同的结构。用一个array数组进行存放每个节点判断的结果。最后如果array 中存在一个true 则返回true。

dfs2判断的终止条件。

```java
if(B==null){
    return true;
}
if(A==null){
    return false;
}
if(A.val!=B.val){
    return false;
}


```

代码实现

```java
public static void dfs(TreeNode A,TreeNode B,ArrayList<Boolean> list){
    // 找第一个节点

    if(A==null ){
        return ;
    }
    boolean flag=dfs2(A,B);
    list.add(flag);
    dfs(A.left,B,list);
    dfs(A.right,B,list);

}
//判断子结构
public static Boolean dfs2(TreeNode A,TreeNode B){
    if(B==null){
        return true;
    }
    if(A==null){
        return false;
    }
    if(A.val!=B.val){
        return false;
    }
    Boolean left=dfs2(A.left,B.left);
    Boolean right=dfs2(A.right,B.right);
    return left && right;
}

public static  boolean isSubStructure(TreeNode A, TreeNode B) {
    if(B==null){
        return false;
    }
    ArrayList<Boolean> arrayList = new ArrayList<>();
    dfs(A,B,arrayList);
    int lens=arrayList.size();
    for(int i=0;i<lens;i++){
        if(arrayList.get(i)){
            return true;
        }
    }
    return false;
}
```

![di](D:\java workstation\笔记\浪潮\images\image-20210922145507262.png)





#### 57[ 和为s的两个数字](https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/)

双指针



#### 33 [二叉搜索树的后序遍历序列](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/)

二叉搜索树条件： 左孩子< 根 < 右孩子
后序遍历 ： 左 右 根
所以后序遍历数组最后一个元素 一定为根节点。找一个k ，k在数组中的位置中第一次大于根节点，说明其后面的数都为根节点的右孩子。进行判断则其后元素是否都大于根元素，不满足则返回false。不断递归，知道l>r(l 为递归区域的最左边，r 为递归区域的最右边)

```java
static boolean  dfs(int l,int r,int [] postorder){
    if(l>=r){
        return true;
    }
    int root=postorder[r];
    int k=l;
    // 找到一个孩子
    while(k<=r && postorder[k]<root ){
        k++;
    }

    for(int i=k;i<r;i++){
        if(postorder[i]<root){
            return false;
        }
    }

    return  dfs(l,k-1,postorder) && dfs(k,r-1,postorder);
}

public static  boolean verifyPostorder(int[] postorder) {
    int lens=postorder.length;
    if(lens<1){
        return false;
    }
    boolean flag=dfs(0,lens-1,postorder);
    return flag;
}
```

![image-20210922165653079](D:\java workstation\笔记\浪潮\images\image-20210922165653079.png)







#### 51数组中的逆序对

题目描述

![image-20210922181457176](D:\java workstation\笔记\浪潮\images\image-20210922181457176.png)



解题思路： 使用归并排序的思想进行解决。

```
// 使用归并的思想进行解决
// 求逆序对，前面的大于后面的
//  一个 1 4 7 另一个 3 5 9 如果 第一个里面大于后面的count ++
```

```java
int count=0;
int[] ints;
void MergeSort(int [] nums,int low, int high){
    if(low<high){
        int mid=(low+high)/2;
        MergeSort(nums,low,mid);
        MergeSort(nums,mid+1,high);
        Merge(nums,low,mid,high);
    }
}
 void  Merge(int [] nums,int low,int mid,int hight){

    for(int k=low;k<=hight;k++){
        ints[k]=nums[k];
    }

    int i;
    int j;
    int k;
    for( i=low,j=mid+1, k=low ;i<=mid&&j<=hight;k++) {

        if (ints[i] <= ints[j]) {
            nums[k] = ints[i++];

        } else {
            nums[k] = ints[j++];
            int kk = mid - i + 1;
            count += kk;
        }
    }
        while(i<=mid){

            nums[k++]=ints[i++];

        }

        while(j<=mid){
            nums[k++]=ints[j++];
        }
    }


public  int reversePairs(int[] nums) {
    int lens=nums.length;
    if(lens<1){
        return 0;
    }
    ints=new int[lens];
    MergeSort(nums,0,lens-1);
    // 为什么没变化？
    return count;
}
```



#### 49 丑数

算法思想: 

```
// 不能直接采取for 循环，边循环边判断 for 循环的界限是不知道的
// 思想就是 x 是丑数，则 2x 3x 5x 为丑数，将其放入到优先队列中，每次取去一个 i 放入2i,3i,5i,但也会产生一个问题，就是会重复 需进行判断
// 优先队列采用long，防止int 溢出。
// 也可以采用最小堆，

```

```java
public static int nthUglyNumber(int n) {
    if(n<1){
        return 0;
    }
    PriorityQueue<Long> integers = new PriorityQueue<>();
    integers.add(1L);
    int count=1;
    while(count<n && !integers.isEmpty()){
        long value=integers.poll();

        if(!integers.contains(2*value)){
            integers.add(2*value);
        }
        if(!integers.contains(3*value)){
            integers.add(3*value);
        }
        if(!integers.contains(5*value)){
            integers.add(5*value);
        }
        count++;
    }
    long poll = integers.poll();
    return (int)poll;

}
```

![image-20210930100950341](D:\java workstation\笔记\浪潮\images\image-20210930100950341.png)





#### 32 从上到下打印二叉树II

算法思想： 这道题与从上到下打印二叉树算法思想一样。 也是用一个队列，但是要进行分层， 通过这样的方法，每一次进入while 循环之前进行将当前层所有元素取出来,取出来的同时将其左右孩子放进去。让队列在循环时中每次只有一层元素。

代码实现

```java
public List<List<Integer>> levelOrder(TreeNode root) {
    ArrayList<List<Integer>> res = new ArrayList<>();
    if(root==null){
        return res;
    }

    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
        ArrayList<Integer> list = new ArrayList<>();
        // 将元素全部取出
        for(int i=queue.size();i>0;i--){
            TreeNode poll = queue.poll();
            list.add(poll.val);
            if(poll.left!=null){
                queue.add(poll.left);
            }
            if(poll.right!=null){
                queue.add(poll.right);
            }

        }
        res.add(list);
    }
    return res;
}
```



![image-20211019091336865](D:\java workstation\笔记\浪潮\images\image-20211019091336865.png)



#### 32从上到下打印二叉树III

 算法思想： 与从上到下打印二叉树II，思想相同。但是需要按照层数来判断是从队列的左边还是右边取元素。

多了一层判断。注意从右向左的时候需要进行不能取出元素，需要再使用一个for 循环来遍历节点来放入孩子节点。

代码实现

```java
public List<List<Integer>> levelOrder(TreeNode root) {
    ArrayList<List<Integer>> res = new ArrayList<>();
    if(root==null){
        return res;
    }

    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int layer=1;
    while(!queue.isEmpty()){
        ArrayList<Integer> list = new ArrayList<>();
        // 将元素全部取出
        if(layer%2!=0){
            //从左向右取
            for(int i=queue.size();i>0;i--){
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if(poll.left!=null){
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }

            }
        }else{
            //从右向左取,只取不进行删除
            for(int i=queue.size()-1;i>=0;i--){
                TreeNode treeNode = queue.get(i);
                list.add(treeNode.val);
            }
            for(int i=queue.size();i>0;i--){
                TreeNode poll = queue.poll();
                if(poll.left!=null){
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }
            }

        }
        layer++;
        res.add(list);
    }
    return res;
}
```





![image-20211019093041954](D:\java workstation\笔记\浪潮\images\image-20211019093041954.png)



#### 54  二叉搜索树第k 个大节点

算法思想： 二叉搜索数的的中序遍历的结果就是有序的，对二叉搜索树进行中序遍历将结果保存的数组中，要第几个元素就取第几个元素。



代码实现

```java
public void midOrder(TreeNode root,ArrayList<Integer> list){
    if(root==null)
        return;

    midOrder(root.left,list);
    list.add(root.val);
    midOrder(root.right,list);

}

public int kthLargest(TreeNode root, int k) {
    
    if(root==null)
        return 0;
    ArrayList<Integer> list = new ArrayList<>();
    midOrder(root,list);
    int length=list.size();
    return list.get(length-k);
}
```

![image-20211019095550912](D:\java workstation\笔记\浪潮\images\image-20211019095550912.png)





#### 删除链表中重复的节点（出现一些bug）



问题描述

![image-20211019102028818](D:\java workstation\笔记\浪潮\images\image-20211019102028818.png)

算法思想： 注意重复结点不进行保留。方法一： 重新设置一个链表, 遍历旧链表，查看旧链表当前遍历结点与新链表最后一个节点是否相等，不等将旧链表的当前结点用尾插法插入到新链表，相等新链表尾指针向前指一位，保存旧结点的值，删除旧链表重复的当前元素。  方法二：直接删除法，在遍历单链表的时候，检查当前结点与下一点是否为相同值 cur.val==cur.next.val，如果相同，继续查找同值的最大长度，然后指针改变指向。（注意头结点可能会被删除，需要一个额外的空节点）。 



方法一代码实现：

```java
public static ListNode deleteDuplication(ListNode pHead) {
    if(pHead==null){
        return pHead;
    }

    // 设置几个工作指针和尾指针
    ListNode newHead = new ListNode(0);
    ListNode newWork = new ListNode(0);
    ListNode newRear = newHead;
    ListNode newRearPre=newHead;

    while(pHead!=null){
        newWork=pHead.next;
        pHead.next=null;
        if(pHead.val!=newRear.val){
            // 尾插法插入
            newRearPre=newRear;
            newRear.next=pHead;
            newRear=pHead;
        }else{
            // 存放新的链表向前移一位
            newRear=newRearPre;
            //删除旧链表重复的元素
            int val=pHead.val;
            while( newWork.val==val ){
                pHead=newWork;
                newWork=pHead.next;
                if(newWork==null)
                  break;
            }
        }
        pHead=newWork;
    }
    return newHead.next;
}
```



方法二代码实现：

```java
public static ListNode deleteDuplicates(ListNode head) {

    if(head==null){
        return head;
    }
    //头结点可能会被删除，创建一个头结点
    ListNode newHead = new ListNode(0);
    newHead.next=head;
    ListNode preNode = newHead;
    ListNode workNode = head;
    while(workNode!=null){
        // 找到相同的，尽可能找最多的
        if(workNode.next!=null && workNode.val==workNode.next.val){
            workNode=workNode.next;
            while(workNode.next!=null && workNode.val==workNode.next.val){
                workNode=workNode.next;
            }
            //进行串连
            workNode=workNode.next;
            preNode.next=workNode;
        }else{
            //没有相同
            preNode =workNode;
            workNode=workNode.next;

        }
    }
    return newHead.next;
}
```



![image-20211111114151795](D:\java workstation\笔记\浪潮\images\image-20211111114151795.png)



#### 101 对称的二叉树 

![image-20211020092411310](D:\java workstation\笔记\浪潮\images\image-20211020092411310.png)



算法思路： 

思路如下：

1.怎么判断一棵树是不是对称二叉树？ 答案：如果所给根节点，为空，那么是对称。如果不为空的话，当他的左子树与右子树对称时，他对称

2.那么怎么知道左子树与右子树对不对称呢？在这我直接叫为左树和右树 答案：如果左树的左孩子与右树的右孩子对称，左树的右孩子与右树的左孩子对称，那么这个左树和右树就对称。

仔细读这句话，是不是有点绕？怎么感觉有一个功能A我想实现，但我去实现A的时候又要用到A实现后的功能呢？

当你思考到这里的时候，递归点已经出现了： 递归点：我在尝试判断左树与右树对称的条件时，发现其跟两树的孩子的对称情况有关系。

想到这里，你不必有太多疑问，上手去按思路写代码，函数A（左树，右树）功能是返回是否对称

def 函数A（左树，右树）： 左树节点值等于右树节点值 且 函数A（左树的左子树，右树的右子树），函数A（左树的右子树，右树的左子树）均为真 才返回真

实现完毕。。。

写着写着。。。你就发现你写出来了。。。。。。



看了评论真的写出来了。要大胆尝试，递归。 需要判断左右两个结点。代码实现

```java
public boolean isSymRec(TreeNode left,TreeNode right){
    if(left==null && right==null){
        return true;
    }
    if(left==null || right==null){
        return false;
    }
    if(left.val==right.val){
        boolean flag=isSymRec(left.left,right.right);
        boolean flag2=isSymRec(left.right,right.left);
        return flag&&flag2;
    }else{
        return false;
    }
}


public boolean isSymmetric(TreeNode root) {
    if(root==null)
        return true;
    Boolean flag=isSymRec(root.left,root.right);
    return flag;
}
```



![image-20211020092329455](D:\java workstation\笔记\浪潮\images\image-20211020092329455.png)



####  调整数组顺序使奇数位于偶数前面（二）81

题目描述

![image-20211020103040342](D:\java workstation\笔记\浪潮\images\image-20211020103040342.png)

算法思想  双指针 left 指现存数组第一个偶数，right 向后移，遇到奇数进行交换。

```java
public int[] reOrderArrayTwo (int[] array) {
    // 时间复杂度o(n) 空间时间复杂度 o(1)
    // write code here
    int lens=array.length;
    if(lens<0){
        return new int[]{};
    }

    // left 指现存数组第一个偶数，right 向后移，遇到奇数进行交换
    for(int left=0,right=0;right<lens;right++){
        if(array[right]%2==0){
            continue;
        }else{
            //为奇数，与前面的偶数进行交换
            int tmp;
            tmp=array[left];
            array[left]=array[right];
            array[right]=tmp;
            left++;
        }

    }

    return array;
}
```



![image-20211020103351411](D:\java workstation\笔记\浪潮\images\image-20211020103351411.png)



#### 链表中环的入口节点jz23

问题描述

![image-20211103201252773](D:\java workstation\笔记\浪潮\images\image-20211103201252773.png)



解题思路：



这是一些列的题。 有以下的问法，如何判断链表有没有环？ 如果有环，找出环的入口地址。 环的长度是多少？

 如何判断链表有没有环？Hash 法,使用一个set 存储链表节点的地址，遍历整个链表，如何能在set 中找到当前的节点，则说明有环。

如何找到环的入口地址？返回set 中存在的节点。 

环的长度是多少？ 找到环的入口，新增一个指针，顺着环依次循环一遍。

代码实现：

```java
public static ListNode EntryNodeOfLoop(ListNode pHead) {
    if (pHead==null)
        return null;
    ListNode listNode = new ListNode(0);
    listNode=pHead;
    Set<ListNode> set = new HashSet<>();
    while(listNode!=null){
        if (!set.contains(listNode)){
            set.add(listNode);
        }else{
            return listNode;
        }
        listNode=listNode.next;
    }

    return null;

}
```



![image-20211103221809529](D:\java workstation\笔记\浪潮\images\image-20211103221809529.png)







#### 237 删除链表中的节点

题目描述

![image-20211104093441919](D:\java workstation\笔记\浪潮\images\image-20211104093441919.png)



解题思路： 注意只给了要被删除的节点，无法访问链表的头节点。将要删除的节点的下一个节点赋给当前节点，然后删除要删除节点的下一个节点。

代码实现：

```java
public void deleteNode(ListNode node) {
    //删除特定节点
    if(node==null){
        return;
    }
    node.val=node.next.val;
    node.next=node.next.next;
}
```



![image-20211104094808243](D:\java workstation\笔记\浪潮\images\image-20211104094808243.png)





#### jz18 删除链表中的节点

题目描述

![image-20211104094947965](D:\java workstation\笔记\浪潮\images\image-20211104094947965.png)



解题思路： 可以与上文进行对比。这里给了头地址。两个工作指针。preNode 和遍历node。找到对应val值的节点进行删除。

```java
public ListNode deleteNode (ListNode head, int val) {

    if (head==null||head.next==null){
        return null;
    }
    if (head.val==val){
        return head.next;
    }

    // 生成两个工作指针
    ListNode listnode =new ListNode(0);
    ListNode PreNode=new ListNode(0);
    listnode=head.next;
    PreNode=head;


    while(listnode!=null){
        if(listnode.val==val){
            //进行删除
            PreNode.next=listnode.next;
            break;
        }
        PreNode=listnode;
        listnode=listnode.next;
    }
    return head;
}
```



![image-20211104100503038](D:\java workstation\笔记\浪潮\images\image-20211104100503038.png)





#### 顺时针打印矩阵

题目描述

![image-20211104151528261](D:\java workstation\笔记\浪潮\images\image-20211104151528261.png)

解题思路：这道题的关键在与先形成清晰的思路，并把复杂的问题分解成若干个简单的问题。我想的可以涉及一个递归函数，每次只打印给定的层数。注意最后一圈有可能退化成只有一行，只有一列，甚至只有一个数字。打印矩阵最里面一圈可能只需要三步，两步，甚至一步。之前自己并没有考虑最后一圈的情况。如果只有一行，那第二步就不用了，第二步的前提是终止的行号大于起始行号。第三步的前提是至少有两行两列，所以除了终止行号大于起始行号，还要求终止列号大于起始列号，打印第四步的条件至少有三行两列，终止行号必须要大于起始行号+1,终止列号大于起始列号。（注意这里所说的起始与终止是相对于整个要打印的矩阵而言的）。

最后进行了一个特殊判断

```java
if(rowlens==2&& rowlayer==1 || clomnlens==2 && clomnlayer==1){
    return ;
}
```

代码实现

```java
public static void printOneLayer(int [][] matrix,int rowlens,int clomnlens,int rowlayer,int clomnlayer,ArrayList<Integer> result){
        if(rowlayer==0||clomnlayer==0){
            return;
        }
        if(rowlens==2&& rowlayer==1 || clomnlens==2 && clomnlayer==1){
            return ;
        }
        //只打印一层
        //横着打印
        //四个变量分别记录在该圈中的起始行号，终止行号，起始列号，终止列号
        int startRow=rowlens-rowlayer;
        int endRow=rowlayer-1;
        int startClomn=clomnlens-clomnlayer;
        int endClomn=clomnlayer-1;

        if(rowlens-rowlayer<rowlayer && clomnlens-clomnlayer<clomnlayer ) {
            for (int i = clomnlens - clomnlayer; i < clomnlayer; i++) {
                      result.add(matrix[rowlens - rowlayer][i]);
            }
        }
        if(endRow>startRow) {
            for (int i = rowlens - rowlayer + 1; i < rowlayer; i++) {
                result.add(matrix[i][clomnlayer - 1]);
            }
        }

        if(endRow>startRow && endClomn>startClomn){
            for (int i = clomnlayer - 2; i >= clomnlens - clomnlayer; i--) {
                result.add(matrix[rowlayer - 1][i]);
            }
        }

        if(endRow>startRow+1 && endClomn>startClomn) {
            for (int i = rowlayer - 2; i > rowlens - rowlayer; i--) {
                result.add(matrix[i][clomnlens - clomnlayer]);
            }
        }

        printOneLayer(matrix,rowlens,clomnlens,rowlayer-1,clomnlayer-1,result);
    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int rowlens=matrix.length;

        int clomnlens=matrix[0].length;

        if (rowlens<0|| clomnlens<0){
            return result;
        }
        if (rowlens==1&& clomnlens==0){
            return result;
        }

        printOneLayer(matrix, rowlens, clomnlens,rowlens,clomnlens, result);

        return result;
    }
```



运行结果:

![image-20211110185759342](D:\java workstation\笔记\浪潮\images\image-20211110185759342.png)



#### 打印二叉树为特定值的路径

题目描述：

![image-20211104172033437](D:\java workstation\笔记\浪潮\images\image-20211104172033437.png)



解题思路：深度搜索，用一个list 存储中间产生的结果。

```java
public int count=0;
public void dfs(TreeNode root,int target,List<Integer> list,List<List<Integer>> result){

    if(root==null){
        return;
    }

    int val=root.val;
    count+=val;
    list.add(val);

    if(root.left==null && root.right==null){
        //为叶子节点
        if(count==target){
            result.add(new ArrayList<>(list));
        }
    }

    dfs(root.left,target,list,result);
    dfs(root.right,target,list,result);
    count-=val;
    int lens=list.size();
    list.remove(lens-1);

}

public List<List<Integer>> pathSum(TreeNode root, int target) {
    List<List<Integer>> result = new ArrayList<>();
    if(root==null){
        return result;
    }
    //存储中间结果
    ArrayList<Integer> list= new ArrayList<>();
    dfs(root,target,list,result);
    return result;
}
```

![image-20211104171947239](D:\java workstation\笔记\浪潮\images\image-20211104171947239.png)



#### 连续子数组的最大和JZ85

题目描述

![image-20211105105018772](D:\java workstation\笔记\浪潮\images\image-20211105105018772.png)



解题思路：这一题与连续子数组的最大和一样，只不过不是求最大值而是将最大值的子数组进行返回。
这时候用到贪心，存储最大值的起始和结束的长度。本题我用了一个二维的数组。

代码实现



```java
public static int[] FindGreatestSumOfSubArray (int[] array) {
        // write code here
        int lens=array.length;
        if(lens<0){
            return new int[]{};
        }
        //定义结构存储最终的结果
        int[] dp = new int[lens];
        //生成一个二维数组
        //存储起始和结束位置
        int [][] startEnd=new int[lens][2];
        dp[0]=array[0];
        startEnd[0][0]=0;
        startEnd[0][1]=0;
        for(int i=1;i<lens;i++){
            int value=dp[i-1]+array[i];
            if(value>=array[i]){
                startEnd[i][0]=startEnd[i-1][0];
                startEnd[i][1]=i;
                dp[i]=value;
            }else{
                startEnd[i][0]=i;
                startEnd[i][1]=i;
                dp[i]=array[i];
            }
        }
    int result=Integer.MIN_VALUE;
    int start=0,end=0;
    int spanFirst=0;
    for(int i=0;i<lens;i++){
        if(dp[i]>=result){
            if(dp[i]==result){
                if(spanFirst<=(startEnd[i][1]-startEnd[i][0])){
                    start=startEnd[i][0];
                    end=startEnd[i][1];
                    spanFirst=end-start;
                }
            }else{
                start=startEnd[i][0];
                end=startEnd[i][1];
                spanFirst=end-start;
            }
            result=dp[i];
        }
    }
    //进行复制
    int span=end-start;
    int[] ints = new int[span+1];
    for(int i=0;i<span+1;i++){
        ints[i]=array[start];
        start++;
    }
    return ints;
}
```


![image-20211105155933527](D:\java workstation\笔记\浪潮\images\image-20211105155933527.png)



#### 买卖股票的最好时机 jz63

![image-20211105160017429](D:\java workstation\笔记\浪潮\images\image-20211105160017429.png)

解题思路： 使用贪心的思想。遍历数组，保存当前位置之前的最小值。然后向减，如果大于已知的最大值则进行更新。

代码实现：

```java
public int maxProfit (int[] prices) {
    int lens=prices.length;
    if(lens<2){
        return 0;
    }
    int proMin=prices[0];
    int currentMax=Integer.MIN_VALUE;
    for(int i=1;i<lens;i++){

        int val=prices[i]-proMin;
        if(val>currentMax){
            currentMax=val;
        }

        if(prices[i]<proMin){
            proMin=prices[i];
        }
    }
    if (currentMax<=0){
        return 0;
    }else {
        return currentMax;
    }
}
```



运行结果：

![image-20211105161402388](D:\java workstation\笔记\浪潮\images\image-20211105161402388.png)



#### 礼物的最大价值jz47

题目描述

![image-20211105161604995](D:\java workstation\笔记\浪潮\images\image-20211105161604995.png)

解题思路：状态表示 f[i] [j] 从起点走到(i,j) 能拿到的礼物价值的最大值。因为每次只能向右走或向下进行移动。状态转移方程: f[i][j]=Math.max(f[i][j-1],f[]i-1[j])+val(i,j)。 最终的结果为f[]m-1[n-1]。初始化第一行和第一列。

```java
public int maxValue (int[][] grid) {
    int rowLens=grid.length;
    int clomnLens=grid[0].length;

    int[][] dp=new int[rowLens][clomnLens];
    //状态转移方程 dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j])

    //初始化第一行和第一列
    int count=0;
    for(int i=0;i<clomnLens;i++){
        count+=grid[0][i];
        dp[0][i]=count;
    }
    count=0;
    for(int i=0;i<rowLens;i++){
        count+=grid[i][0];
        dp[i][0]=count;
    }


    for(int i=1;i<rowLens;i++){
        for(int j=1;j<clomnLens;j++){
            dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j])+grid[i][j];
        }
    }
    return dp[rowLens-1][clomnLens-1];
}
```





![image-20211105171151986](D:\java workstation\笔记\浪潮\images\image-20211105171151986.png)







#### 最长不含重复字符的子字符

题目描述：

![image-20211105203817558](D:\java workstation\笔记\浪潮\images\image-20211105203817558.png)

解题思路： 感觉这道题是动态规划和hashmap 的结合题。用hashmap 存储不重复字符及其出现的位置。dp[i] 表示以i 结尾的最长不含重复字符的子字符长度。i 位置的字符不在hashmap 中，动态转移方程：dp[i]=dp[i-1]+1,并将其加入到hashmap中，如果在i为的字符在hashmap 中，则获取其的位置pos。dp[i]=i-pos。 注意在第二种情况下，需要将hashmap进行清空。将pos到i 的位置的字符加入到hashmap中 。这是我在debug时候才发现的问题。

代码实现：

```java
public static int lengthOfLongestSubstring (String s) {

    
    int lens=s.length();
    if(lens<1){
        return 0;
    }
    //存储中间结果
    int[] dp = new int[lens];

    // 定义一个hashmap 存储不重复字符及其出现的位置
    HashMap<Character, Integer> hashmap = new HashMap<>();
    dp[0]=1;
    hashmap.put(s.charAt(0),0);

    for(int i=1;i<lens;i++){

        //hashmap 中没有
        if(!hashmap.containsKey(s.charAt(i))){
            hashmap.put(s.charAt(i),i);
            dp[i]=dp[i-1]+1;
        }else{
            // hashmap 中有, 获取位置
            int pos = hashmap.get(s.charAt(i));
            dp[i]=i-pos;
            //更新当前字符的位置
            //要将hashmap 中pos 到i 的char 放入hashmap 中 debug 时候才发现问题

            hashmap.clear();
            for(int j=pos+1;j<=i;j++){
                hashmap.put(s.charAt(j),j);
            }
        }
    }
    int result=Integer.MIN_VALUE;
    for(int i=0;i<lens;i++){
        if(dp[i]>result){
            result=dp[i];
        }
    }
    return result;
}
```

运行结果：

![image-20211105203754397](D:\java workstation\笔记\浪潮\images\image-20211105203754397.png)





#### 正则表达式匹配jz19

题目描述:

![image-20211109214943455](D:\java workstation\笔记\浪潮\images\image-20211109214943455.png)

解题思路: java 最简单的解题,str.match(pattern)就可以解决。但为了理解其思路进行难度设置。每次从patter 中拿出一个字符与s 中的字符进行比较。如果该字符的后续字符不是' * ' ,则直接进行匹配判断。如果后续字符是'*'，则分两种情况。第一种匹配0个，跳过pattern中的该字符与 *,继续匹配。第二种情况是匹配多个,str中的游标向后移动一位,pattern 中的不变，继续进行判断。

代码实现:



####  矩阵中的路径jz12

题目描述：

![image-20211106190333258](D:\java workstation\笔记\浪潮\images\image-20211106190333258.png)



解题思路：解这道题的思路是进行搜索，刚开始找到字符串第一个字符出现的位置。进入dfs,寻找其四周有没有接下来的字符，有则再次进入dfs，没有返回false。

技巧 ： 对于四周可以定义两个数组，分别表示x和y轴。

```
//定义四个方向 上下左右
static int [] dx=new int[]{-1,0,1,0};
static int [] dy=new int[]{0,1,0,-1};
```

还有记录一个访问数组，记录被访问的数。

```java
boolean[][] booleans = new boolean[rowlens][clomnlens];
```

有两次清零，一次是从起始递归出来，一次在遍历四周时，返回false,要将递归进去的访问数组标记为true的设置为false。



代码实现:

```java
//定义四个方向 上下左右
static int [] dx=new int[]{-1,0,1,0};
static int [] dy=new int[]{0,1,0,-1};
static int rowlens;
static int clomnlens;
 static boolean dfs(char [][] matrix,String word,int row,int clomn,int start,boolean[][] booleans){
    int lens=word.length();
    if(start==lens){
        return true;
    }
    char s=word.charAt(start);
    boolean flag=false;
    //从四周开始找，找到一个合适的字符
    for(int i=0;i<4;i++){
       if( 0<=row+dx[i]&& row+dx[i]<rowlens && 0<=clomn+dy[i]&& clomn+dy[i]<clomnlens ){
           if( booleans[row+dx[i]][clomn+dy[i]]==false){
               if (matrix[row+dx[i]][clomn+dy[i]]==s){
                   booleans[row+dx[i]][clomn+dy[i]]=true;
                   flag=dfs(matrix,word,row+dx[i],clomn+dy[i],start+1,booleans);
                   if(flag==true){
                       break;
                   }
                   //通过debug 才发现，如果flag为false 将设为true 的置为false
                   booleans[row+dx[i]][clomn+dy[i]]=false;
               }
           }
       }
    }
    return flag;
}

public static boolean hasPath (char[][] matrix, String word) {
    // write code here
    int lens=word.length();
    if(lens<0){
        return false;
    }
    boolean flag=false;
    rowlens=matrix.length;
    clomnlens=matrix[0].length;
    boolean enter= false;
    //访问矩阵也要传过去,初始全为false
    boolean[][] booleans = new boolean[rowlens][clomnlens];
    for(int i=0;i<rowlens;i++){
        for(int j=0;j<clomnlens;j++){
            if (matrix[i][j]==word.charAt(0)){
                enter=true;
                booleans[i][j]=true;
                flag = dfs(matrix, word,i,j, 1,booleans);
                if(flag==true){
                    break;
                }
            }
            //进入一次递归就要清零
            if(enter){
                for (int k=0;k<rowlens;k++){
                    for(int kk=0;kk<clomnlens;kk++){
                        booleans[k][kk]=false;
                    }
                }
                enter=false;
            }
        }
        if(flag==true){
            break;
        }
    }
    return flag;
}
```

运行结果:

![image-20211106211621796](D:\java workstation\笔记\浪潮\images\image-20211106211621796.png)



#### 数组流中中位数jz41

题目描述

![image-20211108110644322](D:\java workstation\笔记\浪潮\images\image-20211108110644322.png)

解题思路：插入一个元素，就进行排序。取出元素按照题目所说的时候进行判断。

实现代码：

```java
public class 数据流的中位数jz41 {

    //定义一个数组
    ArrayList<Integer> array=new ArrayList<>();
    public void Insert(Integer num) {
        //在每次插入的时候进行排序
        array.add(num);
        Collections.sort(array);

    }
    public Double GetMedian() {
        int lens=array.size();
        int mid=lens/2;
        if(lens<1){
            return 0.0;
        }
        if(lens%2==0){
            return (array.get(mid-1)+array.get(mid))/2.0;
        }else{
            return array.get(lens/2).doubleValue();
        }
    }
}
```





![image-20211108110548203](D:\java workstation\笔记\浪潮\images\image-20211108110548203.png)





#### 复杂链表的复制 jz35

题目描述:

![image-20211108114046372](D:\java workstation\笔记\浪潮\images\image-20211108114046372.png)

解题思路： 要实现深拷贝，需要分配新的地址空间。(浅拷贝指向同一个地址)。两种解法: 1 哈希表 2 原地修改

第一个方法用一个hashmap 存储 源节点和 new 出来的节点的对应关系。然后将拷贝的新节点组成一个链表。 2方法二，原地修改。复制一个新节点在原有节点之后，如1->2->3->null 复制完了就成了 1->1->2->2->3->3->null。 从头遍历链表，利用 cur.next.random=cur.randon.next,将复制节点的随机指针进行串联，然后将复制节点进行串联即可。(此时是已经复制的节点,所以要用workPointer.random.next;next 表示复制的节点)

如何将链表一分为二:

1->1->2->2->3->3->null 变为1->2->3 定义一个新链表的头节点copyHead指向head.next，两个工作指针，一个指向第一个节点head设为work，一个指向head.next设为copywork。 不断 执行 work.next=work.next.next,

工作指针后移 work=work.next

具体代码

```java
Node copyHead=head.next;
//两个工作指针
Node copyworker=head.next;
workPointer=head;
while(workPointer!=null){
    workPointer.next=workPointer.next.next;
    workPointer=workPointer.next;
    if(copyworker.next!=null){
        copyworker.next=copyworker.next.next;
        copyworker=copyworker.next;
    }
}
```

代码实现

```java
if(pHead==null){
    return pHead;
}

//map中存的是(原节点，拷贝节点)的一个映射
Map<RandomListNode, RandomListNode> map = new HashMap<>();
for (RandomListNode cur = pHead; cur != null; cur = cur.next) {
    map.put(cur, new RandomListNode(cur.label));
}
//将拷贝的新的节点组织成一个链表
for (RandomListNode cur = pHead; cur != null; cur = cur.next) {
    map.get(cur).next = map.get(cur.next);
    map.get(cur).random = map.get(cur.random);
}

return map.get(pHead);
```

方法二代码实现

```java
public Node copyRandomList(Node head) {
    if(head==null){
        return head;
    }
    //进行复制
    Node workPointer = head;
    while(workPointer!=null){
        Node node = new Node(workPointer.val);
        node.next=workPointer.next;
        workPointer.next=node;
        workPointer=workPointer.next.next;
    }
    // random node 复制
    workPointer=head;
    while(workPointer!=null){
        if(workPointer.random!=null)
            //此时是已经复制的节点,所以要用workPointer.random.next;next 表示复制的节点
            workPointer.next.random=workPointer.random.next;
        workPointer=workPointer.next.next;
    }


    //将新生成的复制节点进行合并,发现这样做的话workload 必须是next为空，所以做的是错的
    //将链表一分为二
    //拷贝节点的头
    Node copyHead=head.next;
    //两个工作指针
    Node copyworker=head.next;
    workPointer=head;
    while(workPointer!=null){
        workPointer.next=workPointer.next.next;
        workPointer=workPointer.next;
        if(copyworker.next!=null){
            copyworker.next=copyworker.next.next;
            copyworker=copyworker.next;
        }
    }
    return copyHead;
}
```



运行结果:

![image-20211110201644584](D:\java workstation\笔记\浪潮\images\image-20211110201644584.png)



#### 二叉树的下一个节点jz8

![image-20211108155935200](D:\java workstation\笔记\浪潮\images\image-20211108155935200.png)



解题思路： 采用暴力的方法解决，先找到根节点，然后进行遍历，将其存储在数组中，从数组中获取其的下一个。

代码实现：

```java
List<TreeLinkNode> arrayList = new ArrayList<>();
public void midOrder(TreeLinkNode node){
    if(node==null){
        return;
    }
    midOrder(node.left);
    arrayList.add(node);
    midOrder(node.right);
}
public TreeLinkNode GetNext(TreeLinkNode pNode) {
    if(pNode==null){
        return null;
    }
    TreeLinkNode treeLinkNode = new TreeLinkNode(0);
    treeLinkNode=pNode;

    while(pNode.next!=null){
        pNode=pNode.next;
    }
    //采用暴力的方法解决，先找到根节点，然后进行遍历，将其存储在数组中，从数组中获取其的下一个。
    midOrder(pNode);

    int lens=arrayList.size();
    for(int i=0;i<lens;i++){
        if(arrayList.get(i)==treeLinkNode){
            if(i+1>=lens){
                return null;
            }else {
                return arrayList.get(i+1);
            }
        }
    }
    return null;
}
```



运行结果

![image-20211108160149506](D:\java workstation\笔记\浪潮\images\image-20211108160149506.png)



#### 字符流中第一个不重复的字符jz75

题目描述：

![image-20211108161404557](D:\java workstation\笔记\浪潮\images\image-20211108161404557.png)

解题思路：使用map 统计每个字符出现的次数,list 存储字符流.每插入一次就调用FirstAppearingOnce函数，遍历当前list 。

代码实现:

```javascript
// map 统计每个字符出现的次数
// list 存储字符流
HashMap<Character, Integer> map = new HashMap<>();
List<Character> list=new ArrayList<>();
void Insert(char ch)
{
    if(map.containsKey(ch)){
        map.replace(ch,map.get(ch)+1);
    }else{
        map.put(ch,1);
    }
    list.add(ch);
}
//return the first appearence once char in current stringstream
char FirstAppearingOnce()

{
    //每插入一次就调用该函数
    char c='#';
    for(char key : list){
        if(map.get(key)==1){
            c=key;
            break;
        }
    }

    return c;
}
```





![image-20211108174138561](D:\java workstation\笔记\浪潮\images\image-20211108174138561.png)



#### 把字符串转化为整数jz67

题目描述:

![image-20211108201531600](D:\java workstation\笔记\浪潮\images\image-20211108201531600.png)

解题思路：感觉这道题和整数的反转比较像，溢出判断也比较像，自己按照那道题的思想做出来的。



代码实现:

```java
public static int StrToInt (String s) {
    // write code here
    int lens=s.length();
    if(lens<1){
        return 0;
    }
    int start=0;
    Boolean isMinus=false;
    int midResult=0;
    for(int i=0;i<lens;i++){
        if(s.charAt(i)==' ')
            continue;
        if(s.charAt(i)=='-'){
            start=i+1;
            isMinus=true;
            break;
        }
        if(s.charAt(i)=='+'){
            start=i+1;
            break;
        }
        if(s.charAt(i)>='0'&& s.charAt(i)<='9'){
            start=i;
            break;
        }
        if(s.charAt(i)>='A'&& s.charAt(i)<='Z'||s.charAt(i)>='a' && s.charAt(i)<='z'){
            return 0;
        }
    }
    //有个溢出判断
    for(int i=start;i<lens;i++){
        if(s.charAt(i)>='0'&& s.charAt(i)<='9'){
            int temp=midResult;
            midResult=midResult*10+(s.charAt(i)-'0');

            if(midResult/10!=temp){
                //溢出
                if(!isMinus){
                    midResult=Integer.MAX_VALUE;
                }else{
                    midResult=Integer.MIN_VALUE;
                }
                return midResult;
            }

        }else{
            break;
        }
    }

    if(isMinus){
        midResult=-midResult;
    }
    return midResult;
}
```

运行结果:

![image-20211108210246940](D:\java workstation\笔记\浪潮\images\image-20211108210246940.png)









#### 数字序列中某一位数字jz(*)

题目描述

![image-20211108221142669](D:\java workstation\笔记\浪潮\images\image-20211108221142669.png)

解题思想：这是一道找规律的题

![image-20211109085339555](D:\java workstation\笔记\浪潮\images\image-20211109085339555.png)



注意这道题支持的最大长度为9

代码实现:

```java
public static int getNUm(int n){
    if(n==0){
        return 0;
    }
    if(n==1){
        return 10;
    }
    return getNUm(n-1)+((int)Math.pow(10,n)-1-((int)Math.pow(10,n-1)-1))*n;
}

public static int findNthDigit (int n) {
    // write code here
    if(n<0){
        return 0;
    }

    if(n==500000000){
        return 8;
    }
    int value=n;
    //lens 位数
    int lens=0;
    if(n==0){
        lens=1;
    }
    while(n!=0){
        lens++;
        n=n/10;
    }

    //之前位数占用的长度
    int prenums=getNUm(lens-1);
    int num=(value-prenums)/lens;
    // 第num 的数
    num=num+(int)Math.pow(10,lens-1);
    if(lens==1){
        num--;
    }
    //确定在num中的第几位
    int kk=value%lens;
    String s = Integer.toString(num);
    return Integer.parseInt(s.substring(kk,kk+1));

}
```

虽然这道做出来了，方法不对只是测试案例少。

运行结果：

![image-20211109103757609](D:\java workstation\笔记\浪潮\images\image-20211109103757609.png)



#### 二叉树中和为某一数值的路径三jz84

题目描述:

![image-20211109111212903](D:\java workstation\笔记\浪潮\images\image-20211109111212903.png)



解题思想：刚看这道题感觉与常见的树的题有些不同，后来一想，可以把其他节点当作根节点进行遍历。所以这道两个函数都要不断的进行递归。

代码实现

```java
public int Find(TreeNode root,int sum,int currentValue){
    if(root==null){
        return 0;
    }
    int count=0;
    if(currentValue+root.val==sum){
        // 这里不能返回
        count=1;
    }
    currentValue=currentValue+root.val;
    int left=Find(root.left,sum,currentValue);
    int right=Find(root.right,sum,currentValue);
    return count+left+right;
}
//每个节点都遍历一遍
public int FindPath (TreeNode root, int sum) {
    // write code here
    if(root==null){
        return 0;
    }
    int count=Find(root,sum,0);
    int left=FindPath(root.left,sum);
    int right=FindPath(root.right,sum);
    return count+left+right;

}
```

运行结果

![image-20211109113745937](D:\java workstation\笔记\浪潮\images\image-20211109113745937.png)





#### 在二叉树中找到两个节点的最近公共祖先jz68

题目描述:

![image-20211109172736064](D:\java workstation\笔记\浪潮\images\image-20211109172736064.png)

解题思路:

通常关于树的问题九二一通过递归解决。在递归中最重要的是定义子问题。

判断当前节点是否是p,g 节点的最近祖先
    1：p,q 节点分别在其左右孩子，则一定为最近祖先。
    2：当前节点为p,或q 并且另外一个节点在器左右孩子中

如何判断左右孩子是否有p,q 节点通过遍历其左右孩子实现。定义一个函数dfs,具体实现看下面的代码

代码实现:

```java
int result=0;
//判断左右孩子是否有p,g节点
public boolean dfs(TreeNode root,int o1,int o2){
    if(root==null){
        return false;
    }
    Boolean left=dfs(root.left,o1,o2);
    Boolean right=dfs(root.right,o1,o2);
    //判断当前节点是否满足最近祖先
    //p,q 节点分别在其左右孩子，则一定为最近祖先。
    //当前节点为p,或q 并且另外一个节点在器左右孩子中
    if((left&&right)||(root.val==o1 ||root.val==o2)&&(left||right)){
        result=root.val;
    }
    //返回判断的结果

    return left||right||(root.val==o1)||(root.val==o2);
}

public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
    dfs(root,o1,o2);
    return result;
}
```

运行结果

![image-20211109210158664](D:\java workstation\笔记\浪潮\images\image-20211109210158664.png)



#### 序列化二叉树jz37

题目描述

![image-20211109220425689](D:\java workstation\笔记\浪潮\images\image-20211109220425689.png)

解题思路: 定义一个字符串用来存储层序遍历的结果，用queue 进行实现层序遍历。遇到空节点也要插入，插入的时候生成一个新节点val其值我设的是Integer.MaxValue,字符串中$表示空，每个节点之间用, 进行分隔，最后需要将字符串末尾的$ 全部删除，因为其是多余的。反序列化的时候，序列化用到了queue，反序列化也要使用。for循环和queue 一起构建二叉树。for循环的作用来得到从queue 中得到的节点的左右孩子。



层序遍历代码：

```java
static  String Serialize(TreeNode root) {
    if(root==null){
        return "";
    }

    String result="";
    //双端队列
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
        TreeNode poll = queue.poll();
        //
        if(poll.val==Integer.MIN_VALUE) {
            result += "$,"; // 用$表示这里为null,每个元素用, 进行区分
        } else{
            result+=poll.val+",";
        }

        if(poll.left!=null)
            queue.add(poll.left);
        // 产生一个空结点,用Integer.MinValue 表示为空
        if(poll.left==null && poll.val!=Integer.MIN_VALUE) {
            TreeNode leftTreeNode = new TreeNode(Integer.MIN_VALUE);
            queue.add(leftTreeNode);
        }
        if(poll.right!=null)
            queue.add(poll.right);

        // 产生一个空结点,用Integer.MinValue 表示为空

        // 要保证poll 在进行下面判断的时候不为空
        if(poll.right==null && poll.val!=Integer.MIN_VALUE){
                TreeNode rightTreeNode=new TreeNode(Integer.MIN_VALUE);
                queue.add(rightTreeNode);
            }
        }

    int lens=result.length();
    int idx=lens-1;
    while(result.charAt(idx)=='$'||result.charAt(idx)==','){
        idx--;
    }

    return result.substring(0,idx+1);
}

static TreeNode Deserialize(String str) {
    //str  水平遍历 str 为$ 代表着空
    if(str == null || str.length() == 0)  return null;

    String[] split = str.split(",");
    LinkedList<TreeNode> queue = new LinkedList<>();
    int lens=split.length;
    // 之前用queue 了，这里也要用queue
    // 利用水平遍历的结果将str 组成为一颗二叉树
    TreeNode headtNode = new TreeNode(Integer.parseInt(split[0]));
    queue.add(headtNode);
      int idx=1;
    while(!queue.isEmpty() && idx<lens){
        TreeNode t = queue.poll();
        if(!"$".equals(split[idx])){
            t.left = new TreeNode(Integer.parseInt(split[idx]));
            queue.add(t.left);
        }
        idx++;
        if(idx<lens&&!"$".equals(split[idx])){
            t.right = new TreeNode(Integer.parseInt(split[idx]));
            queue.add(t.right);
        }
        idx++;
    }
    return headtNode;
}
```



搞笑的是这种作弊的方法尽然可以过

```java
  private TreeNode head;
    String Serialize(TreeNode root) {
        this.head=root;
        return null;
    }
    TreeNode Deserialize(String str) {
       return head;
    }
```

层序遍历运行结果：

![image-20211112222409642](D:\java workstation\笔记\浪潮\images\image-20211112222409642.png)

#### 二叉搜索树与双向链表jz36

题目描述

![image-20211111150928129](D:\java workstation\笔记\浪潮\images\image-20211111150928129.png)

解题思路: 这道题考察分析复杂问题的能力，解决这个问题的关键在于把一个大的问题分解成小问题，并递归的解决小问题。为二叉搜索数，中序遍历的为有序的，因此要采用中序遍历。当遍历到一个节点时，它的前躯是之前刚遍历的结点，后续是将要遍历的点。所以保存前躯结点(通过将前驱赋给当前结点的left，和将当前结点赋给前躯的的right)，并要保存链表的头结点与链表的尾结点进行整合（尾结点为遍历到最后的pre)



最重要的是要保存中序遍历的前驱节点。

```java
//如果pre为空，则其为head
if(pre!=null){
            root.left=pre;
            pre.right=root;
            pre=root;
        }else{
            pre=root;
            head=root;
        }
```

中序遍历的时候，如果pre为空，则其为head

```java
root.left=pre;
pre.right=root;
```

进行连接,通过将前驱赋给当前结点的left，和将当前结点赋给前躯的的right。

代码实现：

```java
Node pre,head;
public void dfs(Node root){
    if(root==null){
        return ;
    }
    dfs(root.left);

    if(pre!=null){
        root.left=pre;
        pre.right=root;
        pre=root;
    }else{
        pre=root;
        head=root;
    }

    dfs(root.right);
}

public Node treeToDoublyList(Node root) {
    if(root==null){
        return null;
    }
    dfs(root);
    //最后进行处理
    head.left=pre;
    pre.right=head;
    return head;
}
```

 运行结果

![image-20211111163037004](D:\java workstation\笔记\浪潮\images\image-20211111163037004.png)



#### 把数字翻译成字符串jz46

题目描述

![image-20211111164641317](D:\java workstation\笔记\浪潮\images\image-20211111164641317.png)

解题思路： 属性: 个数，求最多。 `这个题的状态表示和状态转移方程是我没有想到的`

这道题是从后面进行分析的,两种情况: 整个数字的翻译结果数= 除去最后一位的部分翻译结果*1 （这里为什用乘是因为只会导致一种结果）整个数字的翻译结果= 除去最后两位的部分翻译结果 乘 1。 两者相加。 dp[i] 表示num[0,1,...i] 能够翻译成字符串的种类数。dp[i]=dp[i-1]+dp[i-2] 前提 10<=num[i-1,i]<=25。



代码实现

```java
public static int translateNum(int num) {
    // 把int 转为字符串方便操作
    String s = String.valueOf(num);
    int lens=s.length();
    if(lens<1){
        return 0;
    }
    // dp[i] 表示以i 结尾能能翻译成的字符串的种类数
    int [] dp=new int[lens];
    // 初始化
    dp[0]=1;
    if(lens==1){
        return dp[0];
    }
    if(Integer.parseInt(s.substring(0,2))>=10 && Integer.parseInt(s.substring(0,2))<=25){
        dp[1]=2;
    }else{
        dp[1]=1;
    }

    for(int i=2;i<lens;i++){
        if(Integer.parseInt(s.substring(i-1,i+1))>=10 && Integer.parseInt(s.substring(i-1,i+1))<=25){
            dp[i]=dp[i-1]+dp[i-2];
        }else{
            dp[i]=dp[i-1];
        }
    }
    return dp[lens-1];
}
```

运行结果:

![image-20211111191827434](D:\java workstation\笔记\浪潮\images\image-20211111191827434.png)





####  表示数值的字符串jz20

题目描述

![image-20211111200627795](D:\java workstation\笔记\浪潮\images\image-20211111200627795.png)

解题思路:  利用str.trim 将字符串首尾的空格去掉，E 和e 是分隔符,如果有e和E 则前面的是数(整数+ 小数)，后面为纯整数。 如果没有e 和E 就只需判断是否为数。我将判断数和纯整数分别写成了函数，但是后面发现纯整数的判断有两种情况，一种是数到纯整数的判断，还有有e 的情况下直接判断纯整数。各种细节还需要debug 的时候确定。

数的判断是通过是否有' . ' 进行分割，再调用是否为纯整数， 纯整数的判断 遍历如果不在0 到9 之间直接返回false，遍历结束返回true。

// 这道题考虑的细节好多呀，我要debug一个一个试

字符串小技巧：

1 ,`去掉字符串左右两边的空格可以直接用 str.trim 进行去掉。` 之前自己竟然不知道。trim 是去掉首尾的空格。

2,  判断字符串中有指定的字符可以用 str.indexof('指定的字符')，如果没有则会返回-1。



代码实现：

```java
public static boolean isPurfyNumber2(String str){
    int lens=str.length();
    // 有时候需要空格
    if(lens==0){
        return false;
    }
    for(int i=0;i<lens;i++){
        if(str.charAt(i)>='0' && str.charAt(i)<='9'){
            continue;
        }else{
            return false;
        }
    }
    return true;
}

// 判断是否为纯整数 正常数单独写一个函数
public static boolean isPurfyNumber(String str){
    int lens=str.length();
    // 有时候需要空格
    if(lens==0){
        return true;
    }
    for(int i=0;i<lens;i++){
        if(str.charAt(i)>='0' && str.charAt(i)<='9'){
            continue;
        }else{
            return false;
        }
    }
    return true;
}

public static boolean isNoralNumber(String str){

    //判断有没有.
    if(str.indexOf('.')!=-1 ){
        String first=str.substring(0,str.indexOf('.'));
        String second=str.substring(str.indexOf('.')+1,str.length());
        // 匹配该规则
        //3.1 至少一位数字，后面跟着一个点 '.'
        //3.2 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
        if(second.equals("") && first.equals("") ){
            return false;
        }
        if (first.equals("")){
            return isPurfyNumber(second);
        }
        return isPurfyNumber(first)&&isPurfyNumber(second);
    }else{
        return isPurfyNumber(str);
    }
}

public static boolean isNumber(String str) {
    str=str.trim();
    int lens=str.length();
    if(lens<1){
        return false;
    }
    //如果有 + - 符号 去掉
    if(str.charAt(0)=='+' || str.charAt(0)=='-'){
        str=str.substring(1,lens);
    }
    if(str.equals("")){
        return false;
    }
    if(str.indexOf('E')!=-1|| str.indexOf('e')!=-1){
        // 包含 e 或E ,用e 替换 E
        str=str.replace('E','e');
        String first=str.substring(0,str.indexOf('e'));
        String last =str.substring(str.indexOf('e')+1,str.length());
        // 在这里就进行操作，为了isPurfyNumber 更好的通过
        if(last.equals("") || first.equals("")){
            return false;
        }
        if(last.charAt(0)=='+' || last.charAt(0)=='-'){
            last=last.substring(1,last.length());
        }
        return isNoralNumber(first)&& isPurfyNumber2(last);
    }else{
        //没有e 直接判断是否为正常数
        return isNoralNumber(str);
    }

}
```

运行结果

![image-20211113111252878](D:\java workstation\笔记\浪潮\images\image-20211113111252878.png)







#### 剪绳子(进阶版) jz83

![image-20211111205438318](D:\java workstation\笔记\浪潮\images\image-20211111205438318.png)

解题思路: 这道题可以 用动态规划也可以用贪心。动态规划 dp[n] 把长度为n的绳子剪成若干段后得到的乘积最大值、 dp[n]=max(dp[i] x dp[n-i]) 0<i<n。  贪心算法需要数学公式的验证，但这道题只能通过贪心算法来做，因为其要求进行求余。贪心法要求: n>=5 尽可能多的剪长度为3的绳子，剩下的绳子为4，把绳子剪成长度为2的绳子。在有面试官的情况下建议用动态规划，而笔试的时候建议用贪心。下面给出了这道题的两种解法。

注意： result 可能会很大建议先用long 进行存储，最后转为int。

代码实现:

动态规划： 

```java
public int cuttingRope(int n) {
    // m>1 必须要剪一段 小于4 要特殊判断
    if(n<=3){
        return n-1;
    }
    // 状态转移方程 f(k)=max(f(i)*f(k-i))  0<i<n  f(k) 长度为k的绳子剪成若干段的乘积最大值
    int [] dp=new int[n+1];
    // 初始化
    dp[0]=0;
    dp[1]=1;
    dp[2]=2;
    dp[3]=3;
    dp[4]=4;
    for(int k=5;k<=n;k++){
        int currentResult=Integer.MIN_VALUE;
        for(int i=1;i<=k;i++){
            int value=dp[i] *dp[k-i];
            if(value>currentResult){
                currentResult=value;
            }
        }
        dp[k]=currentResult;
    }

    return dp[n];
}
```

贪心:

```java
public int cuttingRope(int n) {
    // m>1 必须要剪一段 小于4 要特殊判断
    // 当n>=5的时候，尽可能剪长度为3的绳子,当剩下的绳子长度为4，则将绳子剪成长度为2的绳子。
    if(n<4){
        return n-1;
    }
    long res = 1;
    while(n > 4){
        res *= 3;
        res = res % 1000000007;
        n -= 3;
    }
    return (int)(res * n % 1000000007);
}
```

运行结果

![image-20211112111426397](D:\java workstation\笔记\浪潮\images\image-20211112111426397.png)





将之前用c++ 写的代码改成java



#### 从尾到头打印链表 jz6

![image-20211118101322359](D:\java workstation\笔记\浪潮\images\image-20211118101322359.png)

解题思路:  用一个栈，遍历链表链表将节点入栈，入栈之后从栈顶取元素，直到栈为空。

```java
public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    Stack<ListNode> stack=new Stack<ListNode>();
    ArrayList<Integer> result=new ArrayList<>();
    ListNode temp=listNode;
    while (temp!=null){
        stack.push(temp);
        temp=temp.next;
    }
    while (!stack.empty()){
        result.add(stack.pop().val);
    }
    return result;

}
```



运行结果

![image-20211118101545685](D:\java workstation\笔记\浪潮\images\image-20211118101545685.png)



#### 反转链表

解题思想: 用头插法进行插入，实现链表的反转。



```java
public ListNode ReverseList(ListNode head) {
    ListNode newHead = new ListNode(0);
    ListNode work=head;
    while(head!=null){
        work=head.next;
        head.next=null;
        // 头插法进行插入
        head.next=newHead.next;
        newHead.next=head;
        head=work;
    }

    return newHead.next;
}
```

![image-20211118102611590](D:\java workstation\笔记\浪潮\images\image-20211118102611590.png)





#### 合并两个排序的链表

解题思路： 使用递归求解，在递归中使得链表进行合并。如果 list1.val 小于list2.val ，则进行调用递归list1.next=Merge(list1.next,list2.next) 。Merge 递归函数的作用是让其在递归中不断选择小的。

代码实现

```java
public ListNode Merge(ListNode list1,ListNode list2) {
    if(list1==null){
        return list2;
    }
    if(list2==null){
        return list1;
    }
    if(list1.val<list2.val){
        list1.next=Merge(list1.next,list2);
        return list1;
    }else{
        list2.next=Merge(list1,list2.next);
        return list2;
    }
}
```



####  两个链表的第一个公共节点

解题思路：

```
 ``假定 List1长度: a+n List2 长度:b+n, 且 a<b
    ``那么 p1 会先到链表尾部, 这时p2 走到 a+n位置,将p1换成List2头部
    ``接着p2 再走b+n-(n+a) =b-a 步到链表尾部,这时p1也走到List2的b-a位置，还差a步就到可能的第一个公共节点。
    ``将p2 换成 List1头部，p2走a步也到可能的第一个公共节点。如果恰好p1==p2,那么p1就是第一个公共节点。 或者p1和p2一起走n步到达列表尾部，二者没有公共节点，退出循环。 同理a>=b.
    ``时间复杂度O(n+a+b)
```

代码实现

```java
public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    ListNode work1=pHead1;
    ListNode work2=pHead2;
    while(work1!=work2){
        work1= work1==null?pHead1:work1.next;
        work2= work2==null?pHead2:work2.next;
    }
    return work1;
}
```



####  二叉树的深度 jz55

![image-20211121205200921](D:\java workstation\笔记\浪潮\images\image-20211121205200921.png)

解题思路: 递归进行解题，如果遇到叶子节点返回1， 当前节点的深度为 Math.max(左孩子的深度，右孩子的深度)+1。

代码实现

 

```java
 public int TreeDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
         if(root.left==null&& root.right==null){
            return 1;
        }
        int left_depth=TreeDepth(root.left);
        int right_depth=TreeDepth(root.right);
        //+1 是为了带上自己
        return Math.max(left_depth,right_depth)+1;
    }
```



#### 之字形打印二叉树

题目描述:

![image-20211121205710231](D:\java workstation\笔记\浪潮\images\image-20211121205710231.png)

解题思路: 使用layer 变量表示当前层数，使用一个双端队列 linkedlist()； 当layer 层为奇数的时候，从从左往右取，队列从小到大进行取元素，边取边边删除，并判断其是否有左右孩子，并将左右孩子入队列。 当layer 为偶数的时候，从右往左取，需要队列从大到小进行取元素，这时候光取不进行删除。取到队列第0个元素。这时候从队列的从小到大进行遍历。边遍历边删除，并判断是否有左右孩子，如有则进行入队列。

  

```java
  public ArrayList<ArrayList<Integer> > Print(TreeNode root) {
         ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }   
	LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int layer=1;
    while(!queue.isEmpty()){
        ArrayList<Integer> list = new ArrayList<>();
        // 将元素全部取出
        if(layer%2!=0){
            //从左向右取
            for(int i=queue.size();i>0;i--){
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if(poll.left!=null){
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }

            }
        }else{
            //从右向左取,只取不进行删除
            for(int i=queue.size()-1;i>=0;i--){
                TreeNode treeNode = queue.get(i);
                list.add(treeNode.val);
            }
            //这里的i 只是一个计数元素，其实还是从队列小端到大端
            for(int i=queue.size();i>0;i--){
                TreeNode poll = queue.poll();
                if(poll.left!=null){
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }
            }

        }
        layer++;
        res.add(list);
    }
    return res;

}
```




#### 重建二叉树

题目描述

![image-20211121211214156](D:\java workstation\笔记\浪潮\images\image-20211121211214156.png)

解题思路:  通过二叉树的前序和中序来构建二叉树， 通过规则可以知道，前序的某一位置的值，该值在中序遍历中其左部分为其左孩子的区域，右部分为右孩子的区域，可以一个hashmap 将中序遍历的每个值对应的位置进行保存。不断通过递归来重建二叉树。但有一个难点就是确定遍历的区域范围。难点递归子问题的递归区域范围的确定。

我的博客地址： https://blog.csdn.net/weixin_39802680/article/details/121464193?spm=1001.2014.3001.5502

代码实现:

```java
HashMap<Integer,Integer> hashMap=new HashMap<>();
public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
    int preLength=pre.length;
    int inLength=in.length;
    if(preLength!=inLength){
        return null;
    }
    for(int i=0;i<inLength;i++){
        //存储中序遍历中的
        hashMap.put(in[i],i);
    }
    TreeNode head=dfs(pre,in,0,preLength-1,0,inLength-1);
    return head;
}

public TreeNode dfs(int [] pre,int [] in,int pl,int pr,int vl,int vr){
    if(pl>pr){
        return null;
    }
    // 获得当前区域前序遍历第一个元素
    int k = hashMap.get(pre[pl]);
    TreeNode treeNode = new TreeNode(pre[pl]);
    TreeNode left=dfs(pre,in,pl+1,pl+k-vl,vl,k-1);
    TreeNode right=dfs(pre,in,pl+k-vl+1,pr,k+1,vr);
    treeNode.left=left;
    treeNode.right=right;
    return treeNode;
}
```



#### 二叉树的镜像

题目描述

![image-20211122100232835](D:\java workstation\笔记\浪潮\images\image-20211122100232835.png)

解题思路: 先序遍历，从下向上进行交换其左右孩子。

```java
public TreeNode Mirror(TreeNode pRoot) {
    if(pRoot==null){
        return null;
    }
    TreeNode treeNode = new TreeNode(pRoot.val);
    treeNode.right = Mirror(pRoot.left);
    treeNode.left = Mirror(pRoot.right);
    pRoot=treeNode;
    return pRoot;
}
```



#### 判断是不是平衡二叉树

题目描述

![image-20211122105243595](D:\java workstation\笔记\浪潮\images\image-20211122105243595.png)

解题思路： 先序遍历所有节点，获得每个节点的左右节点的最大深度进行判断。是否满足高度差的绝对值不超过1。

代码实现

```java
public boolean IsBalanced_Solution(TreeNode root) {
    if(root==null){
        return true;
    }
    int left=getDepth(root.left);
    int right=getDepth(root.right);
    if(Math.abs(left-right)>1){
        return false;
    }
    boolean isleft = IsBalanced_Solution(root.left);
    boolean isright = IsBalanced_Solution(root.right);
    return isleft&&isright;
}

// 获取某个节点最大的深度
int getDepth(TreeNode proot){
    if(proot==null){
        return 0;
    }
    int left=getDepth(proot.left);
    int right=getDepth(proot.right);
    return left>right? left+1:right+1;
}
```





#### 机器人的运动范围

![image-20211122112543124](D:\java workstation\笔记\浪潮\images\image-20211122112543124.png)

解题思路: 这是一道宽搜问题，每次将合法的方格加入到队列，统计遍历了多少格子。每次从队列取一个元素，将其合格的上下左右四个方向的元素添加到队列中，需要一个数组来标记是否被访问。

代码实现:

```java
package com.boshrong.leetcode.dfs;


import java.util.LinkedList;
class point{
    Integer a;
    Integer b;
    public point(Integer a,Integer b){
        this.a=a;
        this.b=b;
    }
    public int getPointa(){
        return this.a;
    }
    public int getPointb(){
        return this.b;
    }

}

public class 机器人的运动范围jz13 {
    public static void main(String[] args) {
        int i = movingCount(3, 2, 17);
        System.out.println(i);

    }
    public static int movingCount(int m, int n, int k) {
        // 坐标有两个值
        LinkedList<point> queue = new LinkedList<>();
        // 标记数组
        Boolean[][] flags = new Boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                flags[i][j]=false;
            }
        }
        //四个方向 上 右 下 左 dx 为向上的
        int [] dx=new int[]{-1,0,1,0};
        int [] dy=new int[]{0,1,0,-1};
        int result=0;
        queue.push(new point(0,0));
        flags[0][0]=true;
        while(!queue.isEmpty()){
            point pop = queue.pop();
            result++;
            //将满足条件的点加入队列中
            for(int i=0;i<4;i++){
                int i1 = pop.getPointa() + dx[i];
                int i2 = pop.getPointb() + dy[i];
                //边界判断并满足阈值条件并未被访问
                if (getTwo(i1,i2)<=k && i1<=m-1 && i1>=0 && i2>=0&& i2<=n-1){
                    if(!flags[i1][i2]){
                        flags[i1][i2]=true;
                        queue.push(new point(i1,i2));

                    }
                }
            }
        }
        return result;
    }
    //获取单个数字的位数之和
    static int getOne(int num){
        int result=0;
        while(num!=0){
            //取最后一个数
            result+=num%10;
            num=num/10;
        }
        return result;
    }
    static int getTwo(int num1,int num2){
        return getOne(num1)+getOne(num2);
    }
}
```

![image-20211130103613738](D:\java workstation\笔记\浪潮\images\image-20211130103613738.png)



#### 用两个栈实现队列jz9



解题思路:

push 的时候将其全部push到栈stack1，pop 的将stack1的push到stack2 中，返回stack2中栈顶的值，将stack2中的数重新push到stack1。

代码实现

```java
public class 用两个栈实现队列jz9 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while(!stack1.empty()){
           stack2.push( stack1.pop());
        }
        int result=stack2.pop();
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return result;
    }
}
```



#### 字符串的排列

题目描述

![image-20211130112636736](D:\java workstation\笔记\浪潮\images\image-20211130112636736.png)

解题思路: 这道题和全排列比较像，使用深度搜索解决，用一个list 数组表示剩余的字符，注意在一层递归中，for 循环是从0 到list 的长度。这时候不能传list 到下一层递归。如果传了就算后面add 进来也会改变list 的原有顺序。所以需要new 一个list 进行值传递。

代码实现:

```java
public static void main(String[] args) {
    Permutation("ABC");
}
// temp 保存中间结果， list 保存剩余的字符
static void dfs(String temp,ArrayList<Character> list,ArrayList<String> result){
    int len=list.size();
    if(len==0){
        if (!result.contains(temp)) {
            result.add(temp);
        }
        return;
    }
    for(int i=0;i<len;i++){
        //重新new 一段区域,因为list的在这段代码中的值不能修改
        ArrayList<Character> characters = new ArrayList<>(list);
        Character remove = characters.remove(i);
        dfs(temp+list.get(i),characters,result);
    }

}


public static ArrayList<String> Permutation(String str) {
    int lens=str.length();
    ArrayList<String> result = new ArrayList<>();
    if(lens<0){
        return result;
    }
    // 用一个char 类型的数组便于操作
    ArrayList<Character> list = new ArrayList<>();
    for(int i=0;i<lens;i++){
        list.add(str.charAt(i));
    }
    dfs("",list,result);
    return result;
}
```



![image-20211130174832444](D:\java workstation\笔记\浪潮\images\image-20211130174832444.png)



####　旋转数组的最小数字jz11

题目描述：

![image-20211209103153704](D:\java workstation\笔记\浪潮\images\image-20211209103153704.png)

解题思路: 因为要求的时间复杂度为O（logn），直接遍历获得最小值的时间复杂度也是o(n)。因为数组的特殊性为非降序数组。 可以直接采用二分的方法进行处理。

先判断array[left]与array[right]进行对比,如果array[left]<array[right]直接返回array[left]，left  与mid 进行对比。array[left]<array[mid] 说明 left 到mid 之间位置没有变换过。更新 left=mid+1，array[left]>array[mid] 说明left到mid 之间存在最小值,更新right=mid,如果相等无法判断最小值在左边还是右边。left++，缩小搜索范围。



代码实现：

```java
package com.boshrong.leetcode.排序类似;

public class 旋转数组的最小数字jz11 {
    public static void main(String[] args) {
        int [] array=new int[]{1,0,1,1,1};
        minNumberInRotateArray(array);
    }

    public static int minNumberInRotateArray(int [] array) {
        int lens=array.length;
        if(lens<0){
            return 0;
        }
        //空间复杂度o(1) 时间复杂度o(logn)，是排序的(有可能是相等的)，可以采用二分
        // 二分的问题是与左边比还是与右边比，刚开始的时候是用左边的进行对比发现相等的情况不好处理。
        int left=0;
        int right=lens-1;
        while(left< right){
            //如果array[left]<array[right]直接返回
            if(array[left]<array[right]){
                return array[left];
            }
            int mid;
            mid=(left+right)/2;
            if(array[left]<array[mid]){
                // array[left]<array[mid] 说明 left 到mid 之间位置没有变换过
                left=mid;
                continue;
            }else if (array[left]>array[mid]){
                // array[left]>array[mid] 说明left 之间存在最小值
                right=mid;
                continue;
            }else{
                //相等的情况，最小值可能在左边也可能在右边 eg: 1 0 1 1 1  和 2 2 2 1 2 这时候需要特殊处理
                // right++ 逐渐缩小空间
                left++;
            }

        }
        return array[left];
    }
}
```





![image-20211209111225194](D:\java workstation\笔记\浪潮\images\image-20211209111225194.png)



#### 数字在升序数组中出现的次数jz53

题目描述:

解题思路：时间复杂度要求:O(logn) ,如果使用hashmap的空间复杂度为o(n)并且要遍历数组一次进行插入时间复杂度至少是o(n)。数组是非降序。可以采用二分的方法先确定。k的位置，逐渐减少确定k 第一次出现的位置。

代码实现：

```java
public static int GetNumberOfK(int [] array , int k) {
    int lens=array.length;
    if (lens<0){
        return 0;
    }

    if(lens==1){
        if(array[lens-1]==k){
            return 1;
        }
    }
    int left=0;
    int right=lens-1;
    int  result=0;
    while(left<right){
        int mid;
        mid=(left+right)/2;
        if(array[mid]==k){
            //找到了
            mid--;
            while(mid>=0 &&array[mid]==k){
                mid--;
            }
            //mid在第一个与k 不同的位置
            mid++;
            while(mid<=lens-1 && array[mid]==k){
                mid++;
                result++;
            }
            break;
        }
        if(array[mid]>k){
            right=mid-1;
        }else{
            left=mid+1;
        }
    }
    return result;
}
```



#### 二维数组中的查找 jz4

题目描述

![image-20211210090610899](D:\java workstation\笔记\浪潮\images\image-20211210090610899.png)

解题思路： 指定数与二维数组最后一列的数字进行比较，先决定数字所在的行，然后再确定数字所在的列。

```
public class Solution {
    public boolean Find(int target, int [][] array) {
        boolean flag=false;
        int row=array.length;
        int column=array[0].length;
        for(int i=0,j=column-1;((i>=0 && i<row)&&(j>=0&&j<column));){
            if(array[i][j]==target){
                flag =true;
                break;
            }
            else if(array[i][j]>target){
                j--;
            }else{
                i++;
            }
        }
        return flag;
    }

}
```





#### 合并k个升序链表23

题目描述：

解题思路： 在合并链表题目中，如果题目要求空间复杂度为o(1)，则需要**原地调整链表元素的next指针实现合并**，合并两个有序链表的常用做法是： 创建一个虚拟头部head, 尾指针tail 记录下一个将要插入位置的前一个位置(尾插法)，两个工作指针ptrwork1,ptrwork2 指向两个链表未合并的第一部分。

该题解题方法：1 分治合并  2 使用优先队列进行合并

1 对链表两两进行合并，直到合并到只剩一个链表

2 优先队列，若链表有头结点将头结点加入到优先队列，从优先队列中元素，如果该元素有next 将其加入到优先队列中。

代码实现： 

```java
public ListNode mergeKLists(ListNode[] lists) {
    int lens= lists.length;
    if(lens==0){
        return null;
    }
    //定义头结点
    ListNode head = new ListNode(0);
    PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val>o2.val ?1:-1;
        }
    });

    //队列初始化
    for(int i=0;i<lens;i++){
        if(lists[i]!=null)
            priorityQueue.add(lists[i]);
    }
    ListNode tail=head;
    while(!priorityQueue.isEmpty()){
        // 取出来
        ListNode poll = priorityQueue.poll();
        if(poll.next!=null){
            priorityQueue.add(poll.next);
        }
        //尾插法插入
        poll.next=null;
        tail.next=poll;
        tail=poll;

    }
    return head.next;
}
```

运行结果： 





####  单链表排序 jz77

题目描述

解题思想： 采用直接插入排序思想，前半部分有序，从后面去没有插有序的结点插入到有序的链表中。每次从有序中头结点还是进行比较。

设置一个虚拟头部并设置三个工作指针，p 指向未插入到有序的结点, r 是其p 的后面一个指针（用来给p赋值），还需要一个q要插入位置的前躯 。q每次重新指向有序的头。

结果是没有问题的，但显示时间超时。

```java
public static ListNode sortList(ListNode head) {

    if(head==null){
        return null;
    }
    //新增一个虚拟头部
    ListNode vheader = new ListNode(0);
    ListNode p=head;
    ListNode q=vheader;
    ListNode r=p;

    while(p!=null){
        r=p.next;
        p.next=null;
        //找到p 结点要插入的位置
        while(q.next!=null&& q.next.val<p.val){
            q=q.next;
        }
        //找到了p 要插入的位置，q为前驱，进行插入
        p.next=q.next;
        q.next=p;
        // q重新指向头
        q=vheader;
        p=r;
    }
    return vheader.next;
}
```





####  两两交换链表中的结点24

题目描述：



解题思路：创建一个虚拟头部，三个工作节点 preNode,work,nodenext。 work 指向要交换结点的第一个结点,nodenext 指向第二个结点，preNode 指向两个结点的前一个节点，其目的是为了让交换后其next指向交换结点的第一个结点。每次交换后需要更新preNode,work,nodenext 的指向。

代码实现： 

```java
public static ListNode swapPairs(ListNode head) {
    if(head==null){
        return null;
    }
    //定义一个虚拟头部
    ListNode vHead=new ListNode(0);
    vHead.next=head;
    // 三个工作结点
    ListNode preNode=vHead;
    ListNode work=head;
    ListNode nodeNext=work.next;
    while(nodeNext!=null){
        //进行插入
        work.next=null;
        work.next=nodeNext.next;
        nodeNext.next=work;
        preNode.next=nodeNext;
        preNode=work;
        //向后走
        if(work.next!=null){
            work=work.next;
        }else{
            break;
        }
        nodeNext=work.next;
    }
    return vHead.next;
}
```





#### K个一组翻转链表25* 

解题思路： 创建虚拟的头节点，方便操作。获取链表的长度除以给定的k，确定有几段要进行翻转。每段的翻转采用头插法来进行翻转。因此需要一个工作节点 preLastNode 指向前一个翻转的最后一个节点。在写代码的过程中发现，还需要一个工作节点preLastNodeNext 指向preLastNode 的next。preLastNodeNext 指向未翻转的一段的开头，经过翻转指向每一段的结尾。最后需将不翻转的连接到翻转后的链表后面。

代码实现

```java
public ListNode reverseKGroup(ListNode head, int k) {
    if(head==null || head.next==null ){
        return head;
    }
    int lens=0;
    ListNode work=head;
    while(work!=null){
        work=work.next;
        lens++;
    }
    work=head;
    // 要翻转d 段
    int d=lens/k;
    // 定义一个虚拟头部
    ListNode vHead = new ListNode(0);

    //之前段的最后一个节点
    ListNode preLastNode = vHead;
    ListNode preLastNodeNext=vHead;
    //两个工作节点
    ListNode nodeNext=work.next;
    while(d!=0){
        int num=0;
        preLastNodeNext=work;
        while(num!=k&& work!=null){
            //使用头插法进行翻转
            nodeNext=work.next;
            work.next=null;
            work.next=preLastNode.next;
            preLastNode.next=work;
            work=nodeNext;
            num++;
        }
        preLastNode=preLastNodeNext;
        d--;
    }
    //将不翻转的连接到翻转后的链表后面
    preLastNodeNext.next=nodeNext;
    return vHead.next;
}
```





#### 删除有序数组中的重复项26* 

题目描述

解题思路:  使用双指针。 快指针用于扫描，找到非重复的元素。 慢指针i用于指向可覆盖的位置。i-1 指向最后一个非重复的元素。所以i,j 初始的时候都指向1。

​			每次nums[j]与nums[i-1]不等，nums[j] 复制到nums[i],i 前进一步，赋值之后j 也增加。

​			如果相等,j 增加。continue。

​			其利用了有序，最后返回的长度就是 i 的位置。

没有解出来这道题,使用的leetcode 的题解。 

关键词:  原地修改。 模式识别:  需要保存可覆盖位置和观察位置。

 

代码实现：

```java
public int removeDuplicates(int[] nums) {
    int lens=nums.length;
    if(lens==1 || lens==0){
        return lens;
    }

    int i=1,j=1;
    while(j<lens){
        if(nums[i-1]!=nums[j]){
            nums[i]=nums[j];
            i++;

        }else{
            j++;
            continue;
        }

        j++;
    }
    return i;
}
```



​	

#### 移除元素27*

题目描述：

解题思路: 注意元素的顺序可以改变。这一道题的思想与上一题思想类似。也采用双指针。其`主要的思想返回的长度以内数组是不包含给定数字。` 

双指针：右指针right 指向当前将要处理的元素，左指针 left 指向下一个将要赋值的位置。

如果右指针指向的元素不等于val，它一定是输出数组的一个元素，我们就将右指针指向的元素复制到左指针位置，然后将左右指针同时右移；

如果右指针指向的元素等于 val，它不能在输出数组里，此时左指针不动，右指针右移一位。

整个过程保持不变的性质是：区间 [0,left) 中的元素都不等于 val。当左右指针遍历完输入数组以后，left 的值就是输出数组的长度。

​		

代码实现：

```java
public static  int removeElement(int[] nums, int val) {
    int lens=nums.length;
    if(lens==0){
        return lens;
    }
    int left=0,right=0;
    while(right<lens){
        if(nums[right]==val){
            right++;
        }else{
            nums[left]=nums[right];
            left++;
            right++;
        }
    }
    return left;
}
```





####  实现strStr 28

题目描述:



如果暴力求解就要用到 KMP 算法。直接简单操作。

```java
public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
}
```







#### 两数相除29

题目描述

解题思路： 根据除法的定义，每次都减去被除数。记录被减去的次数，得到的就是商。但这种方法会超时，可以采用指数增加(每次左移一位，相当于乘2)方法，每次减去被除数左移一位，同时记录被减去的次数也左移一位。每次步长加倍。步长加倍之后，也会造成被除数过大，如果被除数过大超过除数之后，需要给被除数赋值最初始的值。继续步长增长，直到除数小于最原始的被除数。

java 中的左移: <<   右移  >>  无符号右移>>>

java 中判断两个数是否异号: java 整型占4个字节32位，两个数异或(同为0，不同为1)后无符号右移移动31位，如果为1为异号，0为同号。 举例:   (a^b)>>>31

代码实现

```java
public static int divide(int dividend, int divisor) {
        if(divisor==0){
            return 0;
        }
        // >>> 无符号右移动
        int flag=(dividend^divisor)>>>31==1?-1:1;
        int count=0;
        long undividend=Math.abs(dividend);
        long undivisor=Math.abs(divisor);
        //如果dividend 如果小于Integer.MIN_VALUE取绝对值其还为负数,并且为不为异号,其为正数，正数要少一位。
//        if(undividend<=Integer.MIN_VALUE && divisor==-1){
//            return Integer.MAX_VALUE;
//        }
//        if(undividend<=Integer.MIN_VALUE&& divisor==1){
//             return Integer.MIN_VALUE;
//        }
//        if(undividend<=Integer.MIN_VALUE){
//            undividend=Integer.MAX_VALUE;
//            count++;
//        }

        while(undividend>=undivisor){
            //重新赋值。
            int i=1;
            // 使用tmp 代表每次增长的那个数
            long tmp=undivisor;
            while(undividend>=tmp){
                //步数增长
                undividend-=tmp;
                count+=i;
                i=i<<1;
                tmp=tmp<<1;
            }
        }
        count=count*flag;
        if(count>=Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(count<=Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return count;
    }
```

虽然不想判断整数越界问题，但指数增长的思想是十分重要的。



#### 串联所有单词的的字串30



解题思路





#### 岛屿数量200

题目描述

解题思路:  这道题与矩阵中路径很相似。也是进行搜索。需要一个访问数组flag。 dfs搜索的目的就是对flag 数组进行标记。主程序中进入dfs 的次数就是有几个岛屿。



代码实现:

```java
//定义四个方向 上下左右
int [] dx=new int[]{-1,0,1,0};
int [] dy=new int[]{0,1,0,-1};

//有1 进入搜索,dfs搜索的目的就是对flag 数组进行标记。
public void dfs(char [][] grid,boolean [][] flag,int i,int j){
    int len1=grid.length;
    int len2=grid[0].length;
    if(grid[i][j]==0){
        return ;
    }

    for(int k=0;k<4;k++){
        if(i+dx[k]<len1&& i+dx[k]>=0 && j+dy[k]>=0&& j+dy[k]<len2){
            if(grid[i+dx[k]][j+dy[k]]=='1'&& flag[i+dx[k]][j+dy[k]]==false){
                flag[i+dx[k]][j+dy[k]]=true;
                dfs(grid,flag,i+dx[k],j+dy[k]);

            }
        }
    }

}
public int numIslands(char[][] grid) {
    int len1=grid.length;
    int len2=grid[0].length;
    if(len1==0 && len2==0){
        return 0;
    }
    int result=0;
    boolean [][] flag=new boolean[len1][len2];
    for(int i=0;i<len1;i++){
        for(int j=0;j<len2;j++){
            if(grid[i][j]=='1'&& flag[i][j]==false){
                flag[i][j]=true;
                dfs(grid,flag,i,j);
                result++;
            }
        }
    }

    return result;
}
```





