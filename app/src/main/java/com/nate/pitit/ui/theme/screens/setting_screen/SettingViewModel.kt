package com.nate.pitit.ui.theme.screens.setting_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nate.pitit.data.local.entity.AccountDataTransferObject

import com.nate.pitit.models.usecase.read_datastore.GetCurrencyUseCase
import com.nate.pitit.models.usecase.read_datastore.GetExpLimitUseCase
import com.nate.pitit.models.usecase.read_datastore.GetLimitDurationUseCase
import com.nate.pitit.models.usecase.read_datastore.GetLimitKeyUseCase
import com.nate.pitit.models.usecase.write_database.EraseTransactionUseCase
import com.nate.pitit.models.usecase.write_database.InsertAccountsUseCase
import com.nate.pitit.models.usecase.write_datastore.EditExpLimitUseCase
import com.nate.pitit.models.usecase.write_datastore.EditLimitDurationUseCase
import com.nate.pitit.models.usecase.write_datastore.EditLimitKeyUseCase
import com.nate.pitit.models.usecase.write_datastore.EraseDataStoreUseCase
import com.nate.pitit.ui.theme.screens.home_screen.Account
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val getCurrencyUseCase: GetCurrencyUseCase,
    private val insertAccountsUseCase: InsertAccountsUseCase,
    private val eraseTransactionUseCase: EraseTransactionUseCase,
    private val getExpenseLimitUseCase: GetExpLimitUseCase,
    private val editExpenseLimitUseCase: EditExpLimitUseCase,
    private val getLimitKeyUseCase: GetLimitKeyUseCase,
    private val editLimitKeyUseCase: EditLimitKeyUseCase,
    private val editLimitDurationUseCase: EditLimitDurationUseCase,
    private val getLimitDurationUseCase: GetLimitDurationUseCase,
    private val eraseDatastoreUseCase: EraseDataStoreUseCase
) : ViewModel() {

    var currency = MutableStateFlow(String())
        private set

    var expenseLimit = MutableStateFlow(0.0)
        private set

    var expenseLimitDuration = MutableStateFlow(0)
        private set

    var reminderLimit = MutableStateFlow(false)
        private set

    init {
        viewModelScope.launch(IO) {
            getCurrencyUseCase().collect { selectedCurrency->
                currency.value = selectedCurrency
            }
        }

        viewModelScope.launch(IO) {
            getExpenseLimitUseCase().collect { expenseAmount ->
                expenseLimit.value = expenseAmount
            }
        }

        viewModelScope.launch(IO) {
            getLimitKeyUseCase().collect { limitKey ->
                reminderLimit.value = limitKey
            }
        }

        viewModelScope.launch(IO) {
            getLimitDurationUseCase().collect { duration ->
                expenseLimitDuration.value = duration
            }
        }
    }

    fun eraseTransaction() {
        viewModelScope.launch(IO) {
            // reset account
            insertAccountsUseCase(
                listOf(
                    AccountDataTransferObject(1, Account.CASH.title, 0.0, 0.0, 0.0),
                    AccountDataTransferObject(2, Account.BANK.title, 0.0, 0.0, 0.0),
                    AccountDataTransferObject(3, Account.CARD.title, 0.0, 0.0, 0.0)
                )
            )
            // erase transactions
            eraseTransactionUseCase()
            // erase datastore
            eraseDatastoreUseCase()
        }
    }

    fun editExpenseLimit(amount: Double) {
        viewModelScope.launch(IO) {
            editExpenseLimitUseCase(amount)
        }
    }

    fun editLimitKey(enabled: Boolean) {
        viewModelScope.launch(IO) {
            editLimitKeyUseCase(enabled)
        }
    }

    fun editLimitDuration(duration: Int) {
        viewModelScope.launch(IO) {
            editLimitDurationUseCase(duration)
        }
    }
}