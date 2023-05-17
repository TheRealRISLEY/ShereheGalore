package com.example.shereheapp

class book {

    var book_name:String? = null
    var book_email:String? = null
    var book_date:String? = null
    var book_location:String? = null
    var book_number:String? = null

    constructor(
        book_name: String?,
        book_email: String?,
        book_date: String?,
        book_location: String?,
        book_number: String?
    ) {
        this.book_name = book_name
        this.book_email = book_email
        this.book_date = book_date
        this.book_location = book_location
        this.book_number = book_number
    }
}