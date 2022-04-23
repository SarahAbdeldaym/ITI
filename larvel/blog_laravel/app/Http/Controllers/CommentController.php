<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\User;
use App\Models\Comment;
use App\Models\Post;

class CommentController extends Controller {
    public function create($postId) {

        $users = User::all();
        return view('comments.create', ['users' => $users, 'postId' => $postId]);
    }



    public function store($postId, Request $request) {
        $input = $request->all();
        $comment = Comment::create([
            'body' => $input['body'],
            'user_id' => $input['user_id'] ? $input['user_id'] : null,
            'commentable_id' => $postId,
            'commentable_type' => Post::class

        ]);
        return to_route('posts.show', ['post' => $postId]);
    }



    public function edit($commentId) {
        $comment = Post::find($commentId);
        $users = User::all();

        return view('comments.edit', ['comment' => $comment, 'users' => $users]);
    }

    public function update($commentId, Request $request) {

        $comment = Comment::find($commentId);

        $post_id = $comment->commentable_id;
        $input = $request->all();

        Comment::where('id', $commentId)->update([
            'body' => $input['body'],
            'user_id' => $input['user_id'] ? $input['user_id'] : null,
        ]);

        return to_route('posts.show', ['post' => $post_id]);
    }


    public function destroy($commentId) {
        $comment = Comment::find($commentId);

        $post_id = $comment->commentable_id;
        Comment::where('id', $commentId)->delete();
        return to_route('posts.show', ['post' => $post_id]);
    }
}
