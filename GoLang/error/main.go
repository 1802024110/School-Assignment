package main

import "errors"

/*
Go语言通过内置的错误接口提供了非常简单的错误处理机制。
Go 语言中的错误处理分为5个步骤：
1. 生成错误：使用 errors.New 或者 fmt.Errorf 生成错误。
2. 返回错误：使用 return 返回错误。
3. 接收错误：使用 err := func() 的方式接收错误。
4. 判断错误：使用 if err != nil 的方式判断错误。
5. 处理错误：使用 panic 或者 return 的方式处理错误。
*/

// 生成错误
type error interface {
	Error() string
}

// 返回错误
func funcName() (int, error) {
	return 0, errors.New("error")
}

func main() {
	// 接收错误
	_, err := funcName()
	println(err)

	// 判断错误
	if err != nil {
		// 处理错误
		println("err != nil")
	}
}
