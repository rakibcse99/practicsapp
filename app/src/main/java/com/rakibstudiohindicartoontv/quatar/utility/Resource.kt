package com.rakibstudiohindicartoontv.quatar.utility

sealed class Resource<T>(val data: T?=null, val massage: String?=null){

    class Succecss<T>(data: T?= null): Resource<T>(data = data)

    class Error<T>(massage: String,data: T?=null): Resource<T>(data,massage)

   class Loading<T>: Resource<T>()


}