package main

import "fmt"

// https://www.twle.cn/l/yufei/golang/golang-basic-strings.html
func main() {
	const greeting = "Hello World"
	println(greeting)

	const sampleText = "\xbd\xb2\x3d\xbc\x20\xe2\x8c\x98"
	fmt.Printf("%+q", sampleText)
}
