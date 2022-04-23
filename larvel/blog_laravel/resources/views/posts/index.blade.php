@extends('layouts.main')

@section('title')
index
@endsection


 @section('content')   

<div class="d-flex justify-content-center my-5">
    <a class="btn btn-success" href="{{route('posts.create')}}">Create post</a>
</div>

<table class="table mb-5">
  <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col">Title</th>
      <th scope="col">Posted by</th>
      <th scope="col">Created at</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
    
    @foreach ($posts as $post)

    <tr>
   
      <td>{{$post->id}}</td>
      <td>{{$post->title}}</td>
      @if($post->user_id)
      <td>{{$post->user->name}}</td>
      @else 
      <td>Anonymous</td>
      @endif
      
      <td>{{date('Y-m-d',strtotime($post->created_at))}}</td>
      <td><div class="d-flex justify-content-start">
    <a class="btn btn-info mx-1" href="{{route('posts.show',['post'=>$post['id']])}}">View</a>
    <a class="btn btn-primary mx-1" href="{{route('posts.edit',['post'=>$post['id']])}}">Edit</a>
    <form style="margin:0;" action="{{route('posts.destroy',['post'=>$post['id']])}}" method="POST">
        @method('DELETE')
    @csrf
    <button class="btn btn-danger mx-1 " type="submit" data-bs-toggle="modal" data-bs-target="#exampleModal">Delete</button>
   
        
        </form>

</div></td>
    </tr>
    @endforeach
  </tbody>
</table>

{{$posts->links()}}
<!-- Modal -->
<!-- <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Delete ?!</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        Do you really  want to delete this post ?!
      </div>
      <div class="modal-footer">
        <a type="button" class="btn btn-light" data-bs-dismiss="modal">Cancel</a>
        
         <form action="#" method="POST">
        @method('DELETE')
    @csrf -->
        <!-- <button type="submit" class="btn btn-danger">Delete</button> -->
        
        <!-- </form> -->
       
      <!-- </div>
    </div>
  </div>
</div> --> 
@endsection


