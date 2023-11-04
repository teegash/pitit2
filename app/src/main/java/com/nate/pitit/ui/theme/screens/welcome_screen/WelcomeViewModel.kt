package com.nate.pitit.ui.theme.screens.welcome_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nate.pitit.data.local.entity.AccountDataTransferObject
import com.nate.pitit.models.CurrencyModel
import com.nate.pitit.models.usecase.GetCurrencyUseCase
import com.nate.pitit.models.usecase.write_database.InsertAccountsUseCase
import com.nate.pitit.models.usecase.write_datastore.EditCurrencyUseCase
import com.nate.pitit.models.usecase.write_datastore.EditOnBoardingKeyUseCase
import com.nate.pitit.ui.theme.screens.home_screen.Account
import com.nate.pitit.ui.theme.screens.welcome_screen.components.OnBoardingPage

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val editOnBoardingUseCase: EditOnBoardingKeyUseCase,
    private val editCurrencyUseCase: EditCurrencyUseCase,
    private val insertAccountsUseCase: InsertAccountsUseCase,
    getCurrencyUseCase: GetCurrencyUseCase
) : ViewModel() {

    var countryCurrencies = mutableStateOf(emptyMap<Char, List<CurrencyModel>>())
        private set

    init {
        countryCurrencies.value = getCurrencyUseCase().groupBy { it.country[0] }
    }

    val listOfPages: State<List<OnBoardingPage>> = mutableStateOf(listOf(
        OnBoardingPage.FirstPage,
        OnBoardingPage.SecondPage,
        OnBoardingPage.ThirdPage
    ))

    fun saveOnBoardingState(completed: Boolean) {
        viewModelScope.launch(IO) {
            editOnBoardingUseCase(completed = completed)
        }
    }

    fun saveCurrency(currency: String) {
        viewModelScope.launch(IO) {
            editCurrencyUseCase(currency)
        }
    }

    fun createAccounts() {
        viewModelScope.launch(IO) {
            insertAccountsUseCase.invoke(
                listOf(
                    AccountDataTransferObject(1, Account.CASH.title, 0.0, 0.0, 0.0),
                    AccountDataTransferObject(2, Account.BANK.title, 0.0, 0.0, 0.0),
                    AccountDataTransferObject(3, Account.CARD.title, 0.0, 0.0, 0.0)
                )
            )
        }
    }
}