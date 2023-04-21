package main

import "fmt"

type Books struct {
	title   string
	author  string
	subject string
	bookId  int
}

func printBook(book Books) {
	fmt.Println("Book title : ", book.title)
	fmt.Println("Book author : ", book.author)
	fmt.Println("Book subject :  ", book.subject)
	fmt.Println("Book bookId : ", book.bookId)
}

func main() {
	var Book1 Books
	Book1.title = "Go Programming"
	Book1.author = "Kundalini"
	Book1.subject = "Go Programming Tutorial"
	Book1.bookId = 6495407
	printBook(Book1)

	var Book2 Books
	Book2.title = "Python Programming"
	Book2.author = "Kundalini"
	Book2.subject = "Python Programming Tutorial"
	Book2.bookId = 6495407
	printBook(Book2)

	// 结构体指针
	var structPointer *Books = &Book1
	println(structPointer.title)
}
