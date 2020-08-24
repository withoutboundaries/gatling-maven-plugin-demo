package endPoint

import io.gatling.http.Predef._
import io.gatling.core.Predef._
import utils.{DataGenerator, PayloadUtil}

object PublicAgreement {

  val API_PUBLIC_AGREEMENT ="?pe/cusstId=974"
  val csvFeeder = csv("data/testData")

  val randomValues = DataGenerator.generateValues

  val headers = Map("requestId" -> "${randomUUID}")

  val createPublicAgreement = exec()
    .feed(csvFeeder)
    .feed(randomValues)
    .exec(http ("createDog_Pe")
        .post (API_PUBLIC_AGREEMENT)
        .headers(headers)
        .body(PayloadUtil.getPublicAgreement)
        .check(status.is(201))
        .check(jsonPath("$.pubAgr").is("CMDPE-22656"))
    )
}
