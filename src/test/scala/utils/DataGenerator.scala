package utils

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

import scala.util.Random


object DataGenerator {
 def generateValues = Iterator.continually(
   Map (
     "randomUUID" -> UUID.randomUUID().toString,
     "date" -> DateTimeFormatter.ISO_INSTANT.format(ZonedDateTime.now),
     "randomEmail" -> (Random.alphanumeric.take(7)+"@gmail.com"),
     "randomInt" -> Random.nextInt(9999).toString
   )
 )
}
