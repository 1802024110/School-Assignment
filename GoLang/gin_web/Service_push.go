package main

import (
	"github.com/gin-gonic/gin"
	"html/template"
	"log"
	"net/http"
)

var html = template.Must(template.New("https").Parse(`
<html>
<head>
  <title>Https Test</title>
  <script src="/assets/app.js"></script>
</head>
<body>
  <h1 style="color:red;">Welcome, Ginner!</h1>
</body>
</html>
`))

func main() {
	r := gin.Default()
	r.Static("/assets", "./assets")
	r.SetHTMLTemplate(html)

	r.GET("/", func(context *gin.Context) {
		if pusher := context.Writer.Pusher(); pusher != nil {
			// 使用pusher.Push()来推送具体资源
			if err := pusher.Push("/assets/app.js", nil); err != nil {
				log.Printf("Failed to push: %v", err)
			}
		}
		context.HTML(http.StatusOK, "https", gin.H{
			"status": "success",
		})
	})
	// 没有证书，无法运行
	r.RunTLS(":8080", "./testdata/server.pem", "./testdata/server.key")
}
