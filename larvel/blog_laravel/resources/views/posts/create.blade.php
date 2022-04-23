
@extends('layouts.main')

@section('title')
create
@endsection





@section('content')
<form action="/posts" method="post">
  @csrf
<div class="mb-3 mt-5">
  <label for="exampleFormControlInput1" class="form-label">Title</label>
  <input name="title" type="text" class="form-control" id="exampleFormControlInput1" placeholder="">
</div>
<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">Description</label>
  <textarea name="description" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
</div>
<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Post Creator</label>
  <select  name="user_id" class="form-select" aria-label="Default select example">
  <option value="" name="user_id">---</option>
  @foreach ($users as $user)
  
  <option value ="{{$user->id}}" name="user_id">{{$user->name}}</option> 
  @endforeach
  
</select>
</div>
<button class="btn btn-primary">Post Comment</button>
</form>
@endsection

