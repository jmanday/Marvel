package com.manday.marvel.ui.CharacterDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.manday.marvel.data.datasource.net.models.CharacterEntity
import com.manday.marvel.ui.viewmodels.CharacterDetailViewModel


@Composable
private fun CharacterName(name: String) {
    Text(
        text = name,
        style = MaterialTheme.typography.h5,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .wrapContentWidth(Alignment.Start)
    )
}

@Composable
private fun CharacterDescription(description: String) {
    Text(
        text = description,
        style = MaterialTheme.typography.subtitle1,
        modifier = Modifier
            .padding(horizontal = 4.dp)
    )
}

@Composable
fun CharacterDetailContent(
    characterDetailViewModel: CharacterDetailViewModel,
    character: CharacterEntity
) {
    Surface {
        Column(Modifier.fillMaxWidth()) {
            CharacterName(character.name)
            CharacterDescription(character.description)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterNamePreview() {
    Column(Modifier.fillMaxWidth()) {
        CharacterName("A.I.M")
        CharacterDescription("una descripción sobre el personaje que aparece")
    }
}
