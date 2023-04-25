package main

import (
	"log"
	"net/http"
	"strings"
)

func sayHelloName(w http.ResponseWriter, r *http.Request) {
	// 解析参数,默认是不会解析的.如果没有解析,下面无法获取表单的数据
	r.ParseForm()
	// 这些信息是输出到服务器端的打印信息
	println(r.Form)
	// 打印请求路径
	println(r.URL.Path)
	// 打印请求的Scheme
	println(r.URL.Scheme)
	// 打印请求的参数
	println(r.Form["url_long"])
	// 这个写入到w的是输出到客户端的
	for k, v := range r.Form {
		println("key:", k)
		println("val:", strings.Join(v, ""))
	}
}

func main() {
	http.HandleFunc("/", sayHelloName)
	err := http.ListenAndServe(":9090", nil)
	if err != nil {
		log.Fatal("ListenAndServe:", err)
	}
}
