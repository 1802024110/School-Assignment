package main

import (
	"github.com/gin-gonic/gin"
	"net/http"
)

type myForm struct {
	Colors []string `form:"colors[]"`
}

func indexHandler(context *gin.Context) {
	context.HTML(http.StatusOK, "checkboxes.html", nil)
}

func formHandler(context *gin.Context) {
	var fakeForm myForm
	context.Bind(&fakeForm)
	context.JSON(http.StatusOK, gin.H{"color": fakeForm.Colors})
}

func main() {
	r := gin.Default()

	r.LoadHTMLGlob("templates/*")
	r.GET("/", indexHandler)
	r.POST("/form", formHandler)

	r.Run()
}
