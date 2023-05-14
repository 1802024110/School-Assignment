package biz

import (
	"github.com/davecgh/go-spew/spew"
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestHashPassword(t *testing.T) {
	s := hashPassword("123456")
	//$2a$10$F3pln.dikrhEg2ZA6jqW4.ZGGjsIMfKXLXSvg.11UKz8xPBCPTwtK
	spew.Dump(s)
	panic(1)
}

func TestVerifyPassword(t *testing.T) {
	a := assert.New(t)
	a.True(verifyPassword("$2a$10$F3pln.dikrhEg2ZA6jqW4.ZGGjsIMfKXLXSvg.11UKz8xPBCPTwtK", "123456"))
}
