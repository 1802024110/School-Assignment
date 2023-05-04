package main

import (
	"github.com/gin-gonic/gin"
	"log"
	"time"
)

func main() {
	r := gin.Default()

	r.GET("/test1", func(c *gin.Context) {
		tmp := c.Copy()
		go func() {
			time.Sleep(5 * time.Second)
			log.Println("test1已经执行完毕，路径是：", tmp.Request.URL.Path)
		}()
	})

	r.GET("/test2", func(c *gin.Context) {
		time.Sleep(5 * time.Second)
		log.Println("test2已经执行完毕，路径是：", c.Request.URL.Path)
	})

	r.Run()
}
