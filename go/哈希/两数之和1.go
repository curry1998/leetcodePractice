package 哈希

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
