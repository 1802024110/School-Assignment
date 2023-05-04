package main

import "github.com/gin-gonic/gin"

func main() {
	r := gin.Default()

	r.GET("/students", func(context *gin.Context) {
		context.JSON(200, gin.H{
			"message": "学生信息查询成功",
		})
	})

	r.POST("/students", func(context *gin.Context) {
		context.JSON(200, gin.H{
			"message": "创建学生成功",
		})
	})

	r.PUT("/students", func(context *gin.Context) {
		context.JSON(200, gin.H{
			"message": "更新学生成功",
		})
	})

	r.DELETE("/students", func(context *gin.Context) {
		context.JSON(200, gin.H{
			"message": "删除学生成功",
		})
	})

	r.Run()
}
