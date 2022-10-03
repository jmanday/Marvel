package com.example.bestbuy.data.models

data class CharactersResponse(
    private val code: Int,
    private val status: String,
    private val copyright: String,
    private val etag: String,
    val data: CharactersData

)

data class CharactersData(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<CharactersResults>
)

data class CharactersResults(
    val id: String,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnail: CharacterThumbnail
)

data class CharacterThumbnail(
    val path: String,
    val extension: String
)

fun CharactersResponse.toCharacterEntity() =
    with(this.data.results.first()) {
        CharacterEntity(
            name = this.name,
            description = this.description,
            thumbnailPath = this.thumbnail.path,
        )
    }
