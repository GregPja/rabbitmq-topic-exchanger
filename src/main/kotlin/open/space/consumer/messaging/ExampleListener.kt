package open.space.consumer.messaging

import open.space.consumer.messaging.messages.MessageDeserializer
import open.space.consumer.messaging.messages.PotatoMessage
import org.springframework.amqp.AmqpRejectAndDontRequeueException
import org.springframework.amqp.core.Message
import org.springframework.amqp.core.MessageListener
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
class CustomerEventsQueueListener(
    private val messageSerializer: MessageDeserializer<PotatoMessage>
) : MessageListener {

    @RabbitListener(queues = ["potato.event.creation"])
    override fun onMessage(message: Message) {
        try {
            println(message)
            val messageEnvelope = messageSerializer.deserializeMessageEnvelope(
                message = message,
                bodyClass = PotatoMessage::class.java
            )

            val eventMessage = messageEnvelope.data

            println(messageEnvelope.data)

        } catch (e: Exception) {
            println("Exception on receiving consumer queue message: $e")
            throw AmqpRejectAndDontRequeueException(e)
        }
    }
}
