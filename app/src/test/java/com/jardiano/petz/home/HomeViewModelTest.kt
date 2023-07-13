package com.jardiano.petz.home

import com.jardiano.petz.domain.entity.HearthStone
import com.jardiano.petz.domain.usecase.GetHearthstoneListUseCase
import com.jardiano.petz.ui.pages.home.HomeViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class HomeViewModelTest {
    private val mock = HearthStone("mock", "mock", "mock", "mock", "mock", "mock", "mock", 1, 1, 1)

    private val getHearthstoneListUseCase = mockk<GetHearthstoneListUseCase>()
    private val viewModel = HomeViewModel(getHearthstoneListUseCase)

    @Test(expected = Throwable::class)
    fun `GIVEN HomeViewModelTest WHEN getHearthstoneListUseCase returns Success THEN returns data`() =
        runTest {
            val expected: List<HearthStone> = listOf(mock, mock)
            coEvery { getHearthstoneListUseCase.invoke() } returns expected
            viewModel.hearthStoneList
            coVerify { getHearthstoneListUseCase.invoke() }
        }

    @Test(expected = Throwable::class)
    fun `GIVEN HomeViewModelTest WHEN getHearthstoneListUseCase returns Failure THEN throw exception`() =
        runTest {
            val exception = Exception()
            coEvery { getHearthstoneListUseCase.invoke() } throws exception
            viewModel.hearthStoneList
        }
}