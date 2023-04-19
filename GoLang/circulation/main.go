package main

// https://www.twle.cn/l/yufei/golang/golang-basic-loops.html
func main() {
	// 正常for循环
	for i := 0; i < 10; i++ {
		println(i)
	}

	// 死循环
	//for true {
	//	println("hello")
	//}

	// for...range循环
	for key, value := range []int{1, 2, 3, 4, 5} {
		println(key, value)
	}

	// goto
	a := 0
	for a < 10 {
	LOOP:
		println("go here")
		a++
		if a == 5 {
			goto LOOP
		}
	}
}
