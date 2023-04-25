package main

import "fmt"

/*
map 又称作哈希表，是一种无序的键值对集合，键值对中的键和值都是任意类型的。
map是通过key来索引的，key可以是任意类型，但是通常使用string或者int类型。
map是一种集合，我们可以像迭代数组和切片那样迭代map，但是map是无序的，每次迭代的结果都不一样。
map是使用hash表来实现的，所以map的查找和删除速度很快，比使用线性查找快得多，但是请注意map是无序的，不支持排序，也不支持使用”>”或者”<”来比较元素。
*/

// 打印map函数
func printMap(m map[string]int) {
	for k, v := range m {
		fmt.Println(k, v)
	}
}
func main() {
	// 使用内建函数make创建map
	mapForMake := make(map[string]int)
	printMap(mapForMake)

	// 使用map字面量创建map
	mapForLiteral := map[string]int{"one": 1, "two": 2, "three": 3}
	printMap(mapForLiteral)
}
