package open.space.consumer.messaging.messages

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.Instant
import java.util.UUID

/**
 * Envelope for queue messages
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class MessageWrapper<out T>(
    val id: UUID = UUID.randomUUID(),
    val data: T
)
