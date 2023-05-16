package biz

import (
	"context"
	"github.com/go-kratos/kratos/v2/errors"
	"github.com/go-kratos/kratos/v2/log"
	"golang.org/x/crypto/bcrypt"
)

type User struct {
	Username     string
	Email        string
	Bio          string
	Image        string
	Password     string
	PasswordHash string
}

func hashPassword(pwd string) string {
	b, err := bcrypt.GenerateFromPassword([]byte(pwd), bcrypt.DefaultCost)
	if err != nil {
		panic(err)
	}
	return string(b)
}

func verifyPassword(hashed, input string) bool {
	err := bcrypt.CompareHashAndPassword([]byte(hashed), []byte(input))
	if err != nil {
		return false
	}
	return true
}

type UserRepo interface {
	CreateUser(ctx context.Context, user *User) error
	GetUserByEmail(ctx context.Context, email string) (*User, error)
}

type ProfileRepo interface {
}
type UserUsecase struct {
	ur  UserRepo
	pr  ProfileRepo
	log *log.Helper
}

func NewUserUsecase(ur UserRepo, pr ProfileRepo, logger log.Logger) *UserUsecase {
	return &UserUsecase{
		ur:  ur,
		pr:  pr,
		log: log.NewHelper(logger),
	}
}

func (uc *UserUsecase) Register(ctx context.Context, username, email, password string) (*UserLogin, error) {
	u := &User{
		Username: username,
		Email:    email,
		Password: hashPassword(password),
	}
	err := uc.ur.CreateUser(ctx, u)
	if err != nil {
		return nil, err
	}
	return &UserLogin{
		Username: username,
		Email:    email,
		Token:    "xxx",
	}, nil
}

type UserLogin struct {
	Username string
	Email    string
	Token    string
	Bio      string
	Image    string
	Password string
}

func (uc *UserUsecase) Login(ctx context.Context, email string, password string) (*UserLogin, error) {
	u, err := uc.ur.GetUserByEmail(ctx, email)
	if err != nil {
		return nil, err
	}
	if !verifyPassword(u.PasswordHash, password) {
		return nil, errors.Unauthorized("user", "login failed")
	}
	return &UserLogin{
		Username: u.Username,
		Email:    u.Email,
		Token:    "123456",
		Bio:      u.Bio,
		Image:    u.Image,
	}, nil
}
