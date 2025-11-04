package example.monitoring.example_monitring_app

import kotlinx.coroutines.runBlocking
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.time.LocalTime
import java.util.ArrayList
import java.util.Arrays
import java.util.Date

@SpringBootApplication
class ExampleMonitringAppApplication

fun main(args: Array<String>) {
	runApplication<ExampleMonitringAppApplication>(*args)
}

@RestController
class MainController {

    val ARRAY = ArrayList<Long>()

    @GetMapping("/job")
    fun load(): Mono<String> {
        runBlocking {
            for (i in 1..1_000_000) {
                val time = Date().time
                ARRAY.add(time * i)
            }
        }
        return Mono.just("Job success: ${ARRAY.size}")
    }
}