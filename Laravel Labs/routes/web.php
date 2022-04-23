<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\PostController;
use App\Models\User;
use Laravel\Socialite\Facades\Socialite;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});

Route::get('/posts', [PostController::class, 'index'])->name('posts.index')->middleware('auth');
Route::get('/posts/create', [PostController::class, 'create'])->name('posts.create')->middleware('auth');
Route::get('/posts/{post}', [PostController::class, 'show'])->name('posts.show')->middleware('auth');
Route::get('/posts/{post}/edit', [PostController::class, 'edit'])->name('posts.edit')->middleware('auth');
Route::post('/posts', [PostController::class, 'store'])->name('posts.store')->middleware('auth');
Route::put('/posts/{post}', [PostController::class, 'update'])->name('posts.update')->middleware('auth');
Route::delete('/posts/{post}', [PostController::class, 'destroy'])->name('posts.destroy')->middleware('auth');

Route::get('/posts/ajax/show', [PostController::class, 'ajaxShow'])->name('posts.ajax.show');


Auth::routes();

Route::get('/home', [App\Http\Controllers\HomeController::class, 'index'])->name('home');


Route::get('/auth/github/redirect', function () {
    return Socialite::driver('github')->redirect();
});

Route::get('/auth/github/callback', function () {
    $user = Socialite::driver('github')->stateless()->user();

    $newUser = User::where('email', '=', $user->email)->first();
    if(!$newUser) {
        $newUser = new User();
        $newUser->name = $user->name;
        $newUser->email = $user->email;
        $newUser->save();
    }
    Auth::login($newUser);

    return redirect()->route('home')->with("gitcontent", 'Show info of Github');
    //return redirect()->route('home');
});


Route::get('/auth/google/redirect', function () {
    return Socialite::driver('google')->redirect();
});


Route::get('/auth/google/callback', function () {
    $user = Socialite::driver('google')->stateless()->user();

    $newUser = User::where('email', '=', $user->email)->first();
    if(!$newUser) {
        $newUser = new User();
        $newUser->name = $user->name;
        $newUser->email = $user->email;
        $newUser->save();
    }
    Auth::login($newUser);

    return redirect()->route('home');
});


Route::get('/auth/facebook/redirect', function () {
    return Socialite::driver('facebook')->redirect();
});


Route::get('/auth/facebook/callback', function () {
    $user = Socialite::driver('facebook')->stateless()->user();

    $newUser = User::where('email', '=', $user->email)->first();
    if(!$newUser) {
        $newUser = new User();
        $newUser->name = $user->name;
        $newUser->email = $user->email;
        $newUser->save();
    }
    Auth::login($newUser);

    return redirect()->route('home');
});
