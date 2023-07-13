package com.jardiano.petz.domain.usecase


import com.jardiano.petz.core.ApiException
import com.jardiano.petz.domain.entity.HearthStone
import com.jardiano.petz.domain.repository.HearthstoneRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class GetHearthstoneListUseCaseTest {
    private val mock = HearthStone("mock", "mock", "mock", "mock", "mock", "mock", "mock", 1, 1, 1)

    private val repository = mockk<HearthstoneRepository>()
    private val useCase = GetHearthstoneListUseCase(repository)


    @Test
    fun `GIVEN GetHearthstoneListUseCase WHEN repository returns Success THEN returns data`() =
        runTest {
            val expected: List<HearthStone> = listOf(mock)
            coEvery { repository.getHearthstoneList() } returns expected
            val output = useCase()
            output.first()
            coVerify { repository.getHearthstoneList() }
            Assert.assertEquals(1, output.count())
        }


    @Test(expected = Throwable::class)
    fun `GIVEN GetHearthstoneListUseCase WHEN repository returns Failure THEN throw exception`() =
        runTest {
            val exception = ApiException()
            coEvery { repository.getHearthstoneList() } throws exception
            useCase().first()
        }

}

