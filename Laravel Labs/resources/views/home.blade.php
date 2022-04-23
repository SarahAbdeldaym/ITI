@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">{{ __('Dashboard') }}</div>

                <div class="card-body">
                    @if (session('status'))
                        <div class="alert alert-success" role="alert">
                            {{ session('status') }}
                        </div>
                    @endif

                    {{ __('You are logged in!') }}
                </div>
            </div>
        </div>
    </div>
    <div class="row justify-content-center mt-5">
        <div class="col-md-4">
            <a href="/auth/github/redirect" class="btn btn-dark">
                @if(session()->get( 'gitcontent' )) 
                {{ session()->get( 'gitcontent' ) }}
                @else
                {{ __('Connect to Github') }}
                @endif
            </a>
        </div>
        <div class="col-md-4">
            <a href="/auth/google/redirect" class="btn btn-danger">
                {{ __('Connect to Google') }}
            </a>
        </div>
        <div class="col-md-4">
            <a href="/auth/google/redirect" class="btn btn-primary">
                {{ __('Connect to Facebook') }}
            </a>
        </div>
    </div>
</div>
@endsection
