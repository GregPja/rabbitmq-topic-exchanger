package open.space.consumer.messaging.messages
import com.fasterxml.jackson.databind.ObjectMapper

import org.springframework.amqp.core.Message
import org.springframework.stereotype.Component
import java.nio.charset.Charset

interface MessageDeserializer<T>{
    fun deserializeMessageEnvelope(message: Message, bodyClass: Class<out T>): MessageWrapper<T>
}


@Component
class MessageSerializerImpl<T>(
    private val objectMapper: ObjectMapper
) : MessageDeserializer<T> {

    override fun deserializeMessageEnvelope(
        message: Message,
        bodyClass: Class<out T>
    ): MessageWrapper<T> {
        val msg = String(message.body, Charset.defaultCharset())
        val type = objectMapper.typeFactory.constructParametricType(
            MessageWrapper::class.java,
            bodyClass
        )
        return objectMapper.readValue(msg, type)
    }
}
