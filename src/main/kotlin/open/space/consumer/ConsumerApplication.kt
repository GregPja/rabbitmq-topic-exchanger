package open.space.consumer

import org.springframework.amqp.rabbit.core.RabbitAdmin
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ConsumerApplication(
    @Value("\${area.country.name}") private val country: String,
    @Value("\${area.region.name}") private val region: String,
    private val rabbitAdmin: RabbitAdmin
) {
    init {
        println(
            """
            |#################################################################
            |    Running application for country $country $region
            |#################################################################
            """.trimMargin()
        )
        rabbitAdmin.initialize()
    }

}

fun main(args: Array<String>) {
    runApplication<ConsumerApplication>(*args)
}
