package open.space.consumer.messaging

import open.space.consumer.messaging.messages.MessageDeserializer
import open.space.consumer.messaging.messages.NewsMessage
import org.springframework.amqp.AmqpRejectAndDontRequeueException
import org.springframework.amqp.core.Message
import org.springframework.amqp.core.MessageListener
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
class NewsListener(
    private val messageSerializer: MessageDeserializer<NewsMessage>
) : MessageListener {

    @RabbitListener(queues = ["news-\${area.country.name}-\${area.region.name}"])
    override fun onMessage(message: Message) {
        try {
            val messageEnvelope = messageSerializer.deserializeMessageEnvelope(
                message = message,
                bodyClass = NewsMessage::class.java
            )
            println(messageEnvelope.data)

        } catch (e: Exception) {
            println("Exception on receiving consumer queue message: $e")
            throw AmqpRejectAndDontRequeueException(e)
        }
    }
}
