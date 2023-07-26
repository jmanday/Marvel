package com.jmanday.data.mapper

import com.jmanday.domain.test.character
import com.jmanday.domain.test.characterList
import com.jmanday.domain.test.thumbnail
import com.jmanday.remotedatasource.test.characterResponseDto
import com.jmanday.remotedatasource.test.characterResultDto
import com.jmanday.remotedatasource.test.characterThumbnailDto
import org.junit.Test

import org.junit.Assert.*

class CharacterDtoMapperTest {
    @Test
    fun characterThumbnailMapper() {
        val mappedThumbnail = characterThumbnailDto.toThumbnail()
        assertEquals(mappedThumbnail, thumbnail)
    }

    @Test
    fun characterResultMapper() {
        val mappedCharacter = characterResultDto.toCharacter()
        assertEquals(mappedCharacter, character)
    }

    @Test
    fun characterResponseMapper() {
        val mappedCharacterList = characterResponseDto.toCharacterList()
        assertEquals(mappedCharacterList, characterList)
    }
}