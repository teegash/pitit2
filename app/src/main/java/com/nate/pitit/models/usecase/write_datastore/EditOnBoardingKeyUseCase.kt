package com.nate.pitit.models.usecase.write_datastore

import com.nate.pitit.models.repository.DataStoreRepository
import javax.inject.Inject

class EditOnBoardingKeyUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {

    suspend operator fun invoke(completed: Boolean){
        dataStoreRepository.writeOnboardingKeyToDatastore(completed)
    }
}