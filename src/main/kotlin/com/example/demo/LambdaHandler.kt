package com.example.demo

import com.amazonaws.serverless.proxy.model.AwsProxyRequest
import com.amazonaws.serverless.proxy.model.AwsProxyResponse
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler

class LambdaHandler : RequestHandler<AwsProxyRequest, AwsProxyResponse> {
    companion object {
        private val handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(DemoApplication::class.java)
    }

    override fun handleRequest(
        input: AwsProxyRequest,
        context: Context
    ): AwsProxyResponse {
        return handler.proxy(input, context)
    }
}