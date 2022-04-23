<?php

namespace App\Http\Controllers\Api;

use App\Models\Post;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Http\Resources\PostResource;

class PostController extends Controller
{
    public function index()
    {
        
        $posts = Post::with('user')->paginate(5);
        

        return PostResource::collection($posts);
    }

    public function show(Post $post)
    {
        
        return new PostResource($post);
    }

    public function store(Request $request)
    {

        $this->validate($request,[
            'title' => "required|min:3|unique:posts,title",
            'description' => 'required|min:10',
        ]);
        $requestData = $request->all();
        $post = Post::create($requestData);
       

        return new PostResource($post);
    }
}
