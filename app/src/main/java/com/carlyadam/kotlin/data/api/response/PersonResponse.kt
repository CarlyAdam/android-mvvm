package com.carlyadam.kotlin.data.api.response

import com.carlyadam.kotlin.data.db.Person

data class PersonResponse(
    var persons : List<Person>?
)
