package main

import (
	"net/http"
	"time"
)

func sayHello(w http.ResponseWriter, r *http.Request) {
	expiration := time.Now()
	expiration = expiration.AddDate(1, 0, 0)
	cookie := http.Cookie{Name: "username", Value: "joe", Expires: expiration}
	http.SetCookie(w, &cookie)
	w.Write([]byte("Hello "))
}
func main() {
	http.HandleFunc("/", sayHello)
	http.ListenAndServe(":8080", nil)
}
