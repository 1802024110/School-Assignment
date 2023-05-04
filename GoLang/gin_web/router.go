package main

import "github.com/gin-gonic/gin"

func main() {
	r := gin.Default()

	// 普通路由
	r.GET("/get", func(c *gin.Context) {})

	// 匹配所有请求方式的方法
	r.Any("/any", func(c *gin.Context) {})

	// 路由组
	user := r.Group("/user")
	user.GET("/index", func(c *gin.Context) {})
	user.GET("/login", func(c *gin.Context) {})

	// 路由组嵌套
	Tom := user.Group("/Tom")
	Tom.GET("/index", func(c *gin.Context) {})

	r.Run()
}
