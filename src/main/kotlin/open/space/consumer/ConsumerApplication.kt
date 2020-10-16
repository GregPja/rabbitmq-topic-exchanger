package open.space.consumer

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.annotation.PostConstruct

@SpringBootApplication
class ConsumerApplication(
    @Value("\${area.country.name}") private val country: String,
    @Value("\${area.region.name}") private val region: String
) {
    init {
        println(
            """
            |#################################################################
            |    Running application for country $country $region
            |#################################################################
            """.trimMargin()
        )
    }


    @PostConstruct
    fun subscribe(){

    }
}

fun main(args: Array<String>) {
    runApplication<ConsumerApplication>(*args)
}
