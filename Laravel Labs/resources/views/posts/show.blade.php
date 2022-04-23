@extends('layouts.app')

@section('title')Show Page @endsection

@section('content')
<div class="card">
    <div class="card-header">
      Post Info
    </div>
    <div class="card-body">
      <h5 class="card-title" style="display:inline">Title:-</h5>
      <p class="card-text" style="display:inline">{{ $post->title }}</p>
      <br/>
      <h5 class="card-title" style="display:inline">Description:-</h5>
      <p class="card-text" >{{ $post->description }}</p>
    </div>
</div>

<div class="card mt-5">
    <div class="card-header">
      Post Creator Info
    </div>
    <div class="card-body">
      <h5 class="card-title" style="display:inline">Name:-</h5>
      <p class="card-text" style="display:inline">{{$post->user ? $post->user->name : 'user not found'}}</p>
      <br/>
      <h5 class="card-title" style="display:inline">Email:-</h5>
      <p class="card-text" style="display:inline">{{$post->user ? $post->user->email : 'email not found'}}</p>
      <br/>
       <h5 class="card-title" style="display:inline">Created at:-</h5>
      <p class="card-text" style="display:inline">{{$post->created_at->format('l')}} {{$post->created_at->format('d')}}th of {{$post->created_at->format('F')}} {{$post->created_at->format('Y')}} {{$post->created_at->format('H:i:s A')}}</p>
    </div>
</div>
@endsection