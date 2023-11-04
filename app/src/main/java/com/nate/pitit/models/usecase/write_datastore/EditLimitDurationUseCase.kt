package com.nate.pitit.models.usecase.write_datastore

import com.nate.pitit.models.repository.DataStoreRepository
import javax.inject.Inject

class EditLimitDurationUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {

    suspend operator fun invoke(duration: Int){
        dataStoreRepository.writeLimitDurationToDatastore(duration)
    }
}