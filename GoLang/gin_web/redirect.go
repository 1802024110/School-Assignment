package main

import (
	"github.com/gin-gonic/gin"
	"net/http"
)

func main() {
	r := gin.Default()
	// http重定向
	r.GET("/test", func(c *gin.Context) {
		c.Redirect(http.StatusMovedPermanently, "https://007666.xyz/")
	})

	// 路由重定向
	r.GET("/test2", func(c *gin.Context) {
		c.Request.URL.Path = "/test3"
		r.HandleContext(c)
	})

	r.GET("/test3", func(c *gin.Context) {
		c.JSON(http.StatusOK, gin.H{
			"message": "test3",
		})
	})

	r.Run()
}
