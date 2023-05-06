// Code generated by protoc-gen-go-http. DO NOT EDIT.
// versions:
// - protoc-gen-go-http v2.6.1
// - protoc             v4.23.0--rc3
// source: realworld/v1/realworld.proto

package v1

import (
	context "context"
	http "github.com/go-kratos/kratos/v2/transport/http"
	binding "github.com/go-kratos/kratos/v2/transport/http/binding"
)

// This is a compile-time assertion to ensure that this generated file
// is compatible with the kratos package it is being compiled against.
var _ = new(context.Context)
var _ = binding.EncodeURL

const _ = http.SupportPackageIsVersion1

const OperationRealWorldMyRpc = "/realworld.v1.RealWorld/MyRpc"
const OperationRealWorldSayHello = "/realworld.v1.RealWorld/SayHello"

type RealWorldHTTPServer interface {
	MyRpc(context.Context, *NullRequest) (*NullReply, error)
	// SayHello Sends a greeting
	SayHello(context.Context, *HelloRequest) (*HelloReply, error)
}

func RegisterRealWorldHTTPServer(s *http.Server, srv RealWorldHTTPServer) {
	r := s.Route("/")
	r.GET("/realworld/{name}", _RealWorld_SayHello0_HTTP_Handler(srv))
	r.GET("/realworld/myrpc", _RealWorld_MyRpc0_HTTP_Handler(srv))
}

func _RealWorld_SayHello0_HTTP_Handler(srv RealWorldHTTPServer) func(ctx http.Context) error {
	return func(ctx http.Context) error {
		var in HelloRequest
		if err := ctx.BindQuery(&in); err != nil {
			return err
		}
		if err := ctx.BindVars(&in); err != nil {
			return err
		}
		http.SetOperation(ctx, OperationRealWorldSayHello)
		h := ctx.Middleware(func(ctx context.Context, req interface{}) (interface{}, error) {
			return srv.SayHello(ctx, req.(*HelloRequest))
		})
		out, err := h(ctx, &in)
		if err != nil {
			return err
		}
		reply := out.(*HelloReply)
		return ctx.Result(200, reply)
	}
}

func _RealWorld_MyRpc0_HTTP_Handler(srv RealWorldHTTPServer) func(ctx http.Context) error {
	return func(ctx http.Context) error {
		var in NullRequest
		if err := ctx.BindQuery(&in); err != nil {
			return err
		}
		http.SetOperation(ctx, OperationRealWorldMyRpc)
		h := ctx.Middleware(func(ctx context.Context, req interface{}) (interface{}, error) {
			return srv.MyRpc(ctx, req.(*NullRequest))
		})
		out, err := h(ctx, &in)
		if err != nil {
			return err
		}
		reply := out.(*NullReply)
		return ctx.Result(200, reply)
	}
}

type RealWorldHTTPClient interface {
	MyRpc(ctx context.Context, req *NullRequest, opts ...http.CallOption) (rsp *NullReply, err error)
	SayHello(ctx context.Context, req *HelloRequest, opts ...http.CallOption) (rsp *HelloReply, err error)
}

type RealWorldHTTPClientImpl struct {
	cc *http.Client
}

func NewRealWorldHTTPClient(client *http.Client) RealWorldHTTPClient {
	return &RealWorldHTTPClientImpl{client}
}

func (c *RealWorldHTTPClientImpl) MyRpc(ctx context.Context, in *NullRequest, opts ...http.CallOption) (*NullReply, error) {
	var out NullReply
	pattern := "/realworld/myrpc"
	path := binding.EncodeURL(pattern, in, true)
	opts = append(opts, http.Operation(OperationRealWorldMyRpc))
	opts = append(opts, http.PathTemplate(pattern))
	err := c.cc.Invoke(ctx, "GET", path, nil, &out, opts...)
	if err != nil {
		return nil, err
	}
	return &out, err
}

func (c *RealWorldHTTPClientImpl) SayHello(ctx context.Context, in *HelloRequest, opts ...http.CallOption) (*HelloReply, error) {
	var out HelloReply
	pattern := "/realworld/{name}"
	path := binding.EncodeURL(pattern, in, true)
	opts = append(opts, http.Operation(OperationRealWorldSayHello))
	opts = append(opts, http.PathTemplate(pattern))
	err := c.cc.Invoke(ctx, "GET", path, nil, &out, opts...)
	if err != nil {
		return nil, err
	}
	return &out, err
}