package main

import (
	"github.com/gin-gonic/gin"
	"io"
	"os"
)

func main() {
	// 禁用控制台颜色，当你将日志记录到文件时，禁用控制台颜色能够让记录的日志更加整洁。
	gin.DisableConsoleColor()

	// 记录到文件。
	f, _ := os.Create("./tmp/gin.log")
	gin.DefaultWriter = io.MultiWriter(f)

	// 如果需要同时记录到文件和控制台，请使用以下代码。
	// gin.DefaultWriter = io.MultiWriter(f, os.Stdout)

	r := gin.Default()
	r.GET("/ping", func(c *gin.Context) {
		c.String(200, "pong")
	})

	r.Run()
}
