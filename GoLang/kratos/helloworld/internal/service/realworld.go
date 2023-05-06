package service

import (
	"context"

	v1 "helloworld/api/realworld/v1"
	"helloworld/internal/biz"
)

// RealWorldService is a RealWorld service.
type RealWorldService struct {
	v1.UnimplementedRealWorldServer

	uc *biz.GreeterUsecase
}

// NewRealWorldService new a greeter service.
func NewRealWorldService(uc *biz.GreeterUsecase) *RealWorldService {
	return &RealWorldService{uc: uc}
}

// SayHello implements realworld.GreeterServer.
func (s *RealWorldService) SayHello(ctx context.Context, in *v1.HelloRequest) (*v1.HelloReply, error) {
	g, err := s.uc.CreateGreeter(ctx, &biz.Greeter{Hello: in.Name})
	if err != nil {
		return nil, err
	}
	return &v1.HelloReply{Message: "Hello " + g.Hello}, nil
}
