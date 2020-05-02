package com.chsy.fct.config

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class Authentication(val pass: Boolean = true)