package main

import (
	"github.com/gin-gonic/gin"
	"net/http"
	"time"
)

func m1(c *gin.Context) {
	println("m1 in...")
	start := time.Now()
	c.Abort() // 中断后续的处理函数
	cost := time.Since(start)
	println("m1 out...", cost)
}

func index(c *gin.Context) {
	c.JSON(http.StatusOK, gin.H{
		"msg": "ok",
	})
}

func main() {
	r := gin.Default()
	//127.0.0.1:8080
	r.GET("/", m1, index)
	r.Run()
}
