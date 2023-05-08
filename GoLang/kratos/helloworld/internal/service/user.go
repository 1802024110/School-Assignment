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

func (s *RealWorldService) Register(ctx context.Context, req *v1.RegisterRequest) (*v1.UserReply, error) {
	return &v1.UserReply{}, nil
}
func (s *RealWorldService) GetCurrentUser(ctx context.Context, req *v1.NullRequest) (*v1.UserReply, error) {
	return &v1.UserReply{}, nil
}
func (s *RealWorldService) UpdateUser(ctx context.Context, req *v1.UpdateRequest) (*v1.UserReply, error) {
	return &v1.UserReply{}, nil
}
func (s *RealWorldService) GetProfile(ctx context.Context, req *v1.GetCurrentUserRequest) (*v1.ProfileReply, error) {
	return &v1.ProfileReply{}, nil
}
func (s *RealWorldService) FollowUser(ctx context.Context, req *v1.FollowUserRequest) (*v1.ProfileReply, error) {
	return &v1.ProfileReply{}, nil
}
func (s *RealWorldService) UnfollowUser(ctx context.Context, req *v1.UnfollowUserRequest) (*v1.ProfileReply, error) {
	return &v1.ProfileReply{}, nil
}
func (s *RealWorldService) ListArticles(ctx context.Context, req *v1.ListArticlesRequest) (*v1.ArticlesReply, error) {
	return &v1.ArticlesReply{}, nil
}
func (s *RealWorldService) FeedArticles(ctx context.Context, req *v1.FeedArticlesRequest) (*v1.ArticlesReply, error) {
	return &v1.ArticlesReply{}, nil
}
func (s *RealWorldService) GetArticle(ctx context.Context, req *v1.GetArticleRequest) (*v1.ArticleReply, error) {
	return &v1.ArticleReply{}, nil
}
func (s *RealWorldService) CreateArticle(ctx context.Context, req *v1.CreateArticleRequest) (*v1.ArticleReply, error) {
	return &v1.ArticleReply{}, nil
}
func (s *RealWorldService) UpdateArticle(ctx context.Context, req *v1.UpdateArticleRequest) (*v1.ArticleReply, error) {
	return &v1.ArticleReply{}, nil
}
func (s *RealWorldService) DeleteArticle(ctx context.Context, req *v1.GetArticleRequest) (*v1.NullReply, error) {
	return &v1.NullReply{}, nil
}
func (s *RealWorldService) AddComment(ctx context.Context, req *v1.AddCommentRequest) (*v1.CommentReply, error) {
	return &v1.CommentReply{}, nil
}
func (s *RealWorldService) GetComments(ctx context.Context, req *v1.GetArticleRequest) (*v1.CommentsReply, error) {
	return &v1.CommentsReply{}, nil
}
func (s *RealWorldService) DeleteComment(ctx context.Context, req *v1.DeleteCommentRequest) (*v1.NullReply, error) {
	return &v1.NullReply{}, nil
}
func (s *RealWorldService) FavoriteArticle(ctx context.Context, req *v1.GetArticleRequest) (*v1.ArticleReply, error) {
	return &v1.ArticleReply{}, nil
}
func (s *RealWorldService) UnfavoriteArticle(ctx context.Context, req *v1.GetArticleRequest) (*v1.ArticleReply, error) {
	return &v1.ArticleReply{}, nil
}
func (s *RealWorldService) GetTags(ctx context.Context, req *v1.NullRequest) (*v1.TagsReply, error) {
	return &v1.TagsReply{}, nil
}
