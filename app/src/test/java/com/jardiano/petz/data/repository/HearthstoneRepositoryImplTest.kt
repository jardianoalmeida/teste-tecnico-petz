import androidx.paging.ExperimentalPagingApi
import com.jardiano.petz.data.remote.HearthstoneCloudStore
import com.jardiano.petz.data.remote.entity.HearthstoneListResponse
import com.jardiano.petz.data.remote.entity.HearthstoneResponse
import com.jardiano.petz.data.repository.HearthstoneRepositoryImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

@OptIn(ExperimentalPagingApi::class)
class HearthstoneRepositoryImplTest {
    private val mock = HearthstoneListResponse(
        listOf(
            HearthstoneResponse("mock", "mock", "mock", "mock", "mock", "mock", "mock", 1, 1, 1),
        ),
    )

    private val dataStore = mockk<HearthstoneCloudStore>()
    private val hearthstoneRepository = HearthstoneRepositoryImpl(dataStore)

    @Test
    fun `GIVEN Repository WHEN getHearthstoneList THEN model is filled`() = runTest {
        val expected = mock
        coEvery { dataStore.getHearthstoneResponse() } returns expected
        val response = hearthstoneRepository.getHearthstoneList().first()
        Assert.assertNotNull(response)
    }

}

