package com.byjusassignement.mapper

import com.byjusassignement.model.TheNewsErrorResponse
import com.skydoves.sandwich.ApiErrorModelMapper
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message

object ErrorResponseMapper : ApiErrorModelMapper<TheNewsErrorResponse> {

  override fun map(apiErrorResponse: ApiResponse.Failure.Error<*>): TheNewsErrorResponse {
    return TheNewsErrorResponse(apiErrorResponse.statusCode.code, apiErrorResponse.message())
  }
}
