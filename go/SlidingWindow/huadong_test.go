package SlidingWindow

import (
	"reflect"
	"testing"
)

func TestLengthOfLongestSubstring(t *testing.T) {
	// ...
	got := LengthOfLongestSubstring("abcabcbb")
	want := 3
	if !reflect.DeepEqual(want, got) {
		t.Errorf("expected:%v, got:%v", want, got) // 测试失败输出错误提示
	}
}
