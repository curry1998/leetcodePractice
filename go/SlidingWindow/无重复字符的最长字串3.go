package SlidingWindow

func LengthOfLongestSubstring(s string) int {

	// go 中没有 set 可以使用 map 来保证唯一性
	countMap := map[rune]bool{}
	arr := []rune(s)
	left, right, lens := 0, 0, len(arr)
	res := 0
	for right < lens {
		t := arr[right]
		for countMap[t] {
			// 删除set 中的重复元素，直到不重复
			delete(countMap, arr[left])
			left++
		}
		if right-left >= res {
			res = right - left + 1
		}
		countMap[arr[right]] = true
		right++
	}
	return res
}
