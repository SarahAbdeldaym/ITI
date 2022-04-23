<div class="card">
    <div class="card-body">
      <h5 class="card-title">Title:</h5>
      <p class="card-text">{{ $post->title }}</p>
      <h5 class="card-title">Description:</h5>
      <p class="card-text">{{ $post->description }}</p>
      <h5 class="card-title">Posted by:</h5>
      <p class="card-text">{{ $post->user->name }}</p>
      <p class="card-text">{{ $post->user->email }}</p>
      <h5 class="card-title">Created at:</h5>
      <p class="card-text">{{ $post->user->created_at}}</p>
      @if(!empty($post->image))
      <div style="background-image: url({{ Storage::url($post->image) }}); background-size:cover; height:200px; width:200px;"></div>
      @endif
    </div>
 </div>