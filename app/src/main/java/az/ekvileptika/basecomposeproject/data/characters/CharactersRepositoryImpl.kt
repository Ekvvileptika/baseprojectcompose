package az.ekvileptika.basecomposeproject.data.characters

import az.ekvileptika.basecomposeproject.data.RetrofitApi
import az.ekvileptika.basecomposeproject.domain.CharactersRepository
import az.ekvileptika.basecomposeproject.utils.ResponseResources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import java.lang.Exception
import javax.inject.Inject


class CharactersRepositoryImpl @Inject constructor(
    val api: RetrofitApi
): CharactersRepository {
    override suspend fun charactersListFlow(): Flow<ResponseResources<ResponseModel>> = flowOf(
        try {
            val response = api.getInfo()
            ResponseResources.Success(response)
        } catch (ex: Exception){
            ex.printStackTrace()
            ResponseResources.Failure(message = ex.localizedMessage, data = null)
        }
    )

    override suspend fun getAllCharacters(): ResponseResources<ResponseModel> {
        return try {
            val response = api.getInfo()
            ResponseResources.Success(response)
        } catch (ex: Exception){
            ResponseResources.Failure(message = ex.localizedMessage, data = null)
        }
    }
}