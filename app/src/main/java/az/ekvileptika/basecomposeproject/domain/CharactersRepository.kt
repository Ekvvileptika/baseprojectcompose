package az.ekvileptika.basecomposeproject.domain

import az.ekvileptika.basecomposeproject.data.characters.ResponseModel
import az.ekvileptika.basecomposeproject.utils.ResponseResources
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {
    suspend fun getAllCharacters(): ResponseResources<ResponseModel>
    suspend fun charactersListFlow(): Flow<ResponseResources<ResponseModel>>
}