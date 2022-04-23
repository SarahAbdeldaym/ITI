<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\User;
use App\Models\Post;
use Illuminate\Support\Arr;
use League\CommonMark\Extension\Attributes\Node\Attributes;
use Illuminate\Pagination\LengthAwarePaginator;
use App\Models\Comment;



class PostController extends Controller {
    public function index() {
        $posts = Post::paginate(5);

        return view('posts.index', ['posts' => $posts]);
    }


    public function create() {
        $users = User::all();

        return view('posts.create', ['users' => $users]);
    }
    public function store(Request $request) {
        $input = $request->all();


        $post = Post::create([
            'title' => $input['title'],
            'description' => $input['description'],
            'user_id' => $input['user_id'] ? $input['user_id'] : null,

        ]);
        return to_route('posts.index');
    }


    public function edit($postId) {
        $post = Post::find($postId);
        $users = User::all();
        return view('posts.edit', ['users' => $users, 'post' => $post]);
    }
    public function show($postId) {
        $post = Post::find($postId);
        $comments = Comment::where('commentable_id', $postId)->where('commentable_type', Post::class)->get();
        return view('posts.show', ['post' => $post, 'comments' => $comments]);
    }

    public function destroy($postId) {
        Post::where('id', $postId)->delete();
        return to_route('posts.index');
    }

    public function update($postId, Request $request) {


        $input = $request->all();

        Post::where('id', $postId)->update([
            'title' => $input['title'],
            'description' => $input['description'],
            'user_id' => $input['user_id'] ? $input['user_id'] : null,
        ]);
        return to_route('posts.index');
    }
}
