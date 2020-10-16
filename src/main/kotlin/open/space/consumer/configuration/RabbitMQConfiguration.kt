package open.space.consumer.configuration

import org.springframework.amqp.core.*
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitAdmin
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component


@Configuration
class RabbitMQConfiguration(
    private val queueProperties: RabbitMQProperties
) {

    @Bean
    fun bindings(): List<Binding> {
        return queueProperties.topics.map {
            println(it)
            BindingBuilder.bind(queue()).to(exchange()).with(it).noargs()
        }
    }
    @Bean
    fun exchange() : Exchange {
        return TopicExchange(queueProperties.exchangeName)
    }
    @Bean
    fun queue(): Queue {
        return Queue(queueProperties.queueName)
    }

    @Bean
    fun rabbitAdmin(connectionFactory: ConnectionFactory): RabbitAdmin {
        val admin = RabbitAdmin(connectionFactory)
        admin.declareExchange(exchange())
        admin.declareQueue(queue())
        bindings().forEach{admin.declareBinding(it)}
        return admin
    }

}

@Component
@ConfigurationProperties(prefix = "queue-properties")
class RabbitMQProperties {
    lateinit var topics: List<String>
    lateinit var queueName: String
    lateinit var exchangeName: String
}