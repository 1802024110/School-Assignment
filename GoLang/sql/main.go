package main

import (
	// "time"

	"database/sql"
	_ "github.com/go-sql-driver/mysql"
)

func checkErr(err error) {
	if err != nil {
		panic(err)
	}
}

func main() {
	db, err := sql.Open("mysql", "root:zengyuan@tcp(home.007666.xyz:3306)/test?charset=utf8")
	defer db.Close()

	// 插入数据
	stmt, err := db.Prepare("INSERT userinfo SET username=?,departname=?,created=?")
	// 执行
	res, err := stmt.Exec("astaxie", "研发部门", "2012-12-09")
	// 获取id
	id, err := res.LastInsertId()
	print(id)

	// 更新数据
	stmt, err = db.Prepare("update userinfo set username=? where username=?")
	res, err = stmt.Exec("astaxie", "astaxie2")
	affect, err := res.RowsAffected()
	print(affect)

	// 查询数据
	rows, err := db.Query("SELECT * FROM userinfo")
	for rows.Next() {
		var uid int
		var username string
		var department string
		var created string
		err = rows.Scan(&uid, &username, &department, &created)
		print(uid)
		print(username)
		print(department)
		print(created)
	}

	// 删除数据
	stmt, err = db.Prepare("delete from userinfo where uid=?")
	res, err = stmt.Exec(id)
	// 获取影响行数
	affect, err = res.RowsAffected()
	print(affect)
	checkErr(err)
}
