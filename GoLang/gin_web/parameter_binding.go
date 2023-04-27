package main

import (
	"github.com/gin-gonic/gin"
	"net/http"
)

type Userinfo struct {
	Username string `form:"username"`
	Password string `form:"password"`
}

func main() {
	r := gin.Default()
	r.GET("/user", func(c *gin.Context) {
		var u Userinfo
		err := c.ShouldBind(&u)
		if err != nil {
			c.JSON(http.StatusBadGateway, gin.H{
				"error": err.Error(),
			})
		} else {
			c.JSON(http.StatusOK, gin.H{
				"status": "ok",
			})
		}
		println(u.Username, u.Password)
	})
	r.Run()
}
