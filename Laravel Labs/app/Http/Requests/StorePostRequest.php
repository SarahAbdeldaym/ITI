<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;
use Illuminate\Validation\Rule;

class StorePostRequest extends FormRequest
{
    /**
     * Determine if the user is authorized to make this request.
     *
     * @return bool
     */
    public function authorize()
    {
        return true;
    }

    /**
     * Get the validation rules that apply to the request.
     *
     * @return array
     */
    public function rules()
    {
        return [
            'title' => ['required', 'min:3', Rule::unique('posts')],
            'description' => ['required', 'min:10'],
        ];
    }

    public function messages()
    {
        return  [
            'title.required' => 'Title is required',
            'title.min' => 'Title length must be more than 3 chars',
            'title.unique' => 'Title length must be unique',
            'description.required' => 'Description is required',
            'description.min' => 'Description length must be more than 10 chars',
        ];
    }
}
