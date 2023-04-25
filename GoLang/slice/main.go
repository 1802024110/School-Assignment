package main

import "fmt"

// 打印切片函数
func printSlice(s []int) {
	/*
		len() 函数返回切片的长度
		cap() 函数返回切片的容量, 容量是从创建切片的索引开始到底层数组的长度, 也就是从切片的第一个元素到最后一个元素的数量
	*/
	fmt.Printf("len=%d cap=%d slice=%v \r \n", len(s), cap(s), s)
}

func main() {
	var slice1 []int
	// append() 函数向切片追加元素, 并返回新的切片
	slice1 = append(slice1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
	printSlice(slice1)

	var slice2 []int = make([]int, 10)
	// copy() 函数将一个切片复制到另一个切片中, 并返回复制的元素的个数
	copy(slice2, slice1)
	printSlice(slice2)

	slice3 := make([]int, 10)
	copy(slice3, slice1)
	printSlice(slice3)

	slice4 := []int{1, 2, 3, 4, 5}
	printSlice(slice4)

	slice5 := slice1[2:5]
	printSlice(slice5)

	slice6 := slice1[:]
	printSlice(slice6)

	slice7 := slice1[5:]
	printSlice(slice7)

	slice8 := slice1[:5]
	printSlice(slice8)

	// 空(nil)切片, 长度和容量都是0
	var slice9 []int
	printSlice(slice9)
}
