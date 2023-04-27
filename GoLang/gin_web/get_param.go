package main

import "github.com/gin-gonic/gin"

func main() {
	r := gin.Default()
	// 获取Query参数
	r.GET("/", func(c *gin.Context) {
		name := c.Query("name")
		pwd := c.Query("pwd")
		c.JSON(200, gin.H{
			"name": name,
			"pwd":  pwd,
		})
	})
	// 获取Form参数
	r.POST("/", func(c *gin.Context) {
		username := c.PostForm("username")
		password := c.PostForm("password")
		c.JSON(200, gin.H{
			"username": username,
			"password": password,
		})
	})
	// 获取Path参数
	r.GET("/user/:name/:pwd", func(c *gin.Context) {
		name := c.Param("name")
		pwd := c.Param("pwd")
		c.JSON(200, gin.H{
			"name": name,
			"pwd":  pwd,
		})
	})
	r.Run()
}
