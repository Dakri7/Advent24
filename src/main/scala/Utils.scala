package utils

import sttp.client4.quick
import sttp.client4.Response

class Utils {
  val response: Response[String] = quickRequest
  .get(uri"https://httpbin.org/get")
  .send()

    println(response.code)
    // prints: 200

    println(response.body)
    // prints some JSON string
}
