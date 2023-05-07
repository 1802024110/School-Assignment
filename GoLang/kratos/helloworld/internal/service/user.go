package service

import (
	"context"
	v1 "helloworld/api/realworld/v1"
)

func (s *RealWorldService) Login(ctx context.Context, req *v1.LoginRequest) (reply *v1.UserReply, err error) {
	return &v1.UserReply{
		User: &v1.UserReply_User{
			Email:    "example@xxx.com",
			Token:    "123456",
			Username: "小明",
			Bio:      "方式",
			Image:    "base64://dsfsd",
		},
	}, nil
}
