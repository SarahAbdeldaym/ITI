

@extends('layouts.main')

@section('title')
comment create
@endsection



@section('content')
<form action="/posts/{{$postId}}/comments" method="post">
    @csrf
<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">Comment</label>
  <textarea name="body" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
</div>
<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Comment Creator</label>
<select  name="user_id" class="form-select" aria-label="Default select example">
  <option value="" name="user_id">---</option>
  @foreach ($users as $user)
  
  <option value ="{{$user->id}}" name="user_id">{{$user->name}}</option> 
  @endforeach
  
</select>
</div>
<button type="submit" class="btn btn-success">Write a Comment</button>

</form>

@endsection