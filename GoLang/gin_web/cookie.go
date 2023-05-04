package main

import "github.com/gin-gonic/gin"

func main() {
	r := gin.Default()
	r.GET("/test", func(c *gin.Context) {
		cookie, err := c.Cookie("gin_cookie")
		if err != nil {
			cookie = "NotSet"
			// 设置cookie
			c.SetCookie("gin_cookie", "test", 3600, "/", "localhost", false, true)
		}
		c.JSON(200, gin.H{
			"cookie": cookie,
		})
	})

	r.Run()
}
