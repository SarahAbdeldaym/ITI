<?php

class ConnectToAPI
{
    public static function api_connect($id)
    {

        $endpoint_url = api_url . $id . "&APPID=" . api_key;
        $client = new \GuzzleHttp\Client();
        $response = $client->get($endpoint_url);
        return json_decode($response->getBody(), true);
    }
}