package ru.frostovoi.utils

sealed class Res{
    object Error : Res()
    object Success : Res()
}

