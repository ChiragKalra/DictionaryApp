package com.chiragkalra.dictionary

import java.io.Serializable

data class ResultItem(
    val type: String,
    val definition: String,
    val example: String?,
    val imageUrl: String?,
    val emoji: String?,
): Serializable

data class Response (
    val definitions: List<ResultItem>,
    val word: String,
    val pronunciation: String?
): Serializable