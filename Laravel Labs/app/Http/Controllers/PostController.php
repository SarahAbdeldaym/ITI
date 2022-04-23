<?php

namespace App\Http\Controllers;

use App\Models\Post;
use App\Models\User;
use Illuminate\Http\Request;
use App\Http\Requests\StorePostRequest;
use App\Http\Requests\UpdatePostRequest;

class PostController extends Controller
{
    private $allPosts;

    public function __construct() {
        // $this->allPosts = [
        //     ['id' => 1, 'title' => 'laravel','description'=>'laravel is awsome framework', 'posted_by' => 'Ahmed', 'email'=>'ahmed@gmail.com' ,'created_at' => '2021-03-20'],
        //     ['id' => 2, 'title' => 'PHP','description'=>'PHP is awsome framework', 'posted_by' => 'Mohamed', 'email'=>'mohamed@gmail.com' , 'created_at' => '2021-04-15'],
        //     ['id' => 3, 'title' => 'Javascript','description'=>'Javascript is awsome framework', 'posted_by' => 'Ali', 'email'=>'ali@gmail.com' , 'created_at' => '2021-06-01'],
        // ];
        //$this->allPosts = Post::all();
        $this->allPosts = Post::with('user')->paginate(5);
        //$this->allPosts = Post::paginate(5);
    }
    public function index()
    {
        return view('posts.index', ['posts' => $this->allPosts]);
        //return view('posts.index', compact('posts'));
    }

    public function ajaxShow(Request $request)
    {
        $post = Post::where("id", $request->post)->first();
        return view('posts.ajax_show', compact('post'));
    }

    public function show($postId)
    {
        //dd($this->allPosts[$postId - 1]);
        //$post = ['id' => $postId, 'title' => 'laravel', 'description' => 'laravel is awsome framework', 'posted_by' => 'Ahmed', 'email'=>'ahmed@gmail.com', 'created_at' => '2021-03-20'];
        // $this->allPosts['id'] = $postId;
        //dd($this->allPosts);
        $post = Post::find($postId); //object of Post model
        return view('posts.show', ['post' => $post , 'users' => User::all()]);
    }

    public function edit($postId)
    {
        $post = Post::find($postId);
        return view('posts.edit',['post' => $post , 'users' => User::all()]);
    }

    public function create()
    {
        
        return view('posts.create',[
            'users' => User::all()
        ]);
    }

    

    public function store(Request $request)
    {
        $this->validate($request,[
            'title' => "required|min:3|unique:posts,title",
            'description' => 'required|min:10',
        ]);

        $requestData = $request->all();
        Post::create($requestData);
        return redirect()->route('posts.index');
    }


    public function update(Request $request,$postId)
    {

        $this->validate($request,[
            'title' => "required|min:3|unique:posts,title,$postId",
            'description' => 'required|min:10',
        ]);
        // $this->validate($request,[
        //     'title' => "required|min:10",
        //     'description' => 'required|min:10',
        // ]);

        $singlePost = Post::findOrFail($postId);
        $singlePost->update([
            'title' => $request->title,
            'description' => $request->description,
            'user_id' => $request->user_id,
        ]);
        return redirect()->route('posts.index');
    }

    public function destroy($postId)
    {
        $singlePost = Post::findOrFail($postId);
        $singlePost->delete();
        return redirect()->route('posts.index');
    }
    
    
}
