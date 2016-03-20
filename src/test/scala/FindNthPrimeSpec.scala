import net.projecteuler.PrimeFinder
import org.scalatest.{Matchers, WordSpec}

/**
  * Created by mrodrigues on 20/03/2016.
  */
class FindNthPrimeSpec extends WordSpec with Matchers {

  "Nth prime finder" should {

    "return 13" when {

       "asked for the 6th prime" in {
         val result = PrimeFinder.findNth(6)

         result should be (13)
       }

    }

    "return 104743" when {

      "asked for the 10001th prime" in {
        val result = PrimeFinder.findNth(10001)

        result should be (104743)
      }

    }

    "return 2 and make everyone cry" when {

      "asked for the 1st prime" in {
        val result = PrimeFinder.findNth(1)

        result should be (2)
      }

    }

  }

}
