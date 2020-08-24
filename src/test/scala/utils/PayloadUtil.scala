package utils

import io.gatling.core.Predef.{StringBody, configuration}
import io.gatling.core.body.Body

import scala.io.Source.fromInputStream

object PayloadUtil {
  def getPublicAgreement: Body = {
    StringBody(getJsonModel("bodies/publicAgreement.json"))
  }

  private def getJsonModel(resourcePath: String): String = {
    val in = getClass.getResourceAsStream(resourcePath)
    fromInputStream(in).getLines().mkString("")
  }
}